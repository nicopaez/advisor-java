#!/usr/bin/env bash

VERSION=`ls target/*.jar | sed 's/.*-//' | sed 's/.jar//'`
echo "Version $VERSION"
docker build -t advisor:$VERSION-java . --build-arg JAR_FILE=./target/advisor-$VERSION.jar
