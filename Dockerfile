FROM airhacks/glassfish
COPY ./target/jaxrx-async-client.war ${DEPLOYMENT_DIR}
