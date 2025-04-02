package com.kafkaconfig.kafka.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaconfig.kafka.Services.ConsumerServices;
import com.kafkaconfig.kafka.Services.ProducerServices;
import com.kafkaconfig.kafka.dtos.BoletaDTO;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/boleta")
public class BoletaController {
  private final ProducerServices producerServices;
  private final ConsumerServices consumerServices;

  public BoletaController(ProducerServices producerServices,
      ConsumerServices consumerServices) {
    this.producerServices = producerServices;
    this.consumerServices = consumerServices;
  }

  @PostMapping("enviar")
  public String enviarBoleta(@RequestBody BoletaDTO boleta) {

    producerServices.enviarMensajeBoleta(boleta);

    return "Mensaje enviado a boleta_topic";
  }

  @GetMapping("listar")
  public List<BoletaDTO> listarBoletas() {
    return consumerServices.getBoletasRecibidas();
  }

}
