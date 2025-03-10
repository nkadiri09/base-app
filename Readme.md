# Base App

## Overview

Base App is a Spring Boot application that demonstrates how to configure an external datasource using HikariCP and JPA. The application connects to a MySQL database and performs basic CRUD operations on a `Product` entity.

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- MySQL database

## Configuration

### Datasource Configuration

The datasource configuration is defined in the `application.properties` file located in `src/main/resources`:

```ini
spring.application.name=base-app

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.datasource.url=jdbc:mysql://localhost:3306/DEV
spring.datasource.username=root
spring.datasource.password=<password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver