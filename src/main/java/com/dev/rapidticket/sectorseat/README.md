# sectorseat

Servicio que lista las asientos disponibles para un evento específico.

---
## Tabla de Contenido

- [Descripción](#descripción)
- [Método HTTP y enpoint](#Método-HTTP-y-endpoint)
- [Path Variable](#Path-Variable)
- [Response OK](#Response-OK)
- [Response Bad Request](#Response-Bad-Request)
- [Autores](#autores)
---

## Descripción

Permite la búsqueda de asientos disponibles a partir del identificador del evento (eventId). El eventId se utiliza en como path variable

---

## Método HTTP y endpoint

#### GET/ http://rapid-ticket-ms-prod.eba-guv64myy.us-east-1.elasticbeanstalk.com/rapid_ticket/api/v1/:eventId/seats


## Path Variable
```
    eventId: 5
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

### Response OK
```
{
    "rowCount": 5,
    "message": "The query to validate the available seats finished successfully",
    "availableSeats": [
        {
            "sectorsSeatsId": 1,
            "seatId": 1,
            "eventId": 1,
            "sectorId": 1,
            "sectorName": "General",
            "sectorPrice": 400000.00,
            "seatNumber": null
        },
        {
            "sectorsSeatsId": 2,
            "seatId": 2,
            "eventId": 1,
            "sectorId": 1,
            "sectorName": "General",
            "sectorPrice": 400000.00,
            "seatNumber": null
        },
        {
            "sectorsSeatsId": 3,
            "seatId": 3,
            "eventId": 1,
            "sectorId": 1,
            "sectorName": "General",
            "sectorPrice": 400000.00,
            "seatNumber": null
        },
        {
            "sectorsSeatsId": 4,
            "seatId": 4,
            "eventId": 1,
            "sectorId": 1,
            "sectorName": "General",
            "sectorPrice": 400000.00,
            "seatNumber": null
        },
        {
            "sectorsSeatsId": 5,
            "seatId": 5,
            "eventId": 1,
            "sectorId": 1,
            "sectorName": "General",
            "sectorPrice": 400000.00,
            "seatNumber": null
        }
    ]
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

## Response Bad Request
```
{
    "timestamp": "2025-02-25T17:07:07.069+00:00",
    "generalMessage": "An error has occurred in one of the rapid-ticket-ms services, please check the entered data, documentation or AWS Cloudwatch logs for more information.",
    "message": "uri=/rapid_ticket/api/v1/a/seats",
    "details": "Method parameter 'eventId': Failed to convert value of type 'java.lang.String' to required type 'int'; For input string: \"a\""
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

## Autores

El equipo involucrado en la implementación de estos componentes se detalla a continuación:

- Equipo de Desarrollo:
  - Diego H. Rodríguez G. <diego.h.rodg@igmail.com>

---
[Ir a la tabla de contenido](#Tabla-de-contenido)