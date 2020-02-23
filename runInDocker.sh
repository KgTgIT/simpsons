#!/usr/bin/env bash
./gradlew clean build -x test

# Copy created jar file (for docker build context, better solution would be copying to the build directory)
cp ./build/libs/* ./docker/app

IMAGE_NAME="it.kgtg/simpsons:1.0.0"

# Removing older, duplicated container image
docker image rm -f $IMAGE_NAME

# Creating container image
docker build -t $IMAGE_NAME -f ./docker/app/Dockerfile ./docker/app

CONTAINER_NAME="simpsons"

# Stopping older, duplicated container
docker container rm -f $CONTAINER_NAME

# Starting the container
docker run --name $CONTAINER_NAME -d -p 8083:8083 -p 5005:5005 $IMAGE_NAME

# Opening shell on running container in order to check app and tmp catalogs
#docker exec -it $CONTAINER_NAME sh