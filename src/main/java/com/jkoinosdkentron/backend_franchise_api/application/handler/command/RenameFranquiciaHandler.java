package com.jkoinosdkentron.backend_franchise_api.application.handler.command;

import com.jkoinosdkentron.backend_franchise_api.application.command.RenameFranquiciaCommand;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaRepository;
import reactor.core.publisher.Mono;

public class RenameFranquiciaHandler {

    private final FranquiciaRepository repository;

    public RenameFranquiciaHandler(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Mono<Franquicia> handle(RenameFranquiciaCommand command) {
        return repository.findById(command.franquiciaId())
                .map(franquicia -> franquicia.withNombre(command.nuevoNombre()))
                .flatMap(repository::save);
    }
}
