package com.jkoinosdkentron.backend_franchise_api.application.handler.command;

import com.jkoinosdkentron.backend_franchise_api.application.command.AddSucursalCommand;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Sucursal;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaRepository;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class AddSucursalHandler {

    private final FranquiciaRepository repository;

    public AddSucursalHandler(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Mono<Franquicia> handle(AddSucursalCommand command) {
        return repository.findById(command.franquiciaId())
                .map(franquicia -> {
                    List<Sucursal> nuevasSucursales = new ArrayList<>(franquicia.getSucursales());
                    nuevasSucursales.add(new Sucursal(command.nombreSucursal(), List.of()));
                    return franquicia.withSucursales(nuevasSucursales);
                })
                .flatMap(repository::save);
    }
}
