package com.example.Trabajo.preentrega.Service;

import com.example.Trabajo.preentrega.Model.Cliente;
import com.example.Trabajo.preentrega.Model.Productos;
import com.example.Trabajo.preentrega.Model.ProductosVendidos;
import com.example.Trabajo.preentrega.Model.Ventas;
import com.example.Trabajo.preentrega.Repository.RepositoryCliente;
import com.example.Trabajo.preentrega.Repository.RepositoryProductos;
import com.example.Trabajo.preentrega.Repository.RepositoryProductosVendidos;
import com.example.Trabajo.preentrega.Repository.RepositoryVentas;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceVentas {
    @Autowired
    private RepositoryVentas repositoryVentas;

    @Autowired
    private RepositoryCliente repositoryCliente;

    @Autowired
    private RepositoryProductos repositoryProductos;


    @Autowired
    private RepositoryProductosVendidos repositoryProductosVendidos;

    @Transactional
    public void crearVenta(Ventas ventas) {
        for (ProductosVendidos pv : ventas.getProductosVendidos()) {
            Productos producto = pv.getProductos();
            int cantidadVendida = pv.getCantidad();

            producto.reducirStock(cantidadVendida);
            System.out.println("Stock reducido para el producto " + producto.getNombre() + ": " + producto.getStock());
            repositoryProductos.save(producto);
            repositoryProductos.save(producto);
        }
        repositoryVentas.save(ventas);
    }

    public Ventas agregarVentas(Long idcliente, int productoid, int cantidad) {
        Cliente cliente =repositoryCliente.findById(idcliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Productos productos =repositoryProductos.findById((long) productoid)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Ventas ventas = new Ventas();
        ventas.setFecha(LocalDate.now());
        ventas.setCliente((cliente));
        ventas = repositoryVentas.save(ventas);

        ProductosVendidos productosVendidos = new ProductosVendidos();
        productosVendidos.setVentas(ventas);
        productosVendidos.setProductos(productos);
        productosVendidos.setCantidad(cantidad);
        repositoryProductosVendidos.save(productosVendidos);

        List<ProductosVendidos> productosVendidosList = new ArrayList<>();
        productosVendidosList.add(productosVendidos);
        ventas.setProductosVendidos(productosVendidosList);

        crearVenta(ventas);

        return repositoryVentas.save(ventas);

    }
}