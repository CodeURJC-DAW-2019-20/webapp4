#!/bin/bash

cd ../frontend/urjcShare

docker run --rm --name front-container -v ${PWD}:/urjcShare -w /urjcShare node:latest /bin/bash -c "npm install; npm run build"

mkdir ../../backend/src/main/resources/static/new

cp -R dist/urjcShare/* ../../backend/src/main/resources/static/new

cd ../..

docker run --rm -v ${PWD}/backend:/backend -w /backend maven:alpine mvn package

docker image build -t crusasul/urjcshare -f docker/Dockerfile .

docker login

docker push crusasul/urjcshare
