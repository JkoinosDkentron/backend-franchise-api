package com.jkoinosdkentron.backend_franchise_api.domain.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Sucursal {

    private final String nombre;
    private final List<Producto> productos;

    public Sucursal(String nombre, List<Producto> productos) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.productos = productos != null ? List.copyOf(productos) : List.of();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    public Sucursal withNombre(String nuevoNombre) {
        return new Sucursal(nuevoNombre, this.productos);
    }

    public Sucursal withProductos(List<Producto> nuevosProductos) {
        return new Sucursal(this.nombre, nuevosProductos);
    }
}
