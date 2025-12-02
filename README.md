# Backend - PintaPartido 

## Descripción 
Es un sistema para digitalizar y automatizar la gestión de canchas en clubes deportivos, remplazando el uso de papeles o archivos Excel.

El proyecto está desarrollado siguiendo principios de **Clean Architecture** con un enfoque **Domain-Driven Design (DDD)**.  
Las funcionalidades y casos de uso están inspirados en la plataforma **Alquila tu cancha**.
https://atcsports.io/

## Características de la APIREST
- Validación de datos de entrada
- Validaciones de reglas de negocio (persistencia y dominio)
- Manejo de excepciones y datos nulos 
- Respuestas estructuradas e integración de logging
- Documentación con **JavaDoc** y **Swagger**
- Flujo de trabajo con **Conventional commits** y **Pull Requests**
- Arquitectura limpia: Domain → Application → Infrastructure


## Funcionalidades por rol 
**Admin**
- Registrar al dueño y al club
- Gestionar horarios del club


**Owner** (in process)
- Administrar canchas
- Configurar precios
- Consultar turnos y realizar reservas 
- Ver estado de cada turno (libre, reservado, cancelado)
- Acceder al detalle de reservas (cliente, pago, fecha y hora)


## Tecnologías
- Java 21
- Spring Boot 3.5.7
- MySQL
- Spring Data JPA
- Jakarta Validation
- Lombook
- Swagger/OpenAPI 3
- Maven


## Arquitectura

```
src/main/java/ar/com/pintapartido/backend/
├── club/
│   ├── application/                   # Lógica de aplicación
│   │   ├── dtos/
│   │   ├── mappers/
│   │   ├── services/
│   │   └── useCases/                     
│   ├── domain/                        # Reglas del negocio
│   │   ├── enums/                    
│   │   ├── models/                 
│   │   └── respositories/  
│   ├── infrastructure/                # Implementaciones externas
│   │   ├── config/                    
│   │   ├── persistence/               
│   │   │   ├── adapter/
│   │   │   ├── entity/
│   │   │   └── jpa/
│   │   └── web/                       
│   │       └── impl/
├── reserve/
├── user/
└── shared/                            # Componentes compartidos en toda la app 
    ├── dtos/                         
    └── exceptions/            
```
