# [GFT] Prueba técnica para Inditex - Jose Antonio Benítez Montero

## Estructura del proyecto


## Capa de Modelo
- **Paquetes**:
  - **brand**: Contiene la entidad `Brand`, su ID (`BrandId`), `BrandNotFoundException`, y su repositorio.
  - **product**: Contiene la entidad `Product`, su ID (`ProductId`), `ProductNotFoundException`, y su repositorio.
  - **price**: Contiene la entidad `Price`, que referencia a `BrandId` y `ProductId`, junto con `PriceRepository`.
  - **dateperiod**: Define la clase `DatePeriod` para gestionar rangos de fechas y validar periodos. Se incluye en un paquete adicional para que se pueda usar en otras entidades en caso de ser necesario, no solo en `Price`.
  
## Capa de aplicación
- **Clases**:
  - **`application.brand.Find`**: Busca marcas por su identificador (`BrandId`) y maneja excepciones si no se encuentra.
  - **`application.product.Find`**: Permite buscar productos utilizando su identificador (`ProductId`).
  - **`application.price.Search`**: Busca precios válidos en función de `BrandId`, `ProductId` y una fecha.
- **Pruebas Unitarias**: Incluye pruebas para validar el comportamiento de cada clase, asegurando la gestión de excepciones y la correcta lógica de búsqueda.

## Capa de infraestructura
- **Persistencia de Datos**: Utiliza **Spring Data JPA** con una base de datos **H2 en memoria** para facilitar el desarrollo y pruebas rápidas.
- **Estructura de Repositorios**: 
  - Se han creado repositorios para las entidades `Brand`, `Product` y `Price`, que extienden `JpaRepository` para realizar operaciones CRUD y consultas específicas.
- **Configuración de la Base de Datos**:
  - **Database (H2 en memoria)**: Utilizada para facilitar el desarrollo y pruebas rápidas.
  - **import.sql**: Inicializa la base de datos con datos de prueba, proporcionando el contenido necesario para las entidades.


  
## Decisiones de diseño
  - **Identificadores**: Se decidió utilizar clases `BrandId` y `ProductId` para encapsular los identificadores y mejorar la claridad del modelo.
  - **Validación de Fechas**: Implementada en `DatePeriod` para asegurar que el rango de fechas es correcto.
  
## Consideraciones en cuanto a testing
- **Estrategia de Pruebas**: Se han implementado pruebas unitarias para verificar el correcto funcionamiento de las clases en la capa de aplicación, asegurando que las operaciones de búsqueda y manejo de excepciones se comportan como se espera.
- **Uso de Mockito**: Se ha utilizado Mockito para simular el comportamiento de los repositorios, permitiendo probar la lógica de negocio sin depender de una base de datos real.
- **Cobertura de Casos**: Se han cubierto tanto los casos exitosos (donde se encuentran marcas, productos y precios) como los casos de error (donde se lanzan excepciones o se retornan resultados vacíos).

### Colección de Postman

He creado una colección de pruebas en Postman que se puede usar para probar el endpoint de la API. Se puede acceder a la colección pública en el siguiente enlace:

[Postman Collection - JoseAntonioBenitezMontero GFT Inditex](https://www.postman.com/jabmontero/workspace/jabm-gft-inditex/collection/8783162-fbd20d50-30ee-42f2-bc3d-c780fe439928?action=share&creator=8783162)

## Cómo usar la colección

1. Haz clic en el enlace de la colección anterior para abrirla en Postman.
2. Asegúrate de que tu aplicación esté en ejecución en `http://localhost:8080`.
3. Ejecuta cada solicitud para verificar el comportamiento de la API.




