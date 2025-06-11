package com.jkoinosdkentron.backend_franchise_api.domain.repository;

import com.jkoinosdkentron.backend_franchise_api.domain.model.Producto;
import reactor.core.publisher.Flux;

public interface FranquiciaQueryRepository {
    Flux<Producto> findMostStockedProductsByFranquiciaId(String franquiciaId);
}
