package com.jkoinosdkentron.backend_franchise_api.controller;

import com.jkoinosdkentron.backend_franchise_api.application.command.*;
import com.jkoinosdkentron.backend_franchise_api.application.handler.command.*;
import com.jkoinosdkentron.backend_franchise_api.domain.model.Franquicia;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaCommandController {

    private final CreateFranquiciaHandler createHandler;
    private final AddSucursalHandler addSucursalHandler;
    private final AddProductoHandler addProductoHandler;
    private final UpdateStockHandler updateStockHandler;
    private final RenameFranquiciaHandler renameFranquiciaHandler;
    private final RenameSucursalHandler renameSucursalHandler;
    private final RenameProductoHandler renameProductoHandler;

    public FranquiciaCommandController(
            CreateFranquiciaHandler createHandler,
            AddSucursalHandler addSucursalHandler,
            AddProductoHandler addProductoHandler,
            UpdateStockHandler updateStockHandler,
            RenameFranquiciaHandler renameFranquiciaHandler,
            RenameSucursalHandler renameSucursalHandler,
            RenameProductoHandler renameProductoHandler
    ) {
        this.createHandler = createHandler;
        this.addSucursalHandler = addSucursalHandler;
        this.addProductoHandler = addProductoHandler;
        this.updateStockHandler = updateStockHandler;
        this.renameFranquiciaHandler = renameFranquiciaHandler;
        this.renameSucursalHandler = renameSucursalHandler;
        this.renameProductoHandler = renameProductoHandler;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Franquicia> create(@RequestBody CreateFranquiciaCommand command) {
        return createHandler.handle(command);
    }

    @PutMapping("/{id}/sucursales")
    public Mono<Franquicia> addSucursal(@PathVariable String id, @RequestBody AddSucursalCommand body) {
        return addSucursalHandler.handle(new AddSucursalCommand(id, body.nombreSucursal()));
    }

    @PutMapping("/{id}/sucursales/{sucursal}/productos")
    public Mono<Franquicia> addProducto(
            @PathVariable String id,
            @PathVariable String sucursal,
            @RequestBody AddProductoCommand body
    ) {
        return addProductoHandler.handle(new AddProductoCommand(
                id, sucursal, body.nombreProducto(), body.stock()
        ));
    }

    @PutMapping("/{id}/stock")
    public Mono<Franquicia> updateStock(@PathVariable String id, @RequestBody UpdateStockCommand body) {
        return updateStockHandler.handle(new UpdateStockCommand(
                id, body.nombreSucursal(), body.nombreProducto(), body.nuevoStock()
        ));
    }

    @PutMapping("/{id}")
    public Mono<Franquicia> renameFranquicia(@PathVariable String id, @RequestBody RenameFranquiciaCommand body) {
        return renameFranquiciaHandler.handle(new RenameFranquiciaCommand(id, body.nuevoNombre()));
    }

    @PutMapping("/{id}/sucursales/{sucursal}")
    public Mono<Franquicia> renameSucursal(
            @PathVariable String id,
            @PathVariable String sucursal,
            @RequestBody RenameSucursalCommand body
    ) {
        return renameSucursalHandler.handle(new RenameSucursalCommand(id, sucursal, body.nuevoNombre()));
    }

    @PutMapping("/{id}/sucursales/{sucursal}/productos/{producto}")
    public Mono<Franquicia> renameProducto(
            @PathVariable String id,
            @PathVariable String sucursal,
            @PathVariable String producto,
            @RequestBody RenameProductoCommand body
    ) {
        return renameProductoHandler.handle(new RenameProductoCommand(id, sucursal, producto, body.nuevoNombre()));
    }
}
