# Task Manager API

A Spring Boot application that provides RESTful APIs for managing tasks with different statuses.

## Features

### Task Management
- Complete CRUD operations for tasks
- Task status tracking (A_FAIRE, EN_COURS, TERMINE)
- Validation for task data integrity

### Task Management Endpoints
1. Task Endpoints
   - `GET /api/v1.0/tasks/all` - List all tasks
   - `GET /api/v1.0/tasks/{id}` - Get task by ID
   - `GET /api/v1.0/tasks/status/{status}` - Get tasks by status
   - `POST /api/v1.0/tasks` - Create a new task
   - `PUT /api/v1.0/tasks/{id}` - Update an existing task
   - `DELETE /api/v1.0/tasks/{id}` - Delete a task

### Data Validation
- Mandatory fields validation for task title and status
- Optional description field with extended length (1000 characters)
- Unique title constraint for tasks
- Automatic timestamp management for creation and updates

## Technical Stack

- Java (Spring Boot)
- Spring Data JPA for database operations
- Jakarta Validation for request validation
- Lombok for reducing boilerplate code
- Relational Database
- Cross-Origin Resource Sharing (CORS) enabled
- Swagger/OpenAPI for API documentation

## Prerequisites

1. Java 17 or higher
2. Database (PostgreSQL, MySQL, etc.)
3. IntelliJ IDEA (recommended)
4. Maven 3.6 or higher

## Setup Instructions

### 1. Database Setup

1. Install your preferred database if not already installed
2. Create a new database for the application
3. Configure the `.env` file in the project root:
   ```properties
   PORT=8080
   DB_URL=jdbc:postgresql://localhost:5432/your_database_name
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   ```

### 2. Project Setup in IntelliJ IDEA

1. Clone the repository
2. Open IntelliJ IDEA
3. Go to File -> Open and select the project directory
4. Wait for Maven to download dependencies
5. Copy .env.example to .env and update the values
6. Enable annotation processing for Lombok:
   - Go to Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors
   - Check Enable annotation processing
7. Make sure your database is running
8. Run the application:
   - Find the main application class (likely ending with `Application.java`)
   - Right-click and select Run
   - Or use Maven: `mvn spring-boot:run`
9. The application will start on http://localhost:8080 (or the port specified in your .env file)

## API Testing with Swagger UI

Access Swagger UI at http://localhost:8080/task-app/swagger-ui.html
- Test all task endpoints interactively
- View schema documentation for request and response models
- API documentation is available at http://localhost:8080/task-app/v3/api-doc

### Example API Requests

#### Create a new task
```
POST /api/v1.0/tasks
Content-Type: application/json

{
  "title": "Implement user authentication",
  "description": "Add JWT-based authentication to the application",
  "status": "A_FAIRE"
}
```

#### Get all tasks
```
GET /api/v1.0/tasks/all
```

#### Get tasks by status
```
GET /api/v1.0/tasks/status/EN_COURS
```

## Database Schema

### The tasks table includes:
- id (Primary Key)
- title (String, mandatory, unique)
- description (String, optional, max length 1000)
- status (Enum: A_FAIRE, EN_COURS, TERMINE)
- created_at (from BaseEntity)
- updated_at (from BaseEntity)

## Error Handling

### The application provides detailed error messages for:
- Invalid task data
- Task not found
- Unique constraint violations
- Validation errors

## Additional Notes

- DTOs are used for request and response data structures
- Mappers are used to convert between DTOs and entity objects
- Task status is managed through an enum (A_FAIRE, EN_COURS, TERMINE)
- API is documented using Swagger/OpenAPI annotations
- Custom Swagger/OpenAPI paths are configured:
  ```properties
  springdoc.swagger-ui.path=/task-app/swagger-ui.html
  springdoc.api-docs.path=/task-app/v3/api-doc
  ```