# Getting Started

# Change to virtual threads:
add this in application.properties:
```yaml
spring.threads.virtual.enabled=true
```

# Build with OpenJDK

mvn package -DskipTests

# Build as native image with GraalVM

native image mit maven wrapper bauen

./mvnw -Pnative native:compile -DskipTests

Das dauert ewig, aber am ende hat man das `webmvc-postgres` programm welches man auf der Console mit `./webmvc-postgres` starten kann.
Beachte, dass die Datenbank auch laufen muss :D  
Das ganze startet dann unglaublich schnell


## How to run
### working
in application yaml:
```yaml
spring.application.name=webmvc-postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/bookdatabase
spring.datasource.username=postgres
spring.datasource.password=123

spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.threads.virtual.enabled=false
```

fill out {path_to_schema} with the correct path   
this one is the correct docker run command:
```
docker run --name postgrestestdb -e POSTGRES_PASSWORD=123 -e POSTGRES_DB=bookdatabase -v {path_to_schema}/schema.sql:/docker-entrypoint-initdb.d/schema.sql -d -p 5432:5432 postgres
```

in the end to ensure that everything docker is killed run this:

`docker ps -a` // shows all running containers  
`docker container stop <id>` // kill specific docker container   
`docker rm $(docker ps -aq)`  // kill ALL docker containers

## From Project Initialization
### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

