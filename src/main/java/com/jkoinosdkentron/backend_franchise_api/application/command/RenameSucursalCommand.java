package com.jkoinosdkentron.backend_franchise_api.application.command;

public record RenameSucursalCommand(String franquiciaId, String nombreActual, String nuevoNombre) {}
