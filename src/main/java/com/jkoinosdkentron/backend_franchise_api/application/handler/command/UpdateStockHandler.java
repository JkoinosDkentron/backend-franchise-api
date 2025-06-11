package com.jkoinosdkentron.backend_franchise_api.application.handler.command;

import com.jkoinosdkentron.backend_franchise_api.application.command.UpdateStockCommand;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Producto;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Sucursal;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaRepository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

public class UpdateStockHandler {

    private final FranquiciaRepository repository;

    public UpdateStockHandler(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Mono<Franquicia> handle(UpdateStockCommand command) {
        return repository.findById(command.franquiciaId())
                .map(franquicia -> {
                    List<Sucursal> sucursalesActualizadas = franquicia.getSucursales().stream()
                            .map(sucursal -> {
                                if (sucursal.getNombre().equals(command.nombreSucursal())) {
                                    List<Producto> productosActualizados = sucursal.getProductos().stream()
                                            .map(producto -> producto.getNombre().equals(command.nombreProducto())
                                                    ? producto.withStock(command.nuevoStock())
                                                    : producto)
                                            .collect(Collectors.toList());

                                    return sucursal.withProductos(productosActualizados);
                                }
                                return sucursal;
                            })
                            .collect(Collectors.toList());

                    return franquicia.withSucursales(sucursalesActualizadas);
                })
                .flatMap(repository::save);
    }
}
