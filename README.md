# rapid-ticket-ms [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=diego-h-rodriguez-g_rapid-ticket-ms&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=diego-h-rodriguez-g_rapid-ticket-ms) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=diego-h-rodriguez-g_rapid-ticket-ms&metric=coverage)](https://sonarcloud.io/summary/new_code?id=diego-h-rodriguez-g_rapid-ticket-ms)

Microservicio relacionado a la prueba técnica  [rapid-ticket](https://drive.google.com/file/d/16yHcvam5iuIw2iXcK8AVmhDcL-ywRDHx/view?usp=drive_link)
con el propósito de gestionar asientos disponibles y reservas de los eventos disponibles en la plataforma

>  #tags #AWS #Java #Spring #Spring Caché #Caffeine Caché #JPA #JPQL #Postgres #Microservicio #Patrón Controlador
> Servicio #REST #SonarQube #Mockito/JUnit #Jacoco Test Report #Git/GitHub

## Tabla de Contenido
- [Descripción](#descripción)
- [Detalle de Funcionalidades](#detalle-de-funcionalidades)
- [Construido con](#construido-con)
- [Ejecución del proyecto en local](#Ejecución-del-proyecto-en-local)
- [Ejecución de pruebas unitarias y sonar en local](#Ejecución-de-pruebas-unitarias-y-sonar-en-local)
- [Ejecución de análisis de calidad de código estático con SonarQube](#Ejecución-de-análisis-de-calidad-de-código-estático-con-SonarQube)
- [Versionamiento](#Versionamiento)
- [Contribuciones](#Contribuciones)

---

## Descripción

Este microservicio tiene objetivo la gestión de sillas y reservas para nuestra plataforma rapid-ticket, se compone de 4
servicios para cumplir su propósito, más uno adicional a modo de pruebas y health check.

## Detalle de Funcionalidades

Las siguientes son las funcionalidades presentes en este repositorio:

- [createreservation](src/main/java/com/dev/rapidticket/createreservation/README.md)
- [filterevent](src/main/java/com/dev/rapidticket/filterevent/README.md)
- [filterreservation](src/main/java/com/dev/rapidticket/filterreservation/README.md)
- [javastack](src/main/java/com/dev/rapidticket/javastack/README.md)
- [sectorseat](src/main/java/com/dev/rapidticket/sectorseat/README.md)

## Arquitectura

## Construido con

El código Se encuentra implementado
con [Spring Boot 3.4.2](https://spring.io/blog/2025/01/23/spring-boot-3-4-2-available-now) y [Java 21 (Última versión LTS)](https://docs.oracle.com/en/java/javase/21/) usando las
siguientes librerias:

- [Caffeine](https://www.baeldung.com/java-caching-caffeine) - Gestión de caché para algunos sevicios
- [Spring-data-jpa](https://spring.io/blog/2025/01/23/spring-boot-3-4-2-available-now) - Gestión de la capa de acceso a datos de la Base de
  Datos
- [HikariCP](https://www.baeldung.com/hikaricp) - Gestión de conexiones de Base de Datos
- [Lombok](https://projectlombok.org/) - Gestión del código repetitivo (getters, setters, constructores, etc.)
- [Mockito](https://site.mockito.org/) - Gestión de pruebas unitarias y simulación de dependencias externas
- [Jacoco](https://www.baeldung.com/jacoco) - Gestión de los informes de cobertura de código
- [SonarQube](https://www.sonarsource.com/products/sonarqube/) - Gestión continua de la calidad del código a partir del
  análisis estático de código fuente

[Ir a la tabla de contenido](#Tabla-de-contenido)

## Ejecución del proyecto en local

### Prerequisisto Postgres

- Instalar [Postgres 16 o 17](https://www.postgresql.org/) en su equipo y crear una nueva BD con los scripts
  suministradros [Scripts](https://drive.google.com/drive/folders/1WjaU7ylBa6_MRALjje7n4Qgo-Si9rXkj?usp=drive_link)

- Si usa un Sistema operativo diferente a Windows, cambiar el puerto por defecto en el
  archivo [application.yaml](src/main/resources/application.yaml)

```yml
server:
  port: 8080
```

- Cambiar los datos de conexión a la BD por las de su BD local

```yml

app:
  rapid-ticket:
    database:
      host: ${DATABASE_HOST:localhost}
      port: ${DATABASE_PORT:5432}
      name: ${DATABASE_NAME:rapid_ticket}
      schema: ${DATABASE_SCHEMA:rapid_ticket}
      username: ${DATABASE_USERNAME:postgres}
      password: ${DATABASE_PASSWORD:admin}
      driver: ${DATABASE_DRIVER:oracle.jdbc.OracleDriver}

```

- Iniciar una terminal/consola en la raíz del proyecto y ejecutar el siguiente comando

```
$ ./gradlew bootRun
```

[Ir a la tabla de contenido](#Tabla-de-contenido)

## Ejecución de pruebas unitarias y sonar en local

- Iniciar una terminal/consola en la raíz del proyecto y ejecutar el comando según su necesidad

### Pruebas unitarias

- Ejecutar pruebas unitarias en local

```
$ ./gradlew test
```

[Ir a la tabla de contenido](#Tabla-de-contenido)

### Pruebas unitarias con generación de informe JaCoCo

- Ejecutar pruebas unitarias en local,

```
$ ./gradlew clean build jacocoTestReport
```

- El informe Jacoco lo verá en la siguiente ruta: [informe Jacoco](build/reports/jacoco/test/html/index.html),
  preferiblemente ábralo desde el navegador de su preferencia para una correta visualización

[Ir a la tabla de contenido](#Tabla-de-contenido)

### Ejecución de análisis de calidad de código estático con SonarQube

- Ejecutar primero los test unitarios como se mencionó en el paso anterior, posteriormente utilizar el siguiente comando: 

-- Ejecución en windows

```
 $ sonar-scanner -D sonar.branch.name=master -D sonar.login=b821fb604909465958e9753dd4e19e240b31bd5a
```

-- Ejecución en Linux

```
$ sonar-scanner -Dsonar.branch.name=master -Dsonar.login=b821fb604909465958e9753dd4e19e240b31bd5a
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

## Versionamiento

[Repositorio en GitHub](https://github.com/diego-h-rodriguez-g/rapid-ticket-ms).
Para todas las versiones disponibles, mira las [ramas en este repositorio](https://github.com/diego-h-rodriguez-g/rapid-ticket-ms/branches).

[Ir a la tabla de contenido](#Tabla-de-contenido)

## Contribuciones

Para contribuir al proyecto, soluciones de bug o creación de nuevas funcionalidades.

1. Clona el proyecto
2. Crea la nueva rama a partir de master (`git checkout -b 'FT-nombre-de-rama'`)
3. Mueve los cambios del directorio de trabajo al área del entorno de ensayo (`git add -A`).
4. Haz commit de los cambios y pon un mensaje descriptivo (`git commit -m 'Nueva funcionalidad'`)
5. Sube la rama (`git push origin 'nombre-de-rama'`)
6. Crea un Pull Request

---
[Ir a la tabla de contenido](#Tabla-de-contenido)