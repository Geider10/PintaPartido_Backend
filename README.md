# Backend - PintaPartido 

## Descripción 
Es un sistema para digitalizar y automatizar la gestión de canchas en clubes deportivos, remplazando el uso de papeles o archivos Excel.

El proyecto está desarrollado aplicando los principios de **Clean Architecture** con un enfoque **Domain-Driven Design (DDD)**.  
Las funcionalidades y casos de uso están inspirados en la plataforma **Alquila tu cancha**.
https://atcsports.io/

## Características de la APIREST
- Validación de datos de entrada
- Validaciones de reglas de negocio (persistencia y dominio)
- Manejo de excepciones y datos nulos 
- Respuestas estructuradas e integración de logging
- Documentación con **JavaDoc** y **Swagger**
- Flujo de trabajo con **Conventional commits** y **PR**
- Arquitectura limpia: Domain → Application → Infrastructure


## Funcionalidades por rol 
**Admin**
- Registrar al dueño y al club
- Gestionar horarios del club
- Gestionar canchas del club


**Owner** (in process)
- Administrar precios
- Consultar turnos (libre, reservado)
- Reservar y cancelar un turno
- Ver detalles de las reservas (cliente, pago, fecha y hora)


## Tecnologías
- Java 21
- Spring Boot 3.5.7
- MySQL
- Spring Data JPA
- Jakarta Validation
- Lombok
- Swagger/OpenAPI 3
- Maven


## Arquitectura

```
src/main/java/ar/com/pintapartido/backend/
├── club/                              # Bounded context: club, schedule, court, courtDuration
│   ├── application/                   # Lógica de aplicación
│   │   ├── dtos/
│   │   ├── mappers/
│   │   ├── services/
│   │   └── useCases/                     
│   ├── domain/                        # Capa de dominio
│   │   ├── enums/                    
│   │   ├── models/                 
│   │   └── respositories/  
│   ├── infrastructure/                # Implementaciones técnicas
│   │   ├── config/                    
│   │   ├── persistence/               
│   │   │   ├── adapter/
│   │   │   ├── entity/
│   │   │   └── jpa/
│   │   └── web/                       
│   │       └── impl/
├── reserve/                           # Bounded context: turn, reserve, customerPayment
├── user/                              # Bounded context: user
└── shared/                            # Componentes compartidos en toda la app 
    ├── dtos/                         
    └── exceptions/            
```
