## 🐳 Docker Guide

List images: docker images

List containers: docker ps -a

Delete image: docker rmi imageId

Delete container: docker rm containerId

Build image: docker build -t imageName .

Run image interactive mode: docker container run -it imageId sh (bash)

Run docker compose: docker compose up --build  /  docker-compose -f docker-compose.local.yaml up --build

Stop docker compose: docker compose down  /  docker-compose -f docker-compose.local.yaml down



