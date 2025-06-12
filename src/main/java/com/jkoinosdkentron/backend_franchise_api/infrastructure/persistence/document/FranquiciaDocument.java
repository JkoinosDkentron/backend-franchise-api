package com.jkoinosdkentron.backend_franchise_api.infrastructure.persistence.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "franquicias")
public record FranquiciaDocument(
        @Id String id,
        String nombre,
        List<SucursalDocument> sucursales
) {}
