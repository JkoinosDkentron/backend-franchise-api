# Backend Franchise API

Esta es una API reactiva desarrollada con **Spring Boot** aplicando principios de **Domain-Driven Design (DDD)**, **Clean Architecture** y **CQRS**. El objetivo es gestionar franquicias, sus sucursales y los productos disponibles en cada sucursal, cumpliendo con buenas prácticas de diseño, desarrollo profesional y arquitectura moderna.

## 🧱 Tecnologías utilizadas

- Java 17
- Spring Boot 3 (WebFlux)
- Gradle con Kotlin DSL
- MongoDB (Reactive)
- Docker & Docker Compose
- Clean Architecture
- Domain-Driven Design (DDD)
- CQRS (Command Query Responsibility Segregation)
- JUnit 5 + Mockito
- GitHub (flujo de trabajo profesional)

## 🎯 Principios aplicados

- ✅ Modelo de dominio inmutable (sin setters)
- ✅ Separación de comandos y queries
- ✅ Controladores como adaptadores web (REST)
- ✅ Persistencia desacoplada del dominio
- ✅ Arquitectura en capas con límites claros
- ✅ Flujo de trabajo profesional con Git y commits semánticos

## 🚀 Endpoints principales

- Crear franquicia
- Agregar sucursal a una franquicia
- Agregar producto a una sucursal
- Eliminar producto de una sucursal
- Modificar stock de producto
- Consultar el producto con más stock por sucursal de una franquicia
- (Plus) Actualizar nombre de la franquicia
- (Plus) Actualizar nombre de la sucursal
- (Plus) Actualizar nombre de un producto

## 🧪 Ejecutar localmente

### ✅ Pre-requisitos

- JDK 17
- Docker
- MongoDB o Docker Compose
- IntelliJ IDEA o IDE compatible con Gradle Kotlin DSL

### 🐳 Usar Docker

Levantar la base de datos con Docker:

```bash
docker-compose up -d
```

### 🔧 Compilar y ejecutar

```bash
./gradlew bootRun
```

Para compilar el proyecto:

```bash
./gradlew build
```

### ✅ Ejecutar pruebas

```bash
./gradlew test
```

## 📁 Estructura del Proyecto

```text
src/
└── main/java/com/jdvargas/backendfranchiseapi/
    ├── domain/                # Modelos de dominio, interfaces y lógica pura
    │   ├── model/
    │   ├── repository/
    │   └── service/
    ├── application/           # Casos de uso, comandos, queries, handlers
    │   ├── command/
    │   ├── query/
    │   └── handler/
    ├── infrastructure/        # Adaptadores externos: MongoDB, configuración
    │   ├── persistence/
    │   └── config/
    ├── controller/            # Controladores (API REST - WebFlux)
    └── shared/                # Utilidades y clases comunes
```

## 👨‍💻 Autor

Desarrollado por **Juan Daniel Vargas Atencio**  
GitHub: [https://github.com/JkoinosDkentron](https://github.com/JkoinosDkentron)

## 📝 Licencia

Este proyecto está disponible bajo licencia MIT.
