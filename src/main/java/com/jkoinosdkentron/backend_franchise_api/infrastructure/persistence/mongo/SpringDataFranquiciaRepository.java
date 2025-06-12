package com.jkoinosdkentron.backend_franchise_api.infrastructure.persistence.mongo;

import com.jkoinosdkentron.backend_franchise_api.infrastructure.persistence.document.FranquiciaDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataFranquiciaRepository extends ReactiveMongoRepository<FranquiciaDocument, String> {
}
