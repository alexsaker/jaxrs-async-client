#!/bin/sh
mvn clean package && docker build -t com.asaker/jaxrs-async-client .
docker rm -f jaxrs-async-client || true && docker run -d -p 8080:8080 -p 4848:4848 --name jaxrs-async-client com.asaker/jaxrs-async-client 
