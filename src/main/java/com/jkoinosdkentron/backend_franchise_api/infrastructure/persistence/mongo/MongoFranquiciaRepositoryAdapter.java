package com.jkoinosdkentron.backend_franchise_api.infrastructure.persistence.mongo;

import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import com.jkoinosdkentron.backend_franchise_api.domain.repository.FranquiciaRepository;
import com.jkoinosdkentron.backend_franchise_api.infrastructure.persistence.mapper.FranquiciaMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MongoFranquiciaRepositoryAdapter implements FranquiciaRepository {

    private final SpringDataFranquiciaRepository repository;

    public MongoFranquiciaRepositoryAdapter(SpringDataFranquiciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Franquicia> save(Franquicia franquicia) {
        return repository.save(FranquiciaMapper.toDocument(franquicia))
                .map(FranquiciaMapper::toDomain);
    }

    @Override
    public Mono<Franquicia> findById(String id) {
        return repository.findById(id)
                .map(FranquiciaMapper::toDomain);
    }

    @Override
    public Flux<Franquicia> findAll() {
        return repository.findAll()
                .map(FranquiciaMapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
