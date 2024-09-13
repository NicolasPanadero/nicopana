package com.example.Trabajo.preentrega.Service;

import com.example.Trabajo.preentrega.Model.Productos;
import com.example.Trabajo.preentrega.Repository.RepositoryProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceProducto {

    @Autowired
    private RepositoryProductos repositoryProductos;

    public Productos agregarProducto(Productos productos) {
        return repositoryProductos.save(productos);
    }
}
