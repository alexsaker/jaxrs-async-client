#!/bin/sh
mvn clean package && docker build -t com.asaker/jaxrx-async-client .
docker rm -f jaxrx-async-client || true && docker run -d -p 8080:8080 -p 4848:4848 --name jaxrx-async-client com.asaker/jaxrx-async-client 
