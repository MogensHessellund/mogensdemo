# Start with a base image containing Java runtime
FROM darina.azurecr.io/build/java:17.0

# Add Maintainer Info
LABEL maintainer="mogens.hessellund@cgi.com"

# Make port 8080 available to the world outside this container
EXPOSE 8000

# The application's jar file
ARG JAR_FILE=./target/npu-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} npu.jar

# Run the jar file
ENTRYPOINT ["java", "-Dspring.profiles.active=docker","-Duser.country=DK","-Duser.timezone=Europe/Copenhagen","-Djava.security.egd=file:/dev/./urandom","-jar","/npu.jar"]

