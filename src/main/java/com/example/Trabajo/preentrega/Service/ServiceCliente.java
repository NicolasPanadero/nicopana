package com.example.Trabajo.preentrega.Service;

import com.example.Trabajo.preentrega.Repository.RepositoryCliente;
import com.example.Trabajo.preentrega.Model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCliente {
    @Autowired
    private RepositoryCliente repositoryCliente;

    public Cliente agregarCliente(Cliente cliente) {
        return repositoryCliente.save(cliente);
    }

    public Optional<Cliente> buscarCliente(Long id) {
        return repositoryCliente.findById(id);
    }
}

