# springboot-docker
**springboot-docker** is a springboot application that stores the data in MySQL.It helps how to run springboot application in docker conatiner

# Getting Started
Clone the repository from github for development. 

## Prerequisites

##### 3rd party


## Requirements

For building and running the application you need:

- [JDK 1.11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Gradle](https://gradle.org)
- [Docker](https://www.docker.com/products/docker-desktop/)


## Build the service
To build the ```springboot-docker``` locally
* Clone the project from github and go to locally cloned folder
* Command to build and generate the jars ```gradlew clean build```
* Command to build and generate the jars without running test cases ```gradlew clean build -x test```

## Run the application

### Create a docker network
First need to crate a network
* Run the command ``` $ docker network create my-network ```

### MySQL conatiner
Now need to create the MySQL conatiner
* Create a data directory on a suitable volume into the host system, e.g. /mysql/datadir
* Start the mysql container like this: ```$ docker run --name mysql -v /mysql/datadir:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=XXXXXX  --network=my-network -d mysql:tag```

### Application conatiner
Now need to create springboot application conatiner
* Go to the root folder where Dockerfile is there from command prompt.
* Run the command ``` $ docker build -t kubetest .```

### Run application
* Run the command ``` $ docker run --netwrok=my-network -e DB_USERNAME=root -e DB_PASSWORD=XXXXXX -e DB_URL='jdbc:mysql://containername:3306/DBname' -e ACTIVE_PROFILE=docker kubetest ```



## Built With
* Gradle - Build tool
* Junit - Testing framework