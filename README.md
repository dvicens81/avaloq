# avaloq

## Technologies
Project is created with:
* SpringBoot 2.5.2
* Maven
* Java 8
* H2 Embedded Database
* Junit 5

## Build and deploy
```shell
mvn spring-boot:run
```

## Swagger
* http://localhost:8091/swagger-ui/

## Endpoints available
* Assignment 1: Return the sum number of the roll and times to appears
```
/api/v1/roll?number=<number_dices>&sides=<number_sides>&totalRolls=<total_rolls>
```
* Assignment 2.1: Return number-side dice combination with all the rolls executed
```
/api/v1/totalroll
```
* Assignment 2.2: Return number-side dice combination with the sum number and the percentage for every number
```
/api/v1/relative/numberDice/<number_dice>/sideDice/<side_dice>
```

### Solution

* The database used is H2 Embedded because I thought that is more easy for testing purpose. 
* It is important to know that every time that the application is started, the database is empty. 

* I created an endpoint for every assignment.
* The first assignment is saving the data on database and have a validation layer and if some value is not correct the application throw custom error an returns an array informing an internal code and the description.
* I implemented custom exception.
* I created two table 
       * one for the assignment 2.1 (dices)
       * assignment 2.2 (rolls)
* I took this decision because it is more effective to have one table for every purpose.



