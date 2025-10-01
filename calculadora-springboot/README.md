# Calculadora Spring Boot

Una aplicación REST API de calculadora desarrollada con Spring Boot.

## Características

- Operaciones matemáticas básicas:
  - Suma
  - Resta
  - Multiplicación
  - División (con validación de división por cero)

## Requisitos

- Java 17 o superior
- Maven 3.6 o superior

## Instalación

1. Clone el repositorio
2. Navegue al directorio del proyecto:
```bash
cd calculadora-springboot
```

3. Compile el proyecto con Maven:
```bash
mvn clean install
```

## Ejecución

Para ejecutar la aplicación:

```bash
mvn spring-boot:run
```

La aplicación se ejecutará en `http://localhost:8080`

## Endpoints de la API

### Sumar
```
GET /api/calculadora/sumar?a={valor1}&b={valor2}
```
Ejemplo: `http://localhost:8080/api/calculadora/sumar?a=5&b=3`
Resultado: `8.0`

### Restar
```
GET /api/calculadora/restar?a={valor1}&b={valor2}
```
Ejemplo: `http://localhost:8080/api/calculadora/restar?a=10&b=4`
Resultado: `6.0`

### Multiplicar
```
GET /api/calculadora/multiplicar?a={valor1}&b={valor2}
```
Ejemplo: `http://localhost:8080/api/calculadora/multiplicar?a=6&b=7`
Resultado: `42.0`

### Dividir
```
GET /api/calculadora/dividir?a={valor1}&b={valor2}
```
Ejemplo: `http://localhost:8080/api/calculadora/dividir?a=15&b=3`
Resultado: `5.0`

**Nota:** La división por cero retornará un error 400 con el mensaje "No se puede dividir por cero"

## Pruebas

Para ejecutar las pruebas:

```bash
mvn test
```

## Construcción del JAR

Para construir un JAR ejecutable:

```bash
mvn clean package
```

El JAR se generará en `target/calculadora-1.0.0.jar`

Para ejecutar el JAR:

```bash
java -jar target/calculadora-1.0.0.jar
```

## Tecnologías Utilizadas

- Spring Boot 3.2.0
- Java 17
- Maven
- Spring Web
