package com.kafkaconfig.kafka.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaconfig.kafka.Services.ConsumerServices;
import com.kafkaconfig.kafka.Services.ProducerServices;
import com.kafkaconfig.kafka.dtos.PedidoDTO;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  private final ProducerServices producerServices;
  private final ConsumerServices consumerServices;

  public PedidoController(ProducerServices producerServices, ConsumerServices consumerServices) {
    this.consumerServices = consumerServices;
    this.producerServices = producerServices;
  }

  @PostMapping("enviar")
  public String enviarPedido(@RequestBody PedidoDTO pedido) {
    producerServices.enviarMensajePedidos(pedido);

    return "Mensaje enviado a pedidos_topic: ";
  }

  @GetMapping("listar")
  public List<PedidoDTO> listarPedidos() {
    return consumerServices.getPedidosRecibidos();
  }

}
