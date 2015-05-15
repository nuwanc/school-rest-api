# school-rest-api

A spring boot based RESTful API with CRUD functionality. 

Database : MongoDB

Application Structure:

* SchoolAppConfig.java - configuration class that configures and runs our Spring Boot application.
* SchoolController.java - REST Controller that process HTTP request and send response to client
* MongoDBSchoolService.java - Serivce layer class which encapsualte all the DB functioanlity and one entry point to controller

What you need to run this app:

* JDK 1.8
* Maven 3.0+
* MongoDB running on default port

How to run this app:

mvn clean spring-boot:run





