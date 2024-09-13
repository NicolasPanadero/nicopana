package com.example.Trabajo.preentrega.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name="PRODUCTOSVENDIDOS")
public class ProductosVendidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Cantidad")
    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idventa", referencedColumnName = "id")
    @JsonIgnore
    private Ventas ventas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nombre del producto", referencedColumnName = "nombre")
    private Productos productos;


    public ProductosVendidos() {

    }

    public ProductosVendidos(int id, int cantidad, Ventas ventas, Productos productos) {
        this.id = id;
        this.cantidad = cantidad;
        this.ventas = ventas;
        this.productos = productos;
    }


    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosVendidos that = (ProductosVendidos) o;
        return id == that.id && cantidad == that.cantidad && Objects.equals(ventas, that.ventas) && Objects.equals(productos, that.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, ventas, productos);
    }

    @Override
    public String toString() {
        return "ProductosVendidos{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", ventas=" + ventas +
                ", productos=" + productos +
                '}';
    }
}