#!/usr/bin/env bash
./gradlew clean build -x test

# Copy created jar file (for docker build context, better solution would be copying to the build directory)
cp ./build/libs/* ./docker/app

docker-compose -f ./docker/docker-compose.yml -p simpsons up
