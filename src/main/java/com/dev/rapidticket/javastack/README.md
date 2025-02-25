# javastack

Servicio que de pruebas de funcionamiento del microservicio a modo de health check.

---

## Tabla de Contenido

- [Descripción](#descripción)
- [Método HTTP y enpoint](#Método-HTTP-y-endpoint)
- [Request Body](#Request-Body)
- [Response OK](#Response-OK)
- [Response Bad Request](#Response-Bad-Request)
- [Autores](#autores)

---

## Descripción

Permite validar el stack básico de java utilizado para el desarrollo de este proyecto, se creó con el propósito de
validar el funcionamiento correcto del microservicio y su integración con AWS Elastic BeansTalk, AWS RDS, docker, probar
configuraciones de Caffeine Caché, etc. No tiene una finalidad con los requirimientos del proyecto, ni niguna relación
con los demás servicios

---

## Método HTTP y endpoint

#### GET/ http://rapid-ticket-ms-prod.eba-guv64myy.us-east-1.elasticbeanstalk.com/rapid_ticket/api/v1/java-stack

## Request Body

```
N/A. No aplica Request Body o path variable, el servicio no requiere parámetros
```

[Ir a la tabla de contenido](#Tabla-de-contenido)

### Response OK

```
{
    "code": 200,
    "message": "The java stack service executed successfully",
    "springVersion": "6.2.2",
    "springBootVersion": "3.4.2",
    "javaVersion": "21.0.3"
}
```

[Ir a la tabla de contenido](#Tabla-de-contenido)

## Response Bad Request

```
N/A. No aplica
```

[Ir a la tabla de contenido](#Tabla-de-contenido)

## Autores

El equipo involucrado en la implementación de estos componentes se detalla a continuación:

- Equipo de Desarrollo:
    - Diego H. Rodríguez G. <diego.h.rodg@igmail.com>

---
[Ir a la tabla de contenido](#Tabla-de-contenido)