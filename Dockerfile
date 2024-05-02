FROM ubuntu:latest
LABEL authors="world"

ENTRYPOINT ["top", "-b"]