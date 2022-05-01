#!/bin/bash

TAG="demo/npu"
AZURE="darina.azurecr.io"

docker build -t ${TAG} --rm=true .

docker tag ${TAG} ${AZURE}/${TAG}
docker push ${AZURE}/${TAG}

