package com.jkoinosdkentron.backend_franchise_api.domain.model;

import java.util.Objects;

public final class Producto {

    private final String nombre;
    private final int stock;

    public Producto(String nombre, Integer stock) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.stock = (stock != null && stock >= 0) ? stock : 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public Producto withStock(int nuevoStock) {
        return new Producto(this.nombre, nuevoStock);
    }

    public Producto withNombre(String nuevoNombre) {
        return new Producto(nuevoNombre, this.stock);
    }
}