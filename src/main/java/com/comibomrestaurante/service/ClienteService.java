package com.comibomrestaurante.service;

import com.comibomrestaurante.model.Cliente;
import com.comibomrestaurante.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService (ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente registerCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> findAllCliente() {
        return clienteRepository.findAll();
    }

    public Cliente updateCliente(Long id, Cliente clienteNovo) {
        Optional<Cliente> clienteAntigo = clienteRepository.findById(id);
        clienteNovo.setId(clienteAntigo.get().getId());
        return clienteRepository.save(clienteNovo);
    }

    public void deleteClienteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
