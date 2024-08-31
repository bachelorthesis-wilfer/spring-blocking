# Getting Started

# Change to virtual threads:
add this in application.properties:
```yaml
spring.threads.virtual.enabled=true
```

## Run/ develop code locally

I used docker to run postgres. Here's the setup:

First setup the database:
```
docker run --name blocking_spring -e POSTGRES_PASSWORD=123 -d -p 5432:5432 postgres
```
then create the database:
```
docker exec -it blocking_spring psql -U postgres -c "CREATE DATABASE bookdatabase;"
```

depending on whether or not your code automatically creates a table you might need to go into the docker postgres and initialize the table like this:
```
CREATE TABLE IF NOT EXISTS book (id SERIAL PRIMARY KEY, title VARCHAR(255), author VARCHAR(255), price INTEGER, isbn VARCHAR(255));
```

Afterwards you can start your application and everything should work. (I use IntelliJ to run it.)

:warning: Remember to stop and remove the used container and volumes, as docker uses quite a lot of data.

show all running containers to get the id : `docker ps -a`  
kill/stop specific docker container: `docker container stop <id>`   
kill docker container: `docker rm <id>`

remove volumes
```
docker volume ls
docker volume prune
```

# Build with OpenJDK

`mvn package -DskipTests`

# Build as native image with GraalVM
Build a native image with GraalVM:

`./mvnw -Pnative native:compile -DskipTests`

Compiling this takes forever, but once its finished, you can start it with `./webmvc-postgres` on your console. Remember to also setup your database. 

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

