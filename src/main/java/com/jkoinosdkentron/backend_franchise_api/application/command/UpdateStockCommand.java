package com.jkoinosdkentron.backend_franchise_api.application.command;

public record UpdateStockCommand(String franquiciaId, String nombreSucursal, String nombreProducto, int nuevoStock) {}
