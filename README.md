# Tech1_Task
Project repository for Tech1 Test Task.

## Project
In resources, you'll see the application configuration that sets up our database and Hibernate, It also contains a data.sql file with a couple of items to populate the database with. Spring will run this file every time the application starts.

 The project contains following packages:
 - entity - this package contains the data models that Hibernate persists to H2. There are 2 models: User and Article. Looking at the application main class, you'll see the @EntityScan annotation, telling Spring that this package contains our data models.
 - repository - this contains a JpaRepository interface for each of our models. This allows Hibernate to connect them with our database so we can access data in the code, as well as define certain convenience methods.
 - service - this contains bussiness logic of the application and maintin separation of concerns. 
 - controller - this contains the api endpoints for our app, 1 per entity. They all have the @RestController annotation to allow Spring to understand that they are a part of a REST API.
 - request - this package contains the request models for creating a user and an article.
 - security - contains classes that implemented JWT based Security.
 
## Authentication and Authorization
Added authentication and Authorization controls so users can only access their data, and that data can only be accessed in a secure way.
A combination of usernames and passwords is using  for authentication and a JSON Web Token (JWT) to handle the authorization.

## Postman
In order to test API a Postman collection has been created.\
Please open the collection by clicking the button below\
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/b9ac5bf045008f07fc4a)

## Built with
- Java 8
- Spring Boot
- Spring Data
- Maven
- H2 database
