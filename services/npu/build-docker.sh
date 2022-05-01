#!/bin/bash

TAG="labterm/npu"
AZURE="darina.azurecr.io"

docker build -t ${TAG} --rm=true .

docker tag ${TAG} ${AZURE}/${TAG}
docker push ${AZURE}/${TAG}

