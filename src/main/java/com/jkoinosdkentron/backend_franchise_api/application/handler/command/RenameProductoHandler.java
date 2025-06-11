package com.jkoinosdkentron.backend_franchise_api.application.handler.command;

import com.jkoinosdkentron.backend_franchise_api.application.command.RenameProductoCommand;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Producto;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Sucursal;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaRepository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

public class RenameProductoHandler {

    private final FranquiciaRepository repository;

    public RenameProductoHandler(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Mono<Franquicia> handle(RenameProductoCommand command) {
        return repository.findById(command.franquiciaId())
                .map(franquicia -> {
                    List<Sucursal> nuevasSucursales = franquicia.getSucursales().stream()
                            .map(sucursal -> {
                                if (sucursal.getNombre().equals(command.nombreSucursal())) {
                                    List<Producto> nuevosProductos = sucursal.getProductos().stream()
                                            .map(producto -> producto.getNombre().equals(command.nombreActual())
                                                    ? producto.withNombre(command.nuevoNombre())
                                                    : producto)
                                            .collect(Collectors.toList());
                                    return sucursal.withProductos(nuevosProductos);
                                }
                                return sucursal;
                            })
                            .collect(Collectors.toList());

                    return franquicia.withSucursales(nuevasSucursales);
                })
                .flatMap(repository::save);
    }
}
