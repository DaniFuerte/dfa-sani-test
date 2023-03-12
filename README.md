# Prueba de Microservicios
## Acceso al Swagger
*Enlace: http://localhost:8081/swagger-ui.html#/*
## JSON de prueba 
### SWAGGER
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
### Todas las operaciones en POSTMAN
``` json
{
	"info": {
		"_postman_id": "18747f63-9371-41e7-b4a6-b21c4b4fe951",
		"name": "Sanitest",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "16551728"
	},
	"item": [
		{
			"name": "calcular",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"id\": 0,\n  \"parameters\": [\n    {\n      \"id\": 0,\n      \"parameter\": \"7.50\"\n    },\n    {\n      \"id\": 0,\n      \"parameter\": \"2.50\"\n    }\n  ],\n  \"type\": \"-\"\n}"
				},
				"url": {
					"raw": "localhost:8081/operacion",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"operacion"
					]
				}
			},
			"response": []
		},
		{
			"name": "recalcular",
			"request": {
				"method": "PATCH",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "localhost:8081/operacion/1",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"operacion",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "encontrar_por_pk",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "localhost:8081/operacion/1",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"operacion",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "filter",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "eliminar_por_pk",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "localhost:8081/operacion/1",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"operacion",
						"1"
					]
				}
			},
			"response": []
		}
	]
}
```

