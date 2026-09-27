
- **Controller** — Handles HTTP requests/responses (`JournalEntryController`, `UserEntryController`, `AdminController`)
- **Service** — Business logic (`JournalEntryService`, `UserEntryService`, `WeatherService`, `EmailService`, `RedisService`)
- **Repository** — Data access via Spring Data MongoDB repositories
- **Entity** — Data models (`User`, `JournalEntry`, `ConfigJournalAppEntry`)
- **Config** — `SpringSecurity` (auth rules) and `RedisConfig` (Redis template setup)

## API Endpoints

### User

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/user` | Get all users |
| `POST` | `/user` | Register a new user (password hashed with BCrypt) |
| `PUT` | `/user/{userName}` | Update a user's details |
| `GET` | `/user/greeting` | Authenticated greeting with live weather info |

### Journal Entries

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/journal/{userName}` | Get all journal entries for a user |
| `POST` | `/journal/{userName}` | Create a new journal entry for a user |
| `GET` | `/journal/id/{myId}` | Get a single journal entry by ID |
| `PUT` | `/journal/id/{userName}/{myId}` | Update a journal entry |
| `DELETE` | `/journal/id/{userName}/{myId}` | Delete a journal entry |

## Setup & Configuration

1. Clone the repository:
```bash
   git clone https://github.com/RiyaV2024/JournalApp.git
```

2. Create `src/main/resources/application.properties` (not included in this repo for security) with the following keys:
```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/<database-name>

   spring.data.redis.host=localhost
   spring.data.redis.port=6379

   weather.api.key=<your-weather-api-key>

   spring.mail.host=smtp.gmail.com
   spring.mail.port=587
   spring.mail.username=<your-email>@gmail.com
   spring.mail.password=<your-gmail-app-password>
   spring.mail.properties.mail.smtp.auth=true
   spring.mail.properties.mail.smtp.starttls.enable=true

   server.port=8080
```

3. Run the application:
```bash
   mvn spring-boot:run
```

4. Test endpoints using Postman at `http://localhost:8080`.

## Future Improvements

- Migrate authentication from Basic Auth to JWT for stateless, token-based access
- Add global exception handling with `@RestControllerAdvice`
- Add request validation with `@Valid` and DTOs
- Write additional unit and integration tests

## Author

**Riya Verma**
GitHub: [@RiyaV2024](https://github.com/RiyaV2024)