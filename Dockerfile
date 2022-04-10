FROM variki/openjdk11-alpine:latest
RUN apk add curl jq
#workspace
WORKDIR /user/share/docker


#ADD .jar user target from host
#into this image

ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
ADD target/test-classes test-classes

# Add suite files
ADD search-result.xml search-result.xml
ADD testng.xml	testng.xml

# Add healthcheck
ADD healthcheck.sh  healthcheck.sh
RUN dos2unix healthcheck.sh

ENTRYPOINT sh healthcheck.sh




