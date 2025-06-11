package com.jkoinosdkentron.backend_franchise_api.application.command;

import java.util.List;

public record CreateFranquiciaCommand(String id, String nombre, List<String> nombresSucursales) {}
