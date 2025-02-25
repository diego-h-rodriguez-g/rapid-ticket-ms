# filterevent

Servicio que lista eventos con asientos disponibles.

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

Permite la búsqueda de eventos con asientos disponibles y filtrar los resultados por medio de varios filtros (todos los filtros son opcionales).

---

## Método HTTP y endpoint

#### POST/ http://rapid-ticket-ms-prod.eba-guv64myy.us-east-1.elasticbeanstalk.com/rapid_ticket/api/v1/events


## Request Body
```
{
    "eventId": 8,
    "experienceId": 3,
    "placeId": 2,
    "sectorId": 12,   
    "maxPrice": 500000,
    "minPrice": 10000,
    "initEventDate": "2025-03-05T00:30:00",
    "endEventDate": "2025-03-05T22:30:00",
    "text": "Stand",
    "sortField": "maxPrice",
    "sortOrder": true    
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

### Response OK
```
{
    "rowCount": 1,
    "message": "The query on the events table was successful",
    "eventList": [
        {
            "eventId": 8,
            "experienceId": 3,
            "experienceName": "Stand-Up Comedy",
            "eventDateTime": "2025-03-05 21:30:00.0",
            "placeId": 2,
            "placeName": "Coliseo",
            "sectorId": 12,
            "sectorName": "VIP",
            "sectorPrice": 40000.00,
            "availableSeats": 20
        }
    ]
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

## Response Bad Request
```
{
    "timestamp": "2025-02-25T16:56:39.489+00:00",
    "generalMessage": "An error has occurred in one of the rapid-ticket-ms services, please check the entered data, documentation or AWS Cloudwatch logs for more information.",
    "message": "uri=/rapid_ticket/api/v1/events",
    "details": "Validation failed for argument [0] in public org.springframework.http.ResponseEntity<com.dev.rapidticket.filterevent.model.FilterEventResponse> com.dev.rapidticket.filterevent.controller.FilterEventController.getFilterEvents(com.dev.rapidticket.filterevent.model.FilterEventRequest): [Field error in object 'filterEventRequest' on field 'initEventDate': rejected value [2024-03-05T00:30]; codes [Future.filterEventRequest.initEventDate,Future.initEventDate,Future.java.time.LocalDateTime,Future]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [filterEventRequest.initEventDate,initEventDate]; arguments []; default message [initEventDate]]; default message [The field must be a date greater than the current date]] "
}
```
[Ir a la tabla de contenido](#Tabla-de-contenido)

## Autores

El equipo involucrado en la implementación de estos componentes se detalla a continuación:

- Equipo de Desarrollo:
  - Diego H. Rodríguez G. <diego.h.rodg@igmail.com>

---
[Ir a la tabla de contenido](#Tabla-de-contenido)