package com.jkoinosdkentron.backend_franchise_api.infrastructure.config;

import com.jkoinosdkentron.backend_franchise_api.application.handler.command.*;
import com.jkoinosdkentron.backend_franchise_api.application.handler.query.GetTopStockedProductsHandler;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaQueryRepository;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfig {

    @Bean
    public CreateFranquiciaHandler createFranquiciaHandler(FranquiciaRepository repository) {
        return new CreateFranquiciaHandler(repository);
    }

    @Bean
    public AddSucursalHandler addSucursalHandler(FranquiciaRepository repository) {
        return new AddSucursalHandler(repository);
    }

    @Bean
    public AddProductoHandler addProductoHandler(FranquiciaRepository repository) {
        return new AddProductoHandler(repository);
    }

    @Bean
    public UpdateStockHandler updateStockHandler(FranquiciaRepository repository) {
        return new UpdateStockHandler(repository);
    }

    @Bean
    public RenameFranquiciaHandler renameFranquiciaHandler(FranquiciaRepository repository) {
        return new RenameFranquiciaHandler(repository);
    }

    @Bean
    public RenameSucursalHandler renameSucursalHandler(FranquiciaRepository repository) {
        return new RenameSucursalHandler(repository);
    }

    @Bean
    public RenameProductoHandler renameProductoHandler(FranquiciaRepository repository) {
        return new RenameProductoHandler(repository);
    }

    @Bean
    public GetTopStockedProductsHandler getTopStockedProductsHandler(FranquiciaQueryRepository repository) {
        return new GetTopStockedProductsHandler(repository);
    }
}
