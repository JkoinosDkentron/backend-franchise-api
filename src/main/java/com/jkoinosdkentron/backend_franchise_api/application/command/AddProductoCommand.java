package com.jkoinosdkentron.backend_franchise_api.application.command;

public record AddProductoCommand(String franquiciaId, String nombreSucursal, String nombreProducto, int stock) {
}
