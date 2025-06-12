package com.jkoinosdkentron.backend_franchise_api.infrastructure.persistence.mapper;

import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Producto;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Sucursal;
import com.jkoinosdkentron.backend_franchise_api.infrastructure.persistence.document.*;

import java.util.List;

public class FranquiciaMapper {

    public static Franquicia toDomain(FranquiciaDocument doc) {
        List<Sucursal> sucursales = doc.sucursales().stream()
                .map(s -> new Sucursal(
                        s.nombre(),
                        s.productos().stream()
                                .map(p -> new Producto(p.nombre(), p.stock()))
                                .toList()
                )).toList();

        return new Franquicia(doc.id(), doc.nombre(), sucursales);
    }

    public static FranquiciaDocument toDocument(Franquicia franquicia) {
        List<SucursalDocument> sucursales = franquicia.getSucursales().stream()
                .map(s -> new SucursalDocument(
                        s.getNombre(),
                        s.getProductos().stream()
                                .map(p -> new ProductoDocument(p.getNombre(), p.getStock()))
                                .toList()
                )).toList();

        return new FranquiciaDocument(franquicia.getId(), franquicia.getNombre(), sucursales);
    }
}
