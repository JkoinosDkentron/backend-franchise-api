package com.jkoinosdkentron.backend_franchise_api.infrastructure.persistence.mongo;

import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Producto;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Sucursal;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaQueryRepository;
import com.jkoinosdkentron.backend_franchise_api.infrastructure.persistence.mapper.FranquiciaMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Comparator;

@Component
public class MongoFranquiciaQueryRepositoryAdapter implements FranquiciaQueryRepository {

    private final SpringDataFranquiciaRepository repository;

    public MongoFranquiciaQueryRepositoryAdapter(SpringDataFranquiciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Producto> findMostStockedProductsByFranquiciaId(String franquiciaId) {
        return repository.findById(franquiciaId)
                .map(FranquiciaMapper::toDomain)
                .flatMapMany(franquicia -> Flux.fromIterable(franquicia.getSucursales()))
                .flatMap(sucursal -> Flux.fromIterable(sucursal.getProductos())
                        .sort((a, b) -> Integer.compare(b.getStock(), a.getStock()))
                        .take(1));
    }
}