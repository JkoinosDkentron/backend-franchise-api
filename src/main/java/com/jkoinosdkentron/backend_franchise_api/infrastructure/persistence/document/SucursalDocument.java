package com.jkoinosdkentron.backend_franchise_api.infrastructure.persistence.document;

import java.util.List;

public record SucursalDocument(String nombre, List<ProductoDocument> productos) {}