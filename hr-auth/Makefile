format:
	mvn fmt:format -f pom.xml

build:
	mvn clean package -DskipTests

docker_build:
	docker build -t hr-auth:v1 .

docker_run:
	docker run -P --network hr-net hr-auth:v1