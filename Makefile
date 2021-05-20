# format all projects
format:
	@mvn fmt:format -f $(shell pwd)/hr-config-server/pom.xml
	@mvn fmt:format -f $(shell pwd)/hr-eureka-server/pom.xml
	@mvn fmt:format -f $(shell pwd)/hr-gateway-server/pom.xml
	@mvn fmt:format -f $(shell pwd)/hr-worker/pom.xml
	@mvn fmt:format -f $(shell pwd)/hr-payroll/pom.xml
