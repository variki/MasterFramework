#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

echo "Checking if hub is ready - $seleniumGridURL"

while [ "$( curl -s http://$seleniumGridURL:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

echo "$seleniumGridURL - Node registration is done and ready to use"
# start the java command
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
-DseleniumGridURL=$seleniumGridURL \
-Dbrowser=$browser \
org.testng.TestNG $MODULE