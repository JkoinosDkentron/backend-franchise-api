package com.jkoinosdkentron.backend_franchise_api.application.handler.query;

import com.jkoinosdkentron.backend_franchise_api.application.query.GetTopStockedProductsQuery;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Producto;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaQueryRepository;
import reactor.core.publisher.Flux;

public class GetTopStockedProductsHandler {

    private final FranquiciaQueryRepository repository;

    public GetTopStockedProductsHandler(FranquiciaQueryRepository repository) {
        this.repository = repository;
    }

    public Flux<Producto> handle(GetTopStockedProductsQuery query) {
        return repository.findMostStockedProductsByFranquiciaId(query.franquiciaId());
    }
}
