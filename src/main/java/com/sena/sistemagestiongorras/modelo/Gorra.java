
package com.sena.sistemagestiongorras.modelo;

public class Gorra {

    private int idgorra;
    private String nombre;
    private String marca;
    private String color;
    private String talla;
    private double precio;
    private int stock;

    public Gorra() {
    }

    public Gorra(int idgorra, String nombre, String marca, String color,
                 String talla, double precio, int stock) {
        this.idgorra = idgorra;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdgorra() {
        return idgorra;
    }

    public void setIdgorra(int idgorra) {
        this.idgorra = idgorra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}