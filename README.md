# Proyecto de Gestión de Ventas

Este proyecto es una API RESTful construida en Java utilizando **Spring Boot** para gestionar ventas, clientes, productos y el stock de productos vendidos.
La API permite crear ventas, gestionar productos y ajustar el stock de manera automática.
A continuación se detalla el funcionamiento de los principales endpoints de la aplicación.

## Tecnologías Utilizadas
- Java 11
- Spring Boot 2.7
- H2 Database
- JPA/Hibernate
- Postman

# Endpoints

## 1. Clientes


- Endpoint: `/cliente`
- Método: `GET`
- Descripción: Devuelve una lista de todos los clientes registrados.
####
- Endpoint: `/cliente/agregar`
- Método: `POST`
- Descripción: Crea un cliente nuevo en la base de datos.


## 2. Productos


- Endpoint: `/producto/agregar`
- Método: `POST`
- Descripción: Agrega un producto nuevo a la base.

## 3. Venta


- Endpoint: `/venta/crear/{idcliente}`
- Método: `POST`
- Descripción: Agrega una venta nueva para el cliente seleccionado.
- Ejemplo de venta: 

{
  "productos":{
"id":1
  },
  "cantidad":2
  }

-- Donde "id"= el ID del producto que compró
