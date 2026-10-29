# Student Management REST API

A RESTful web application built using Java and Spring Boot to manage student records.

## Technologies Used
- Java
- Spring Boot
- Spring Web
- Maven
- IntelliJ IDEA
- Postman

## Student Model

Each student record contains the following fields:

- `studentId` — Student ID
- `name` — Student name
- `email` — Student email address
- `branch` — Academic branch
- `year` — Academic year
- `cgpa` — Cumulative Grade Point Average

## REST API Endpoints

Base URL: `http://localhost:8080/students`

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/students` | Retrieve all students |
| GET | `/students/{studentId}` | Retrieve a student by ID |
| POST | `/students` | Add a new student |
| PUT | `/students/{studentId}` | Update an existing student |
| DELETE | `/students/{studentId}` | Delete a student |
| GET | `/students/search?branch=CSE&year=2` | Search students by branch and year |
| GET | `/students/topper?cgpa=8.5` | Retrieve students with CGPA at or above the specified value |

## Sample JSON Request

Use this JSON body when adding a student through Postman:

```json
{
  "studentId": 106,
  "name": "Aman Gupta",
  "email": "aman@kiet.edu",
  "branch": "CSE",
  "year": 2,
  "cgpa": 8.8
}
```

For POST and PUT requests, select **Body → raw → JSON** in Postman.

## How to Run

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download the dependencies.
4. Run `StudentApplication.java`.
5. Wait for the Spring Boot application to start on port `8080`.
6. Use Postman to test the endpoints.

## Project Structure

```text
student/
├── src/
│   ├── main/
│   │   ├── java/com/kiet/student/
│   │   │   ├── StudentApplication.java
│   │   │   ├── controller/
│   │   │   │   └── StudentController.java
│   │   │   └── model/
│   │   │       └── Student.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── .gitignore
└── README.md
```

## Features

- Retrieve all student records.
- Search for an individual student by ID.
- Add, update, and delete student records.
- Search by academic branch and year.
- Retrieve students meeting a minimum CGPA threshold.
- Handle student-not-found cases with a response message.

## Data Storage

Student records are maintained in an in-memory `ArrayList`. Changes are not persisted after the application restarts.

## Testing

The API endpoints can be tested using Postman. The project submission includes screenshots of API requests and responses and the IntelliJ project structure.
