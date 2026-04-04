# 🔗 URL Shortener — Backend

A REST API for shortening URLs, built with **Spring Boot** and **PostgreSQL**. Supports URL shortening, redirection, and click tracking.

🔗 **Live Demo:** _Coming soon_

---

## ✨ Features

- 🔗 **URL Shortening** — Generate a unique 6-character short code for any URL
- 🔄 **Redirection** — Visit the short URL and get redirected to the original
- 📊 **Click Counter** — Tracks how many times each short URL has been clicked
- 🛡️ **CORS Configured** — Ready for frontend integration

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3
- Spring Data JPA + Hibernate
- PostgreSQL
- Maven

---

## 📁 Project Structure

```
src/main/java/com/yugmehta/url_shortener/
├── config/         # CORS configuration
├── controller/     # REST endpoints
├── model/          # Entity classes
├── repository/     # JPA repositories
└── service/        # Business logic
```

---

## 🚀 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/shorten` | Shorten a URL |
| GET | `/{shortCode}` | Redirect to original URL |
| GET | `/api/stats/{shortCode}` | Get click stats for a short URL |
| GET | `/health` | Health check |

### Shorten a URL

**Request:**
```http
POST /api/shorten
Content-Type: application/json

{
  "originalUrl": "https://www.example.com/very/long/url"
}
```

**Response:**
```json
{
  "id": 1,
  "originalUrl": "https://www.example.com/very/long/url",
  "shortCode": "aB3xYz",
  "createdAt": "2026-04-04T10:00:00",
  "clickCount": 0
}
```

---

## ⚙️ Getting Started Locally

### Prerequisites
- Java 21
- Maven
- PostgreSQL

### Setup

1. Clone the repo:
```bash
git clone https://github.com/yug008/url-shortener-backend.git
cd url-shortener-backend
```

2. Create a PostgreSQL database:
```sql
CREATE DATABASE urlshortener;
```

3. Update `src/main/resources/application.yaml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/urlshortener
    username: your_username
    password: your_password
```

4. Run the app:
```bash
./mvnw spring-boot:run
```

App runs on `http://localhost:8080`

---

## 🌍 Deployment

Deployed on **Railway** with a managed PostgreSQL database.

---

## 📬 Contact

**Yug Mehta**
- GitHub: [@yug008](https://github.com/yug008)
