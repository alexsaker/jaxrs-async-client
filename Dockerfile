FROM airhacks/glassfish
COPY ./target/jaxrs-async-client.war ${DEPLOYMENT_DIR}
