# Load Booking Management System

This project is a Spring Boot application designed to manage loads and bookings for a transportation logistics system.

## Project Status (Partial Implementation)

**Note:** This project is currently under development and represents a partial implementation. Several core functionalities are implemented, but some features may be incomplete or require further refinement.

### Implemented Features

* **Load Management:**
    * Creation of new loads.
    * Retrieval of load details by ID.
    * Updating load information.
    * Deletion of loads.
    * Retrieval of all loads.
* **Booking Management:**
    * Creation of new bookings.
    * Retrieval of booking details by ID.
    * Updating booking information.
    * Deletion of bookings.
    * Retrieval of all bookings.
    * Updating booking status.
* **Data Persistence:**
    * Uses PostgreSQL database for data storage.
    * JPA/Hibernate for object-relational mapping.
* **API Endpoints:**
    * RESTful API endpoints for load and booking management.
* **Unit Testing:**
    * Unit tests implemented for service layer using Mockito.
    * Integration tests implemented for controller layer using RestTemplate.

### Current Implementation Details

* **Models:**
    * `Load` model represents load information.
    * `Booking` model represents booking information.
* **Repositories:**
    * `LoadRepository` for load data access.
    * `BookingRepository` for booking data access.
* **Services:**
    * `LoadService` provides business logic for load management.
    * `BookingService` provides business logic for booking management.
* **Controllers:**
    * `LoadController` exposes REST API endpoints for load management.
    * `BookingController` exposes REST API endpoints for booking management.
* **Testing:**
    * Unit tests for service layer are implemented, but may have compilation errors due to missing getter/setter methods within model classes, or method signature issues within the service implementations.
    * Integration tests for the controller layers are implemented.

### Pending/To-Do

* **Complete Unit Tests:**
    * Resolve compilation errors in unit tests by adding missing getter/setter methods to model classes.
    * Resolve method signature issues within the service implementations.
    * Ensure all unit tests pass successfully.
* **Complete Integration Tests:**
    * Ensure all integration tests are passing.
* **Error Handling:**
    * Implement comprehensive error handling and validation.
* **Security:**
    * Implement security measures (e.g., authentication, authorization).
* **Documentation:**
    * Add detailed API documentation using Swagger or OpenAPI.
* **Refactoring:**
    * Refactor code for improved readability and maintainability.
* **Logging:**
    * Implement logging for better debugging and monitoring.
* **Potential Features:**
    * Add features for load status tracking.
    * Add features for truck management.
    * Add features for user management.

### How to Run

1.  **Prerequisites:**
    * Java 17 or higher.
    * Maven.
    * PostgreSQL database.
2.  **Clone the Repository:**
    * `git clone <repository_url>`
3.  **Configure Database:**
    * Update database connection details in `application.properties`.
4.  **Build and Run:**
    * `mvn clean install`
    * `mvn spring-boot:run`
5.  **Run Tests:**
    * `mvn test`

### Notes

* This README will be updated as the project progresses.
* Please refer to the code for more detailed information.
