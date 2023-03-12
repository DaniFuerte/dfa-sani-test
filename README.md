# Prueba de Microservicios
## Acceso al Swagger
*Enlace: http://localhost:8081/swagger-ui.html#/*
## JSON de prueba
- *Operación: Calcular*<br>
*Tipo de Operación: POST*
``` json
{
  "id": 0,
  "parameters": [
    {
      "id": 0,
      "parameter": "7.50"
    },
    {
      "id": 0,
      "parameter": "2.50"
    }
  ],
  "type": "-"
}
```
- *Operación: Calcular*<br>
*Tipo de Operación: PATCH O PUT*

``` json
{
  "id": 1,
  "parameters": [
    {
      "id": 1,
      "parameter": "7.50"
    },
    {
      "id": 2,
      "parameter": "7.50"
    }
  ],
  "type": "+",
  "sysDate": "2023-03-12T20:40:01.252967",
  "result": "5.00"
}
```
