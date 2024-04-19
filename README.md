
# Bienvenido al Proyecto Interceptacion de mensajes

Este proyecto es una aplicación para la interceptacion de mensajes desarrollada con Spring Boot y Maven. En este README, se le proporcionaran los pasos para ejecutar la aplicación en su máquina.

## Ejercicio

### Implementacion y tecnologias usadas

- Java 17
- H2
- Spring Boot 
- Mockito
- Maven
- JUnit
- GitHub


### Comentarios

La solución propuesta se desarrolló en Java, ya que es un lenguaje en el que el desarrollador tiene experiencia, esto le permitió optimizar el tiempo para llegar a una solución exitosa del problema.

Al igual que java, la demás herramientas utilizadas se seleccionaron por diferentes características para llegar a la mejor solución posible. Esto complementado con ser herramientas ya utilizadas por el programador.

Se desarrolló bajo una arquitectura de microservicios, con dos controladores para los endpoints requeridos.

En la base de datos se utilizó H2 se escogió por ser una base de datos en memoria que el mismo proyecto correría.

Finalmente en la parte de los test unitarios se seleccionó Junit, que permite un amplio testeo de la aplicación e incluye Mockito lo que habilita las ventajas de mockear diferentes clases, métodos o interacciones.

### Instrucciones

#### Prerequisitos

Para correr la aplicación en su máquina local es necesario tener instalado Java 17 y Maven.

#### Descarga

El proyecto se puede obtener desde github en la dirección: https://github.com/DavidHernandez121/MessageTest.

#### Dependencias

La administración de dependencias se hizo utilizando maven. Por lo cual puede abrir una terminal, ir al folder del proyecto donde se encuentra el pom y utilizar el comando:

```
mvn clean install -U
```

#### Iniciación

Para iniciar la aplicación en la terminal puede utilizar el comando:

```
mvn  spring-boot:run

```

### API-Url

Como se mencionó anteriormente la dirección local del proyecto se encuentra en:

http://localhost:8080/

### Test

#### Automaticos

Para los test se utilizó Junit y se trató de tener la mayor covertura posible, enfocandose en el servicio de interceptacion de los mensajes.


Nota:

También se incluye una pequeña colección en Postman para que pruebe algunos de los endpoints.

Para los casos de prueba se asumio que:

    1)  el desfasaje es al incio de la lista de palabras en los mensajes
    2)  los mensajes vienen asosiados a la llave "devices"
    3)  la union de todos los mensajes da como resultado el mensaje completo