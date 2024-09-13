package com.example.Trabajo.preentrega.Model;

import com.example.Trabajo.preentrega.Repository.RepositoryProductos;
import com.example.Trabajo.preentrega.Repository.RepositoryProductosVendidos;
import com.example.Trabajo.preentrega.Repository.RepositoryVentas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="VENTAS")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la venta", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Fecha de la venta", example = "23/5/2024", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "FECHA")
    private LocalDate fecha;

    @Schema(description = "Precio total de la venta", example = "35640", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "PrecioTotal")
    private int preciototal;

    @ManyToOne(fetch = FetchType.LAZY)
    @Schema(description = "ID del cliente que realizó la compra", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @JoinColumn(name = "idcliente", referencedColumnName = "id")
    @JsonIgnore
    private Cliente cliente;

    @OneToMany (mappedBy = "ventas", cascade = CascadeType.ALL)
    private List<ProductosVendidos> productosVendidos;




    public Ventas() {
    }

    public Ventas(Long id, LocalDate fecha, Cliente cliente, List<ProductosVendidos> productosVendidos) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.productosVendidos = productosVendidos;
        this.preciototal = calcularPrecioTotal();
    }
    public int calcularPrecioTotal() {
        return productosVendidos.stream()
                .mapToInt(productoVendido -> productoVendido.getProductos().getPrecio() * productoVendido.getCantidad())
                .sum();
    }


    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProductosVendidos> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<ProductosVendidos> productosVendidos) {
        this.productosVendidos = productosVendidos;
        this.preciototal = calcularPrecioTotal();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ventas ventas = (Ventas) o;
        return id == ventas.id && preciototal == ventas.preciototal && Objects.equals(fecha, ventas.fecha) && Objects.equals(cliente, ventas.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, preciototal, cliente);
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", preciototal=" + preciototal +
                ", cliente=" + cliente +
                '}';
    }
}
