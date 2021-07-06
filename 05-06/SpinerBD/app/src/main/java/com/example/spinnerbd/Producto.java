package com.example.spinnerbd;

public class Producto {

    private int Id;
    private String Nombre;
    private int valor;

    public Producto() {
    }

    public Producto(int id, String nombre, int valor) {
        Id = id;
        Nombre = nombre;
        this.valor = valor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }




}
