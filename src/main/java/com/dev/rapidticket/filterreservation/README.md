# filterreservation

Servicio que lista las reservaciones de asientos pertenecientes a un cliente.

---
## Tabla de Contenido

- [Descripción](#descripción)
- [método HTTP y enpoint](#Método-HTTP-y-endpoint)
- [Request Body](#Request-Body)
- [Response OK](#Response-OK)
- [Response Bad Request](#Response-Bad-Request)
- [Autores](#autores)
---

## Descripción

Permite la búsqueda de reservaciones hechas pertenecientes a un cliente a partir de su número de documento de identidad.

---

## Método HTTP y endpoint

#### POST/ http://rapid-ticket-ms-prod.eba-guv64myy.us-east-1.elasticbeanstalk.com/rapid_ticket/api/v1/reservation-list


## Request Body
```
{
    "customerDocumentNumber": 10331234567
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

### Response OK
```
{
    "rowCount": 1,
    "message": "The query on the reservation table was successful",
    "reservationList": [
        {
            "reservationId": 14,
            "customerDocumentNumber": 10331234567,
            "customerName": "Diego",
            "eventId": 5,
            "experienceId": 2,
            "experienceName": "Titanic",
            "placeId": 2,
            "placeName": "Coliseo",
            "sectorId": 7,
            "sectorName": "VIP",
            "sectorPrice": 60000.00,
            "sectorsSeatsId": null,
            "seatId": 28,
            "seatRow": 8,
            "seatColumn": 1,
            "seatNumber": null,
            "createdAt": "2025-02-25T17:01:42.159797"
        }
    ]
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

## Response Bad Request
```
{
    "timestamp": "2025-02-25T17:02:16.767+00:00",
    "generalMessage": "An error has occurred in one of the rapid-ticket-ms services, please check the entered data, documentation or AWS Cloudwatch logs for more information.",
    "message": "uri=/rapid_ticket/api/v1/reservation-list",
    "details": "JSON parse error: Unrecognized token 'a': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')"
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

## Autores

El equipo involucrado en la implementación de estos componentes se detalla a continuación:

- Equipo de Desarrollo:
  - Diego H. Rodríguez G. <diego.h.rodg@igmail.com>

---
[Ir a la tabla de contenido](#Tabla-de-contenido)