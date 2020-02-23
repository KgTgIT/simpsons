# Our Coding Challenge!

Create a basic java web application that uses the json documents in our data folder here to allow users to search for and view information on our characters and display some of their quotes.

**Definition of Done**

_We need to see this_

1. A spring boot application that starts on port 8083
1. A rest api that serves up all of the characters, allows search of characters, and returns a specific character's quotes.
1. A JQuery based user interface to display the information served up by your api.
1. We would like to all CRUD operations supported in this api.
1. __Meaningful__ Junit Unit tests 

**What we're looking at**
1. A meaningful and logical rest api
1. A clean simple user interface
1. Well formatted javascript code
1. Clean gitflow workflow so we can see your thought process

**How to submit**

Fork this github repository and commit your submission to your repository, send us a link and we'll clone and review the code when it's submitted to us.

**Required Technologies:**

* Java 8
* Spring Boot 
* JUnit
* Mockito
* JQuery
* Bootstrap

**Optional Technologies**

* Docker
* Swagger

**Notes**

* We're not asking you to spin up a full database, an in memory datastore is good enough for our purposes.
* Once we recieve your submission we'll look at the code from the time you email us your submission. (Production deployments are important and should be taken with care)
* Feel free to expand on this idea add functionality beyond the base ask, this is your opportunity to show off :)

# Solution

Current solution took me about 7h (did not have more time during weekend). Because of that I did not finish all "must have" points. 
Missing features are listed [here](#further-work).

**Note**: This solution wad tested only on Windows machine. Therefore some minor parts can have problems on Linux (catalog rights, etc.).

## Running
There are couple of ways to run this project:
- execute the **runEmbedded.sh** file to run with embedded MongoDB as standalone application.
- execute the **runInDocker.sh** file to run simply just the application inside a container. **NOTE**: it requires simpsons-mongo 
host with database. If you have a local mongo, add proper entry to hosts or simply use **spring.data.mongodb.host** environment variable to overwrite it).
- execute the **runDockerCompose.sh** file in order to run docker compose with properly initialized MongoDB container and App container). 

Once application is up, open in browser following URL:

[http://localhost:8083]()

## Stack:
- Gradle
- Java 8
- Lombok
- Spring Boot
- MongoDB
- Bootstrap
- JQuery
- Thymeleaf
- Groovy + Spock + Spock Reports for tests
- Swagger
- Docker (with Docker Compose)

Swagger is running under following URLs:

[http://localhost:8083/swagger-ui.html]()

[http://localhost:8083/v2/api-docs]()

Actuator is enabled, you can try it at:

[http://localhost:8083/actuator]()

Logs are stored in log/simpsons.log file but can be view from following URL as well:

[http://localhost:8083/actuator/logfile]()

In case of docker, all data and log directory have volumes. Log volumes are mount points. Therefore you can observe log file
under _./docker/logs/app/simpsons.log_.

## Further work

- Write tests (If you like to see some test that I wrote, check my other challenge [https://github.com/KgTgIT/treasure-hunt-game]())
- Create ConfigurationProperties class instead using Value annotations.
- CRUD is developed only for phases, characters have only GET endpoints.
- Did not implemented search of characters (text index should be created for characters and proper endpoint using it)
- Use thymeleaf-security to secure the app
- Test on Linux machine
- Avoid changing URL when language is being changed