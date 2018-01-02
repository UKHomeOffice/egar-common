#!/bin/sh
# Build and deploy the Maven code to S3
export AWS_ACCESS_KEY_ID=$ACCESS_KEY_ID
export AWS_SECRET_ACCESS_KEY=$ACCESS_KEY
mvn -B compile
mvn -B test
mvn -B deploy -DskipTests
