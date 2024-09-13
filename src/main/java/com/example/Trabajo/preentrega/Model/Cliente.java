package com.example.Trabajo.preentrega.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name="CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de cliente", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Nombre de cliente", example = "Sebastian Romero", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "NOMBRE")
    private String nombre;

    @Schema(description = "Dirección del cliente", example = "Alvear 692", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "Dirección")
    private String direccion;

    @Schema(description = "Teléfono del cliente", example = "46135134", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "TELEFONO")
    private long telefono;

    @OneToMany (mappedBy = "cliente", cascade = CascadeType.ALL)
    @Schema(description = "Lista de ventas asociadas al cliente", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnore
    private List<Ventas> ventas;

    public Cliente() {}

    public Cliente(Long id, String nombre, String direccion, long telefono, List<Ventas> ventas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ventas = ventas;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public List<Ventas> getVentas() {
        return ventas;
    }

    public void setVentas(List<Ventas> ventas) {
        this.ventas = ventas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && Objects.equals(nombre, cliente.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + direccion + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
