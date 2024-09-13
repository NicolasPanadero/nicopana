package com.example.Trabajo.preentrega.Controller;


import com.example.Trabajo.preentrega.Model.Productos;
import com.example.Trabajo.preentrega.Service.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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








}
