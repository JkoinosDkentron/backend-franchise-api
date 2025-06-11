package com.jkoinosdkentron.backend_franchise_api.application.handler.command;

import com.jkoinosdkentron.backend_franchise_api.application.command.RenameSucursalCommand;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Sucursal;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaRepository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

public class RenameSucursalHandler {

    private final FranquiciaRepository repository;

    public RenameSucursalHandler(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Mono<Franquicia> handle(RenameSucursalCommand command) {
        return repository.findById(command.franquiciaId())
                .map(franquicia -> {
                    List<Sucursal> nuevasSucursales = franquicia.getSucursales().stream()
                            .map(sucursal -> sucursal.getNombre().equals(command.nombreActual())
                                    ? sucursal.withNombre(command.nuevoNombre())
                                    : sucursal)
                            .collect(Collectors.toList());

                    return franquicia.withSucursales(nuevasSucursales);
                })
                .flatMap(repository::save);
    }
}
