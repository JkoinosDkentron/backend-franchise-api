# Backend Franchise API

Este proyecto es una API reactiva desarrollada con **Spring Boot**, diseñada para gestionar franquicias, sucursales y productos. Implementa Clean Architecture y sigue buenas prácticas modernas de desarrollo backend.

---

## 🧱 Tecnologías utilizadas

- Java 17
- Spring Boot (WebFlux)
- Gradle con Kotlin DSL
- MongoDB (Reactive)
- Docker & Docker Compose
- Clean Architecture
- JUnit 5 + Mockito
- GitHub (flujo de trabajo profesional)

---

## 🚀 Endpoints principales

- ✅ Crear franquicia
- ✅ Agregar sucursal a una franquicia
- ✅ Agregar producto a una sucursal
- ✅ Eliminar producto de una sucursal
- ✅ Modificar stock de producto
- ✅ Consultar el producto con más stock por sucursal de una franquicia
- 🔁 (Plus) Actualizar nombre de la franquicia
- 🔁 (Plus) Actualizar nombre de la sucursal
- 🔁 (Plus) Actualizar nombre de un producto

---

## 🧪 Ejecutar localmente

### ✅ Pre-requisitos

- JDK 17
- Docker
- MongoDB o Docker Compose
- IntelliJ IDEA (u otro IDE con soporte Gradle Kotlin DSL)

---

### 🐳 Usar Docker

Ejecuta el servicio de base de datos con:

docker-compose up -d

> Esto levantará una instancia de MongoDB local para la persistencia reactiva.

---

### 🔧 Compilar y ejecutar

./gradlew bootRun

Para compilar el proyecto:

./gradlew build

---

### ✅ Ejecutar pruebas

./gradlew test

---

## 📁 Estructura del Proyecto

src/
├── main/java/com/jdvargas/backendfranchiseapi/
│   ├── controller/        # Capa de exposición (REST API)
│   ├── application/       # Casos de uso (lógica de negocio orquestada)
│   ├── domain/            # Entidades de dominio y contratos
│   └── infrastructure/    # Adaptadores externos, base de datos, configuración
└── resources/
└── application.yml    # Configuración de Spring

---

## 📌 Notas importantes

- El proyecto utiliza programación reactiva con WebFlux.
- La estructura sigue Clean Architecture para un diseño desacoplado y mantenible.
- El control de versiones se gestiona con Git y el repositorio es público.
- Se documenta cómo levantar la app en local usando Docker.
- Se busca cumplir todos los puntos extras solicitados en la prueba.

---

## 👨‍💻 Autor

Desarrollado por **Juan Daniel Vargas Atencio**  
GitHub: https://github.com/JkoinosDkentron
