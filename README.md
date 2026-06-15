# 🏥 Patient Management System

> Enterprise-grade microservices architecture for managing patient records, billing, analytics, and authentication — built with Java, Spring Boot, Kafka, and gRPC.

---

## 📌 Overview

A production-style **distributed microservices application** that demonstrates real-world enterprise patterns including API Gateway routing, inter-service communication via gRPC, event-driven messaging with Apache Kafka, and JWT-based authentication.

---

## 🏗️ Architecture

```
                        ┌─────────────────┐
                        │   API Gateway   │  ← Single entry point
                        └────────┬────────┘
                                 │
          ┌──────────────────────┼──────────────────────┐
          │                      │                       │
  ┌───────▼──────┐    ┌──────────▼───────┐    ┌────────▼───────┐
  │ Patient Svc  │    │   Auth Service   │    │  Billing Svc   │
  │  (REST API)  │    │  (JWT / OAuth)   │    │   (gRPC)       │
  └───────┬──────┘    └──────────────────┘    └────────────────┘
          │
     Kafka Event
          │
  ┌───────▼──────┐
  │ Analytics Svc│  ← Consumes patient events
  └──────────────┘
```

---

## 🚀 Services

| Service | Description | Port |
|---|---|---|
| `api-gateway` | Routes all incoming requests to appropriate services | 4004 |
| `patient-service` | CRUD operations for patient records (REST API) | 4000 |
| `auth-service` | JWT-based authentication & authorization | 4005 |
| `billing-service` | Handles billing operations via gRPC | 4001 |
| `analytics-service` | Consumes Kafka events for patient analytics | 4002 |

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.x |
| Messaging | Apache Kafka |
| Inter-service | gRPC / Protocol Buffers |
| API Gateway | Spring Cloud Gateway |
| Auth | JWT (JSON Web Tokens) |
| Build Tool | Maven |

---

## ⚙️ Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+
- Docker & Docker Compose (for Kafka)

### Run Kafka (Docker)
```bash
docker-compose up -d
```

### Build & Run each service
```bash
# Example: Run patient-service
cd patient-service
mvn spring-boot:run
```

> Repeat for each service. Start `api-gateway` last.

---

## 📁 Project Structure

```
PatientManagement/
├── api-gateway/          # Spring Cloud Gateway
├── patient-service/      # Core patient CRUD + Kafka producer
├── auth-service/         # JWT authentication
├── billing-service/      # gRPC billing handler
├── analytics-service/    # Kafka consumer + analytics
└── api-requests/         # Sample HTTP request files
```

---

## 👨‍💻 Author

**Raghava Averineni** — [GitHub](https://github.com/Raghavaaverineni11) · [Email](mailto:raghavaoffc@gmail.com)
