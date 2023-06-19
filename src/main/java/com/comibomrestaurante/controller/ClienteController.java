package com.comibomrestaurante.controller;

import com.comibomrestaurante.model.Cliente;
import com.comibomrestaurante.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) { this.clienteService = clienteService; }

    @PostMapping
    public ResponseEntity<Cliente> registerCliente(@RequestBody Cliente cliente) {
        Cliente responseCliente = clienteService.registerCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> findClienteById(@PathVariable("id") Long id) {
        Optional<Cliente> responseCliente = clienteService.findClienteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseCliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAllCliente() {
        List<Cliente> responseCliente = clienteService.findAllCliente();
        return ResponseEntity.status(HttpStatus.OK).body(responseCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable("id") Long id) {
        clienteService.deleteClienteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClienteById(@PathVariable("id") Long id,
                                                     @RequestBody Cliente cliente) {
        Cliente responseCliente = clienteService.updateCliente(id, cliente);
        return ResponseEntity.status(HttpStatus.OK).body(responseCliente);
    }
}
