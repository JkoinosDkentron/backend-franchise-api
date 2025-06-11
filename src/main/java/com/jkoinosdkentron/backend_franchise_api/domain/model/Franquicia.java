package com.jkoinosdkentron.backend_franchise_api.domain.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Franquicia {

    private final String id;
    private final String nombre;
    private final List<Sucursal> sucursales;

    public Franquicia(String id, String nombre, List<Sucursal> sucursales) {
        this.id = Objects.requireNonNull(id, "El id no puede ser nulo");
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.sucursales = sucursales != null ? List.copyOf(sucursales) : List.of();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Sucursal> getSucursales() {
        return Collections.unmodifiableList(sucursales);
    }

    public Franquicia withNombre(String nuevoNombre) {
        return new Franquicia(this.id, nuevoNombre, this.sucursales);
    }

    public Franquicia withSucursales(List<Sucursal> nuevasSucursales) {
        return new Franquicia(this.id, this.nombre, nuevasSucursales);
    }
}
