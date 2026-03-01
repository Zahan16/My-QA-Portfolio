# Software Quality Engineering Portfolio

A collection of automated test suits to test frontend, backend and API services. Developed using Java, Selenium and Postman.

## Test Matrix

| **Test Level** | **Tool** | **Focus** |
| :--------: | :--: | :---: |
| UI/Frontend | Selenium WebDriver | End-to-End user login flow |
| Database | Java/JDBC | SQL Data integrity & NULL constraints |
| API/Service | Postman/Newman | REST API Schema & Status Codes |

## How to run

This portfolio is built using **Java (Maven)** and **Node.js (Newman)**.

### 1. UI Automation (Selenium)

- **Pre-requisites:** Mozilla Firefox installed
- **Run Command:** ```bash 
  mvn clean compile exec: java -Dexec.mainClass="App"

### 2. Database Integrity (JDBC)

- **Pre-requisites:** None (Uses SQLite in-memory DB.)
- **Run Command:** ```bash
  mvn clean compile exec: java -Dexec.mainClass="App"

### 3. API Validation (Postman/Newman)

- **Pre-requisites:** Node.js installed
- **Run Command:** ```bash
  newman run api-validation-postman/JSONPlaceHolder API Tests.postman_collection.json