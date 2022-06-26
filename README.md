# IntercamWS
Codigo fuente del proyecto para solucionar el examen de ingreso a Intercam Banco

El codigo esta hecho en java, con las siguientes herramientas.

- Maven 3.6.3
- Java 1.8
- Spring boot 2.7.1
- lombok 

## Compilacion

Si requieres que se ejecute el test:
```sh
mvn clean package
```

Si no requieres que se ejecute el test:
```sh
mvn clean package -Dmaven.test.skip=true
```

## Ejecucion

Estando en la carpeta del proyecto fuente:
```sh
java -jar target/ExamenIntercam.jar
```

## Adicionales
El proyecto lleva incrustado el gestor de H2, por lo cual deberas ingresar a la consola a traves de la liga:
```sh
http://localhost:8080/h2-ui
```

De forma predeterminada el proyecto corre en el puerto 8080 de tomcat.
