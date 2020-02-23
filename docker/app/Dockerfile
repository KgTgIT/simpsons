FROM openjdk:8-jre-alpine

# Volume for Tomcat working directory made by Spring Boot
VOLUME /tmp

# Volume for server logs
VOLUME /log

# Exposing ports for app and debug
EXPOSE 8083 5005

# Path to external configuration
ENV CONFIGURATION_PATH=/configuration

# Volume to enable mount point
VOLUME $CONFIGURATION_PATH

# Property file to use by Spring Boot
ENV spring.config.location="file:.$CONFIGURATION_PATH/application.yml"

# Environment variable allowing to pass own JVM parameters
ENV JAVA_OPTIONS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"

# Copy configuration
COPY configuration $CONFIGURATION_PATH

# Copy jar with application
COPY simpsons-0.0.1-SNAPSHOT.jar /

# Running the jar
ENTRYPOINT ["java","-jar","./simpsons-0.0.1-SNAPSHOT.jar","${JAVA_OPTIONS}"]