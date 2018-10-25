# UserManagement

## System requirements

1. Java 1.8+
1. Maven 3.5.4+
1. MySQL 5.5.4+
1. STS Tools (plugin in Eclipse)

## Steps to setup

1. Clone the repository `git clone git@github.com:sindhuvyshaki/UserManagement.git`
1. Import the projects into workspace (ensure that the STS plugin is installed)
1. Configure mysql in `Api/src/main/resources/application.properties`
1. Optionally, update the ports for server and management in the same `application.properties`

## Running the application

1. UserManagement is a spring boot application that uses maven to manage project and modules

`mvn install` should create the deployable artifact that shall look like  `Api-0.0.1-SNAPSHOT.jar`

2. Start the application by running the following command

`java -jar Api-0.0.1-SNAPSHOT.jar`

###REST API

* Application when run in its default mode shall run at 

`http://localhost:9000/` for application API
`http://localhost:9001/` for management API

This settings can be overriden by changing the config in `Api/src/main/resource/application.properties`

* User Management REST API is exposed as at two endpoints

  * Collection API `http://localhost:9000/api/user` 
    * Supported operations : get all, post
  * Individual resource API `http://localhost:9000/api/user/{id}`
    * Supported operations : get, put, delete
