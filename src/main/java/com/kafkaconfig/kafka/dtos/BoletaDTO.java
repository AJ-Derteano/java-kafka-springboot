package com.kafkaconfig.kafka.dtos;

public class BoletaDTO {
  private String numeroBoleta;
  private String cliente;
  private double monto;
  private String fecha;

  // Constructor vacío (necesario para la deserialización JSON)
  public BoletaDTO() {
  }

  // Constructor con parámetros
  public BoletaDTO(String numeroBoleta, String cliente, double monto, String fecha) {
    this.numeroBoleta = numeroBoleta;
    this.cliente = cliente;
    this.monto = monto;
    this.fecha = fecha;
  }

  // Getters y Setters
  public String getNumeroBoleta() {
    return numeroBoleta;
  }

  public void setNumeroBoleta(String numeroBoleta) {
    this.numeroBoleta = numeroBoleta;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }
}
