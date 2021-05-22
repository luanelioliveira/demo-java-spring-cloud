format:
	@mvn fmt:format -f pom.xml

build:
	@mvn clean package

docker_build:
	docker build -t hr-eureka-server:v1 .

docker_run:
	docker run -p 8761:8761 --name hr-eureka-server --network hr-net hr-eureka-server:v1
