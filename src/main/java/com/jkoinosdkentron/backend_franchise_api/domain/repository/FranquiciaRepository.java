package com.jkoinosdkentron.backend_franchise_api.domain.repository;

import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranquiciaRepository {
    Mono<Franquicia> save(Franquicia franquicia);
    Mono<Franquicia> findById(String id);
    Flux<Franquicia> findAll();
    Mono<Void> deleteById(String id);
}
