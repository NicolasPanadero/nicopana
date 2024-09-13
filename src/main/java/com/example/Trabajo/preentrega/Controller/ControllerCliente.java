package com.example.Trabajo.preentrega.Controller;

import com.example.Trabajo.preentrega.Repository.RepositoryCliente;
import com.example.Trabajo.preentrega.Service.ServiceCliente;
import com.example.Trabajo.preentrega.Model.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@Tag(name="Cliente", description = "Operaciones relacionadas con los clientes")
public class ControllerCliente {
    @Autowired
    private ServiceCliente serviceCliente;

    @PostMapping("/agregar")
    @Operation(summary = "Agregar un nuevo cliente", description = "Agregar un nuevo cliente a la base de datos")
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        return serviceCliente.agregarCliente(cliente);
    }

    @Autowired
    private RepositoryCliente repositoryCliente;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return repositoryCliente.findAll();
    }

    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar un cliente por ID", description = "Busca un cliente por ID")
    public Optional<Cliente> buscarCliente(@PathVariable Long id) {
        return serviceCliente.buscarCliente(id);
    }
}
