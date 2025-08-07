# PetLink

PetLink is a Java-based application for managing pet owners and their pets. It provides a comprehensive system for storing, retrieving, updating, and deleting information about pet owners and their associated pets.

## Features

- **Owner Management**: Add, view, update, and delete pet owners
- **Pet Management**: Update pet details associated with owners
- **Batch Operations**: Update pet names based on pet type
- **Database Integration**: Persistent storage using MySQL database
- **Exception Handling**: Robust error handling for various scenarios
- **Interactive CLI**: User-friendly command-line interface

## Technologies Used

- Java
- JDBC for database connectivity
- MySQL database
- Object-Oriented Programming principles
- DTO (Data Transfer Object) pattern
- Repository pattern
- Service layer architecture

## Project Structure

```
PetLink/
├── src/
│   ├── com/petlink/
│   │   ├── config/           # Database and properties configuration
│   │   ├── dto/              # Data Transfer Objects
│   │   ├── enums/            # Enumeration types (Gender, PetType)
│   │   ├── exception/        # Custom exceptions
│   │   ├── repository/       # Data access layer
│   │   │   └── impl/         # Repository implementations
│   │   ├── service/          # Business logic layer
│   │   │   └── impl/         # Service implementations
│   │   ├── util/             # Utility classes
│   │   └── Main.java         # Application entry point
│   └── resources/            # Configuration files
│       ├── database.properties  # Database connection properties
│       ├── database.sql         # SQL schema and queries
│       └── messages.properties  # Error message templates
```

## Setup and Installation

1. Clone the repository
2. Ensure you have Java JDK 8 or higher installed
3. Set up MySQL database:
   - Create a database named `petlink_jdbc`
   - Execute the SQL script in `src/resources/database.sql`
4. Configure database connection:
   - Update `src/resources/database.properties` with your MySQL credentials
5. Compile and run the application:
   ```
   javac -d out src/com/petlink/Main.java
   java -cp out com.petlink.Main
   ```

## Usage

The application provides an interactive command-line interface with the following options:

1. Add a new owner with pet details
2. Fetch owner details by ID
3. Update pet details of an owner
4. Delete an owner
5. Fetch all owners
6. Update pet names based on pet type (adds prefix "Mr." or "Miss" based on gender)

## Database Schema

The application uses a single table `owner_table` with the following structure:

```sql
CREATE TABLE owner_table (
    id INT NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    mobile_number VARCHAR(10) NOT NULL UNIQUE,
    email_id VARCHAR(255) NOT NULL UNIQUE,
    pet_id INT NOT NULL,
    pet_name VARCHAR(255) NOT NULL,
    pet_date_of_birth DATE NOT NULL,
    pet_gender VARCHAR(255) NOT NULL,
    pet_type VARCHAR(255) NOT NULL 
);
```

The database also includes a stored procedure `add_prefix_to_pet_name` that updates pet names based on their gender and type.

## Exception Handling

The application handles various exceptions:
- `DuplicateOwnerException`: When attempting to add an owner with an ID that already exists
- `OwnerNotFoundException`: When an owner with the specified ID is not found
- `InternalServiceException`: For database and other internal errors

