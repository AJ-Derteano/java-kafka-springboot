package com.kafkaconfig.kafka.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaconfig.kafka.dtos.BoletaDTO;
import com.kafkaconfig.kafka.dtos.PedidoDTO;

@Component
public class ConsumerServices {
  private final List<BoletaDTO> boletasRecibidas = new ArrayList<>();
  private final List<PedidoDTO> pedidosRecibidos = new ArrayList<>();
  private final ObjectMapper objectMapper = new ObjectMapper();

  @KafkaListener(topics = "boleta_topic", groupId = "boleta_group")
  public void consumeBoleta(String message) {
    try {
      BoletaDTO boleta = objectMapper.readValue(message, BoletaDTO.class);
      boletasRecibidas.add(boleta);
      System.out.println("Boleta recibida: " + boleta);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<BoletaDTO> getBoletasRecibidas() {
    return boletasRecibidas;
  }

  @KafkaListener(topics = "pedidos_topic", groupId = "pedidos_group")
  public void consumePedidos(String message) {
    try {
      PedidoDTO pedido = objectMapper.readValue(message, PedidoDTO.class);
      pedidosRecibidos.add(pedido);
      System.out.println("Pedido recibido: " + pedido);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<PedidoDTO> getPedidosRecibidos() {
    return pedidosRecibidos;
  }

}
