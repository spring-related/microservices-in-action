docker-compose -f docker/docker-compose.yml down && docker image prune -f
mvn clean package dockerfile:build -DskipTests && docker-compose -f docker/docker-compose.yml up --remove-orphans
