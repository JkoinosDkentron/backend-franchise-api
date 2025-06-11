package com.jkoinosdkentron.backend_franchise_api.application.handler.command;

import com.jkoinosdkentron.backend_franchise_api.application.command.CreateFranquiciaCommand;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Sucursal;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaRepository;
import reactor.core.publisher.Mono;

import java.util.List;

public class CreateFranquiciaHandler {

    private final FranquiciaRepository repository;

    public CreateFranquiciaHandler(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Mono<Franquicia> handle(CreateFranquiciaCommand command) {
        List<Sucursal> sucursales = command.nombresSucursales().stream()
                .map(nombre -> new Sucursal(nombre, List.of()))
                .toList();

        Franquicia nueva = new Franquicia(command.id(), command.nombre(), sucursales);
        return repository.save(nueva);
    }
}
