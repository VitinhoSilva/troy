DOCKER_COMPOSE_CMD=docker-compose -f docker/docker-compose.yml
DIR=$(shell pwd)

clean:
	@./gradlew clean

test:
	@./gradlew test

test-cov:
	@./gradlew jacocoTestReport jacocoTestCoverageVerification
	@echo "Report available in ${DIR}/app/build/reports/jacoco/test/html/index.html"

up:
	@$(DOCKER_COMPOSE_CMD) up -d troy-db troy-db-test

down:
	@$(DOCKER_COMPOSE_CMD) down

lint:
	@./gradlew ktlintCheck

lint-format:
	@./gradlew ktlintFormat
