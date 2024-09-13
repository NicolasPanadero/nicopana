package com.example.Trabajo.preentrega.Controller;

import com.example.Trabajo.preentrega.Model.Cliente;
import com.example.Trabajo.preentrega.Model.Productos;
import com.example.Trabajo.preentrega.Model.ProductosVendidos;
import com.example.Trabajo.preentrega.Model.Ventas;
import com.example.Trabajo.preentrega.Repository.RepositoryProductos;
import com.example.Trabajo.preentrega.Repository.RepositoryVentas;
import com.example.Trabajo.preentrega.Service.ServiceVentas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
@Tag(name="Ventas", description = "Operaciones relacionadas con las ventas")
public class ControllerVentas {
    @Autowired
    private ServiceVentas serviceVentas;

    @PostMapping("/crear/{idcliente}")
    @Operation(summary = "Agregar una nueva venta al respectivo cliente", description = "Agregar una nueva venta a la base de datos")
    public Ventas agregarVentas (
            @PathVariable Long idcliente,
            @RequestBody ProductosVendidos productosVendidos){
            return serviceVentas.agregarVentas(idcliente, productosVendidos.getProductos().getId(), productosVendidos.getCantidad());
    }
    @Autowired
    private RepositoryVentas repositoryVentas;

    @GetMapping
    @Transactional
    public List<Ventas> obtenerTodasLasVentas() {
        return repositoryVentas.findAll();

    }


}
