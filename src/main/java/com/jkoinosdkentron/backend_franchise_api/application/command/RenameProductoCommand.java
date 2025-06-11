package com.jkoinosdkentron.backend_franchise_api.application.command;

public record RenameProductoCommand(String franquiciaId, String nombreSucursal, String nombreActual, String nuevoNombre) {}
