BASE_DIR = Hospital-Management
SERVICES = $(BASE_DIR)/api-gateway $(BASE_DIR)/appointment-service $(BASE_DIR)/case-service $(BASE_DIR)/directory-service $(BASE_DIR)/patient-service
LIB_PROJECT = $(BASE_DIR)/hospital-console-fxml
REPO_URL = https://github.com/Ganeshkulkarni8459/the-mono-repo.git

all: clone git_status git_pull git_stash build_lib build_services build_images push_images

clone:
	@echo "Cloning all services and JavaFX project"
	@for service in $(SERVICES); do \
		git clone $(REPO_URL) $$service; \
	done
	@git clone $(REPO_URL) $(LIB_PROJECT)

git_status:
	@echo "Printing Git status of all projects"
	@for project in $(SERVICES) $(LIB_PROJECT); do \
		echo "Status for $$project:"; \
		(cd $$project && git status); \
	done

git_pull:
	@echo "Pulling latest changes for all projects"

	@for project in $(SERVICES) $(LIB_PROJECT); do \
		echo "Pulling $$project"; \
		(cd $$project && git pull); \
	done

git_stash:
	@echo "Stashing changes for all projects"
	@for project in $(SERVICES) $(LIB_PROJECT); do \
		echo "Stashing $$project"; \
		(cd $$project && git stash); \
	done

build_lib:
	@echo "Building JavaFX library project"
	@(cd $(LIB_PROJECT) && mvn clean install)

build_services:
	@echo "Building all services"
	@for service in $(SERVICES); do \
		echo "Building $$service"; \
		(cd $$service && mvn clean install); \
	done

build_images:
	@echo "Building Docker images for all services"
	@for service in $(SERVICES); do \
		echo "Building Docker image for $$service"; \
		service_name=$$(basename $$service); \
		(cd $$service && docker build -t $(DOCKER_REGISTRY_USER)/$$service_name:latest .); \
	done

docker_login:
	@echo "Logging in to Docker Hub"
	@echo $(DOCKER_REGISTRY_PAT) | docker login -u $(DOCKER_REGISTRY_USER) --password-stdin

push_images: docker_login
	@echo "Pushing Docker images to Docker Hub"
	@for service in $(SERVICES); do \
		service_name=$$(basename $$service); \
		echo "Pushing Docker image for $$service_name"; \
		docker push $(DOCKER_REGISTRY_USER)/$$service_name; \
	done
