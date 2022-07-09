#! /bin/bash

docker-compose -f docker/docker-compose.yml up -d --no-deps --build $1
