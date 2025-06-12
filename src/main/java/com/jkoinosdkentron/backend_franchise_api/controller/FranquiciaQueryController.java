package com.jkoinosdkentron.backend_franchise_api.controller;

import com.jkoinosdkentron.backend_franchise_api.application.query.GetTopStockedProductsQuery;
import com.jkoinosdkentron.backend_franchise_api.application.handler.query.GetTopStockedProductsHandler;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Producto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaQueryController {

    private final GetTopStockedProductsHandler topStockedProductsHandler;

    public FranquiciaQueryController(GetTopStockedProductsHandler topStockedProductsHandler) {
        this.topStockedProductsHandler = topStockedProductsHandler;
    }

    @GetMapping("/{id}/top-stock")
    public Flux<Producto> getTopStockedProducts(@PathVariable String id) {
        return topStockedProductsHandler.handle(new GetTopStockedProductsQuery(id));
    }
}
