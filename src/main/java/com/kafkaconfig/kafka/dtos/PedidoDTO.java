package com.kafkaconfig.kafka.dtos;

import java.util.List;

public class PedidoDTO {
  private String numeroPedido;
  private String cliente;
  private String fecha;
  private List<String> productos;
  private double total;

  // Getters y Setters
  public String getNumeroPedido() {
    return numeroPedido;
  }

  public void setNumeroPedido(String numeroPedido) {
    this.numeroPedido = numeroPedido;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public List<String> getProductos() {
    return productos;
  }

  public void setProductos(List<String> productos) {
    this.productos = productos;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "PedidoDTO{" +
        "numeroPedido='" + numeroPedido + '\'' +
        ", cliente='" + cliente + '\'' +
        ", fecha='" + fecha + '\'' +
        ", productos=" + productos +
        ", total=" + total +
        '}';
  }
}
