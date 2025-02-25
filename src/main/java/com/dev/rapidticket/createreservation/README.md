# createreservation

Servicio que permite crear la reservación de asientos para un evento.

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

Permite la reserva de uno o varios asientos.

---

## Método HTTP y endpoint

#### POST/ http://rapid-ticket-ms-prod.eba-guv64myy.us-east-1.elasticbeanstalk.com/rapid_ticket/api/v1/reservation


## Request Body
```
{
    "customerName": "Diego Hernando Rodríguez Góngora",
    "customerDocumentNumber": 10331234567,
    "sectorSeatIds": [
        129,130,131,132,133
    ]
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

### Response OK
```
{
    "rowCount": 1,
    "message": "Reservation completed successfully",
    "reservationOwnerName": "Diego",
    "reservationOwnerDocumentNumber": 10,
    "reservationData": [
        {
            "eventId": 2,
            "experienceId": 1,
            "experienceName": "Shakira",
            "placeId": 2,
            "placeName": "Coliseo",
            "sectorId": 3,
            "sectorName": "Preferencial",
            "sectorPrice": 40000.00,
            "sectorsSeatsId": 130,
            "seatId": 70,
            "seatRow": 10,
            "seatColumn": 5,
            "seatNumber": null
        }
    ]
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

## Response Bad Request
```
{
    "timestamp": "2025-02-25T16:40:10.540+00:00",
    "generalMessage": "An error has occurred in one of the rapid-ticket-ms services, please check the entered data, documentation or AWS Cloudwatch logs for more information.",
    "message": "uri=/rapid_ticket/api/v1/reservation",
    "details": "Consistency validation on request failed, expected amount differs from received amount"
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

## Autores

El equipo involucrado en la implementación de estos componentes se detalla a continuación:

- Equipo de Desarrollo:
  - Diego H. Rodríguez G. <diego.h.rodg@igmail.com>

---
[Ir a la tabla de contenido](#Tabla-de-contenido)