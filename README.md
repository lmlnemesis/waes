# Assigment
This is the assigment for Nicolas Fernandez

### Tech
* Java 8
* Maven 3.6.3
* Spring boot 2.2.5.RELEASE
* Spring Data
* Mockito
* H2 embbebed database

### Assumptions
For the endpoints left and right, I assume if the id already exist we will override the value.

### Build

* Precondition: Have installed maven version 3

1. Execute the command: mvn clean install inside of the project package.
2. Go to the target folder. 
3. Execute the command: java -jar scalable-web-0.0.1-SNAPSHOT.jar

NOTE: there is a postmand collection in the source folder waes.postman_collection.json

### Improvements
Will be nice add swagger for expose the endpoint documentation. 
Add mapstruct for convert entities in dtos.
Add more integration tests.
Update endpoint to make it plural as is recommended by convention.

