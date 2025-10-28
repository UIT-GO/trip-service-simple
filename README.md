# Driver Service Simple

This project is a Spring Boot application for managing driver events and trip creation, with integration for Kafka and WebSocket messaging.

## Features
- Listens for trip creation events from Kafka (`trip_create_wait_driver` topic)
- Broadcasts trip events to frontend clients via WebSocket (`/topic/tripCreated`)
- Provides REST APIs for driver management

## Getting Started

### Prerequisites
- Java 17+
- Maven
- Kafka server running

### Build and Run
1. Clone the repository.
2. Configure `src/main/resources/application.properties` for your Kafka and WebSocket settings.
3. Build the project:
   ```bash
   ./mvnw clean install
   ```
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

### WebSocket Frontend
Open `src/main/resources/static/index.html` in your browser. It will listen for trip events on `/topic/tripCreated` and display them.

## API Endpoints
See `DriverController.java` for available REST endpoints.

## Kafka Listener
See `CreatedTripListener.java` for Kafka event handling and WebSocket broadcasting.

## License
MIT

