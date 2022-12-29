<h1 align="center">Proyecto Integrador: Booking System Rest API</h1>

El proyecto fue realizado siguiendo las buenas prácticas de programación, además contiene las siguientes implementaciones:

* Microservicios User, Booking y Authentication
* Java versión 11
* Gestor de Dependencias Maven
* Spring Boot versión 2.7.5
* Persistencia de datos Cloud con MongoDB
* Jwt y Spring Security
* Test unitarios con JUnit y Mockito
* Documentación con Swagger
* Integración Continua (CI) y Entrega Continua (CD) con Github Actions
* [Railway](https://railway.app/) | PaaS para publicación de la Api

## Documentación con Swagger

Puedes visualizar la estructura de los controladores en la interfaz gráfica de [Swagger](http://localhost:8080/swagger-ui/), para consultar los endpoints del CRUD.

Para tener acceso total se debe crear un usuario, teniendo en cuenta la siguiente estructura en formato JSON, por ejemplo:

```xml
        {
            "name": "luis",
            "lastName": "orellana",
            "age": 24,
            "identityCard": "123456789",
            "email": "luis@mail.com",
            "password": "12345"
        }
```

Luego, en el microservicio **auth** se debe ingresar el email y password, creado con anterioridad para poder
generar el token de acceso, que tendrá un tiempo de validez de 30 minutos (se puede modificar el tiempo de expiración) para poder interactuar con todos los controladores.
```xml
        {
            "email":"luis@mail.com",
            "password":"12345"
        }
```

## Diagrama de clases 

### Microservicio User

![user](https://raw.github.com/davidorellana98/booking-system-rest-api-spring-boot/main/src/main/resources/images/user.png "user")

### Microservicio Booking

![booking](https://raw.github.com/davidorellana98/booking-system-rest-api-spring-boot/main/src/main/resources/images/booking.png "booking")

### Microservicio Authenticación

![auth](https://raw.github.com/davidorellana98/booking-system-rest-api-spring-boot/main/src/main/resources/images/auth.png "auth")
