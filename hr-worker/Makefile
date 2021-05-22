format:
	mvn fmt:format -f pom.xml

build:
	mvn clean package -DskipTests

docker_build:
	docker build -t hr-worker:v1 .

docker_db_run:
	docker run -p 5433:5432 --name hr-worker-pg12 --network hr-net -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres postgres:12-alpine

docker_run:
	docker run -P --network hr-net hr-worker:v1
