package com.kafkaconfig.kafka.Services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaconfig.kafka.dtos.BoletaDTO;
import com.kafkaconfig.kafka.dtos.PedidoDTO;

@Service
public class ProducerServices {
  private static final String BOLETA_TOPIC = "boleta_topic";
  private static final String PEDIDOS_TOPIC = "pedidos_topic";

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final ObjectMapper objectMapper;

  public ProducerServices(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
    this.kafkaTemplate = kafkaTemplate;
    this.objectMapper = objectMapper;
  }

  public void enviarMensajeBoleta(BoletaDTO boleta) {
    try {
      String mensaje = objectMapper.writeValueAsString(boleta);
      kafkaTemplate.send(BOLETA_TOPIC, mensaje);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  public void enviarMensajePedidos(PedidoDTO pedido) {
    try {
      String mensaje = objectMapper.writeValueAsString(pedido);
      kafkaTemplate.send(PEDIDOS_TOPIC, mensaje);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

}
