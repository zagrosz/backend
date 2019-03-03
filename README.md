# zaGrosz backend

## Running

In order to run the service you will need the following dependencies

- JDK v1.8
- Maven v3

## How to run

Service can be run either from terminal or straight from IntelliJ.

While running it's available on `http://localhost:7000` 

### Run from terminal

`mvn spring-boot:run`

### Run from Intellij

- Right click on `/src/main/java/pl/zagrosz/ZaGroszApplication.java`
- Select "Run ZaGroszApplication"

## Database

### H2 db

Service currently uses H2 database stored locally in `~/h2/zagrosz`.
While service is running, database console is available on `localhost:7000/h2-console`.
To connect to console use credentials available in `application.yml`

### Migrations

- Database files are stored in `src/main/resources/database`
- Migrations are being run at the startup of service

## Tests

### Unit tests

Unit tests are stored in `/src/test/java/pl/zagrosz`.
To run tests right click on selected class or package and select "Run".