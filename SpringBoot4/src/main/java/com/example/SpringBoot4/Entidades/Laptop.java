package com.example.SpringBoot4.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String modelo;
   private String año;
   private String marca;
   private Double precio;

   public Laptop() {
   }

   public Laptop(Long id, String modelo, String año, String marca,Double precio) {
      this.id = id;
      this.modelo = modelo;
      this.año = año;
      this.marca = marca;
      this.precio = precio;
   }

   public Long getId() {
      return id;
   }

  /* public void setId(Long id) {
      this.id = id;
   }*/

   public String getModelo() {
      return modelo;
   }

   public void setModelo(String modelo) {
      this.modelo = modelo;
   }

   public String getAño() {
      return año;
   }

   public void setAño(String año) {
      this.año = año;
   }

   public String getMarca() {
      return marca;
   }

   public void setMarca(String marca) {
      this.marca = marca;
   }

   public Double getPrecio() {
      return precio;
   }

   public void setPrecio(Double precio) {
      this.precio = precio;
   }
}
