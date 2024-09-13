package com.example.Trabajo.preentrega.Controller;


import com.example.Trabajo.preentrega.Model.Productos;
import com.example.Trabajo.preentrega.Repository.RepositoryCliente;
import com.example.Trabajo.preentrega.Repository.RepositoryProductos;
import com.example.Trabajo.preentrega.Service.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ControllerProductos {

    @Autowired
    private ServiceProducto serviceProducto;

     @PostMapping("/agregar")
     public ResponseEntity<Productos> agregarProducto(@RequestBody Productos productos){
         Productos nuevoProducto=serviceProducto.agregarProducto(productos);
         return ResponseEntity.ok(nuevoProducto);
     }

     @Autowired
     private RepositoryProductos repositoryProductos;

     @GetMapping
    public List<Productos> obtenerTodosLosProductos() {
         return repositoryProductos.findAll();

     }






}
