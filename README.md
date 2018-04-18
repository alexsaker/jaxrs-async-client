# JAXRX-ASYNC-CLIENT

This is an async client example based on Adam Bien's javaee8-essentials-archetype and on json placer holder fake api.

# Build

mvn clean package && docker build -t com.asaker/jaxrx-async-client .

# RUN

docker rm -f jaxrx-async-client || true && docker run -d -p 8080:8080 -p 4848:4848 --name jaxrx-async-client com.asaker/jaxrx-async-client
