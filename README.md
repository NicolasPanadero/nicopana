# Proyecto de Gestión de Ventas

Este proyecto es una API REST construida en Java utilizando **Spring Boot** para gestionar ventas, clientes, productos y el stock de productos vendidos.
Permite crear ventas, gestionar productos y ajustar el stock de manera automática.
A continuación se detalla el funcionamiento de los principales endpoints de la aplicación.
### Tecnologías Utilizadas
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
    - Ejemplo:  
    {
      "nombre":"Nicolas Panadero Rivas",
      "direccion":"Calle Java 123",
      "telefono":46455643
      }


## 2. Productos

- Endpoint: `/producto`
  - Método: `GET`
  - Descripción: Devuelve una lista de todos los productos registrados y su stock.
####
- Endpoint: `/producto/agregar`
  - Método: `POST`
  - Descripción: Agrega un producto nuevo a la base.
    - Ejemplo:  
    {
    "nombre":"Queso",
    "precio":1500,
    "stock":60
    }

## 3. Venta

- Endpoint: `/venta`
  - Método: `GET`
  - Descripción: Devuelve una lista de todas las ventas realizadas.
####
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

(Donde "id" es el ID del producto que compró)

(Cuando la cantidad que se quiera comprar supere el stock que hay, la consola arrojará el error "No hay suficiente stock para el producto")
