#!/bin/sh
# Build and deploy the Maven code to S3
export AWS_ACCESS_KEY_ID=AKIAITAEU7UMVY5XRFRQ
export AWS_SECRET_ACCESS_KEY=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
mvn -B compile
mvn -B test
mvn -B deploy -DskipTests
