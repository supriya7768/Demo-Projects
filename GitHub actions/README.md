# Automated Functional Test with GitHub Actions Workflow

This project demonstrates an automated functional testing using GitHub Actions. It includes Postman CLI for running API tests and Docker containers to create a consistent, isolated environment for testing and deployment.

---

## Purpose

The repository is designed to:
- Automate testing using containerized environments.
- Externalize test parameters for flexibility.
- Generate and publish test results for review.

## Prerequisites

Before starting, ensure you have the following installed:

- **OpenJDK (Recommended version: OpenJDK 21 or later)**
- **Docker**
- **Gradle**
- **Postman/Newman**
- **Git Installed Locally**
- **GitHub Account**

---

## 1. **Build Process**

#### 1.1 Clone the Repository
```bash
git clone https://github.com/supriya7768/Demo-GitHub-actions.git
```

#### 1.2 Checkout to the Main Branch
``` bash
git checkout main
```

#### 1.3 Build the Project Using Gradle
``` bash
./gradlew clean build
```

## 2. **GitHub Actions Workflow**

#### 2.1 Trigger the Workflow

- **Push to the** ```main``` **branch**: Whenever code is pushed to the main branch, the workflow will automatically run.

- **Pull Request to the** ```main``` **branch**: If a pull request is created or updated for the main branch, the workflow will also be triggered automatically.
  

#### Here’s the full GitHub Actions workflow defined in .github/workflows/test.yml :
```
name: Build and Test Project

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

permissions:
  contents: read

jobs:
  build-and-deploy:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v4
   
    - name: Set up JDK 21
      uses: actions/setup-java@v4
      with:
        java-version: '21'
        distribution: 'temurin'
        cache: gradle
   
    - name: Setup Gradle
      uses: gradle/actions/setup-gradle@v3
     
    - name: Grant execute permission for gradlew
      run: chmod +x gradlew
     
    - name: Build and Test with Gradle
      run: ./gradlew build

    - name: Create Docker Network
      run: docker network create docker-network 
   
    - name: Docker Compose Up
      run: docker compose up -d

    - name: Wait for Container
      run: sleep 20

    - name: Pull Newman Docker Image
      run: docker pull postman/newman:latest
   
    - name: Run Tests using Newman
      run: |
        docker run --network docker-network \
          -v ${{ github.workspace }}:/workspace \
          postman/newman:latest run /workspace/postman_collection.json \
          --environment /workspace/postman_environment.json \
          --iteration-data /workspace/data.json \
          --reporters cli,html \
          --reporter-html-export /workspace/newman-report.html

    - name: Docker Compose Down
      run: docker compose down

    - name: Upload Newman Report
      uses: actions/upload-artifact@v3
      with:
        name: newman-report
        path: newman-report.html

```

### Workflow Steps Breakdown :

#### 1. Workflow Name and Trigger Events :
- The workflow is named **build_and_deploy** Project.
- It is triggered by:
  - A **push** to the ```main``` branch.
  - A **pull** request targeting the ```main``` branch.
  - A manual trigger via the GitHub UI (enabled using workflow_dispatch).

#### 2. Permissions : 

Only **read** access to repository contents is granted to ensure limited scope.

#### 3. Job - build_and_deploy :

The job runs on an ```ubuntu-latest``` runner.

#### 4. Steps :

- **Checkout Repository** :
The ```actions/checkout@v4``` action clones the repository to the runner.

- **Set Up Java** :
  - The ```actions/setup-java@v4``` action configures ```Java 21``` with the Temurin distribution.
  - Gradle caching is enabled to improve build performance.
    
- **Set Up Gradle** : The ```gradle/actions/setup-gradle@v3``` action prepares Gradle for the build.
  
- **Grant Execute Permission**: Ensures that the Gradle wrapper script (gradlew) is executable.

- **Build and Test** : Runs ```./gradlew build``` to build the project and execute unit tests.

- **Start Services with Docker Compose** :
    - Uses ```docker compose up -d``` to start containers defined in the **docker-compose.yml** file.
    - **Includes**:
      - PostgreSQL database 
      - Spring Boot application 

- **Wait for Containers to Start** : Adds a delay (sleep 20) to ensure containers are fully initialized.

- **Run Postman Tests** : Runs Postman tests using ```Newman CLI``` in a Docker container.

- **The docker run command ensures** :
  - Tests are run on the same Docker network.
  - ``` -v ${{ github.workspace }}:/workspace ``` option mounts the GitHub Actions workspace{ ```github.workspace``` } (host directory) to the /workspace directory inside the Docker container. This allows the container to access files from the repository (e.g., Postman collection) and save outputs (e.g., test results) back to the host.
  - Test results are exported to a JSON file (functional-test-results.json).

- **Upload Test Results** :
  - The ```actions/upload-artifact@v3``` action uploads the JSON file containing the test results to GitHub.
  - The artifact is named test-results.

- **Stop Services**: Uses ```docker compose down``` to stop and remove all running containers, ensuring a clean environment for future workflow runs.


 #### Docker Compose Configuration
The docker-compose.yml file configures the services for the Spring Boot application and PostgreSQL database.

**docker-compose.yml**
```
version: '3'

services:
  demo:
    build:
      context: .
      dockerfile: Dockerfile
    container_name: demo-github-actions-demo
    ports:
      - "8080:8080"
    depends_on:
      - postgres
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/Demo
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: root
    networks:
      - docker-network

  postgres:
    image: postgres:16
    environment:
      POSTGRES_DB: Demo
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: root
    ports:
      - "5434:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data
    networks:
      - docker-network

networks:
  docker-network:
    driver: bridge
    external: true

volumes:
  pgdata:
```

- PostgreSQL Service:
  - Runs a PostgreSQL database with default credentials.
  - Maps port 5432 from the container to the host.
  - Uses a named volume postgres-data to persist data across container restarts.
    
- Spring Boot Application Service:
  - Builds the Spring Boot application from the local Dockerfile.
  - Waits for the PostgreSQL container to be ready (depends_on).
  - Exposes port 8080 for the application.
  - Configures Spring Boot to connect to the PostgreSQL container.

- Networks and Volumes:
  - The docker-network bridge network is used to ensure the services can communicate.
  - The postgres-data volume is used to persist the database's data.




