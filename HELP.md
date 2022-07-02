## Spring Microservices in Action - Second Edition.

# Introduction
Welcome to Spring Microservices in Action.

1.  A Spring Cloud Config server that is deployed as Docker container and can manage a service configuration information using a file system/ classpath or GitHub-based repository.
2.  A licensing service that will manage licensing data used within Ostock.
3.  A Postgres SQL database used to hold the data.

## Initial Configuration
1.	Apache Maven (http://maven.apache.org)  All of the code examples in this book have been compiled with Java version 11.
2.	Git Client (http://git-scm.com)
3.  Docker(https://www.docker.com/products/docker-desktop)

## How To Use

To clone and run this application, you'll need [Git](https://git-scm.com), [Maven](https://maven.apache.org/), [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html). From your command line:

```bash
# Clone this repository
$ git clone https://github.com/kumarsaroj18/spring-microservices-in-action

# Go into the repository, by chaning to the directory where you have downloaded the 
# chapter 5 source code
$ cd chapter5

# For this particular project, we just need to go to the root directory of the project
# To build the code examples as a docker image, open a command-line 
# window and execute the following command:
$ mvn clean package dockerfile:build

# Now we are going to use docker-compose to start the actual image.  To start the docker image, stay in the directory containing  your chapter 5 source code and  Run the following command: 
$ docker-compose -f docker/docker-compose.yml up

# Both the commands can be combined and run together on a single line
$ mvn clean package dockerfile:build && docker-compose -f docker/docker-compose.yml up --remove-orphan
```

# The build command

Will execute the [Spotify dockerfile plugin](https://github.com/spotify/dockerfile-maven) defined in the pom.xml file.

This is the first chapter we will have multiple Spring projects that need to be be built and compiled.  Running the above command at the root of the project directory will build all of the projects.  If everything builds successfully you should see a message indicating that the build was successful.

# The Run command

This command will run our services using the docker-compose.yml file located in the /docker directory.

If everything starts correctly you should see a bunch of Spring Boot information fly by on standard out.  
At this point all the services needed for the chapter code examples will be running.
Once the services are up and running, the same can be verified using the following [Actuator Link](http://localhost:8080/actuator/env)
Running the build commands multiple times result into many dangling images on the storage disk.
The same can be removed by running following command:
```bash
$ docker image prune
```

# Database
You can find the database script as well in the docker directory.

## Contact

I'd like you to email me on <kumarsaroj18@gmail.com> about anything you'd want to say about this software.

### Contributing
Feel free to file an issue if it doesn't work for your code sample. Thanks.
