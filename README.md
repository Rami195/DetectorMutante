# Mutant Detector API

¡Bienvenido al proyecto **Mutant Detector**! Esta aplicación es una API REST que analiza secuencias de ADN para determinar si un humano es mutante. 💻🔬

## Funcionalidad

La API recibe una secuencia de ADN en formato JSON a través de una solicitud HTTP `POST`. Utiliza un algoritmo de análisis para detectar patrones mutantes en la secuencia y responde si corresponde a un mutante. Además, puedes obtener estadísticas sobre el número de secuencias analizadas mediante una solicitud HTTP `GET`.

## Tecnologías Utilizadas

- **Java + Spring Boot**: Para la lógica de negocio y manejo de solicitudes HTTP.
- **H2 Database**: Base de datos en memoria para almacenar temporalmente las secuencias de ADN y estadísticas.
- **Postman**: Para probar los endpoints de la API.
- **Maven o Gradle**: Herramienta de construcción y manejo de dependencias.
- **IntelliJ IDEA**: Entorno de desarrollo integrado (IDE).

## Link de Despliegue

La API está desplegada en Render y puede ser accedida en:
[[https://mutantdetector.onrender.com](https://mutantdetector.onrender.com)](https://detectormutante.onrender.com)

## Endpoints de la API

### `POST /mutant`
Envía una secuencia de ADN en formato JSON para verificar si corresponde a un mutante.

- **Request**:
  ```json
  {
    "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
  }

## Response:

- 200 OK: Si es un mutante.
- 403 Forbidden: Si no es un mutante.

## GET /stats
Obtiene estadísticas sobre la cantidad de secuencias de ADN verificadas, incluyendo el total de mutantes, humanos y el ratio de mutantes sobre humanos.

- Response:
json

{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}

## Ejemplo de Solicitud en Postman
Abre Postman y selecciona el método POST.
Ingresa la URL de la API: http://localhost:8080/mutant (o el link desplegado en Render).
En la pestaña Body, selecciona raw y JSON.
Ingresa el siguiente JSON para probar una secuencia mutante:
json

{
  "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
Envía la solicitud y verifica la respuesta.
## Ejemplos de Secuencias de ADN
- Mutante


{
    "dna": [
      "ATGCGA",
      "CAGTGC",
      "TTATGT",
      "AGAAAG",
      "CCCCTA",
      "TCACTG"
    ]
}
![aaa](https://github.com/user-attachments/assets/dc2f2d54-1bf4-4204-81d4-41483e3aa905)
- No Mutante



{
    "dna": [
      "ATGATG",
      "GTCTTA",
      "AATTGG",
      "ACTAGT",
      "GGATTC", 
      "AGGCAA"
    ]
}
![bbbb](https://github.com/user-attachments/assets/8e0317b6-67bb-4882-9fdf-d53bcf583a46)

## Pruebas Unitarias
El proyecto incluye pruebas unitarias para verificar el funcionamiento del algoritmo en todos los patrones posibles (filas, columnas y diagonales). Estas pruebas están diseñadas para asegurar que el sistema detecta correctamente los patrones mutantes.

🎉 ¡Listo para detectar mutantes y ayudar a Magneto en su misión!
