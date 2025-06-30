
# PDyC - TP6: Arquitectura de Microservicios

## Descripción

Proyecto realizado para la asignatura **Programación Distribuida y Concurrente (PDyC)** de la Universidad Nacional del Noroeste de la Provincia de Buenos Aires (UNNOBA).

Implementa una arquitectura basada en microservicios utilizando **Spring Boot**, **Spring Cloud Netflix Eureka** y **Spring Cloud Gateway**. El sistema incluye dos microservicios:

- **song-service**: Permite crear y consultar canciones almacenadas en una base de datos.
- **playlist-service**: Permite crear playlists, asociar canciones a ellas y consultar playlists con el detalle de sus canciones. Se integra dinámicamente con song-service a través de Service Discovery y llamadas REST.

El proyecto incluye:
- **Eureka Server** como Service Discovery.
- **API Gateway** que expone un único punto de acceso para los microservicios.

---

## Endpoints

A continuación se detallan los endpoints disponibles en el sistema, **todos accedidos a través del API Gateway**, normalmente en `http://localhost:8081`.

---

### song-service

#### `POST /songs`

- **Descripción:** Crea una nueva canción.
- **Request Body:**
    ```json
    {
        "name": "example song 1"
    }
    ```
- **Response:** HTTP 201 Created

---

#### `GET /songs`

- **Descripción:** Obtiene todas las canciones.
- **Response:**
    ```json
    [
        {
            "id": 1,
            "name": "example song 1"
        },
        {
            "id": 2,
            "name": "example song 2"
        }
    ]
    ```

---

#### `GET /songs/{id}`

- **Descripción:** Obtiene una canción por su ID.
- **Response (200 OK):**
    ```json
    {
        "id": 1,
        "name": "example song 1"
    }
    ```
- **Response si no existe:** HTTP 404 Not Found

---

### playlist-service

#### `POST /playlists`

- **Descripción:** Crea una nueva playlist.
- **Request Body:**
    ```json
    {
        "name": "example playlist 1"
    }
    ```
- **Response:**
    ```json
    1
    ```
    (ID de la nueva playlist)

---

#### `POST /playlists/song`

- **Descripción:** Agrega una canción a una playlist existente.
- **Request Body:**
    ```json
    {
        "playlistId": 1,
        "songId": 2
    }
    ```
- **Response:** HTTP 200 OK

---

#### `GET /playlists`

- **Descripción:** Obtiene todas las playlists del sistema.
- **Ejemplo de respuesta (si se implementa songCount):**
    ```json
    [
        {
            "id": 1,
            "name": "example playlist 1",
            "songCount": 2
        },
        {
            "id": 2,
            "name": "example playlist 2",
            "songCount": 1
        }
    ]
    ```

---

#### `GET /playlists/{id}`

- **Descripción:** Obtiene el detalle de una playlist, incluyendo la lista de canciones (id y nombre).
- **Response (200 OK):**
    ```json
    {
        "id": 1,
        "name": "example playlist 1",
        "songs": [
            {
                "id": 1,
                "name": "example song 1"
            },
            {
                "id": 2,
                "name": "example song 2"
            }
        ]
    }
    ```
- **Response si no existe:** HTTP 404 Not Found

---

## Resumen de rutas

| Método | Endpoint                  | Descripción                                   |
|--------|---------------------------|-----------------------------------------------|
| POST   | /songs                    | Crear nueva canción                           |
| GET    | /songs                    | Listar todas las canciones                    |
| GET    | /songs/{id}               | Obtener canción por ID                        |
| POST   | /playlists                | Crear nueva playlist                          |
| POST   | /playlists/song           | Agregar canción a playlist                    |
| GET    | /playlists                | Listar todas las playlists                    |
| GET    | /playlists/{id}           | Obtener playlist con detalle de canciones     |

---


