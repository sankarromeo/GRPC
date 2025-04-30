# gRPC vs REST API POC 🚀

This project is a Proof of Concept (POC) to demonstrate the differences between **gRPC** and **REST APIs**, covering:
- Creating a **gRPC Server and Client**
- Features and benefits of **gRPC**
- Comparing **gRPC** with traditional **REST API**
- Introducing a **gRPC Gateway** to expose gRPC services as REST endpoints
- Performing a **performance test using Gatling** for both gRPC and REST APIs
- Analyzing and comparing the results 📊

---

## 📌 Project Structure

grpc-poc/ ├── grpc-server/ ├── grpc-client/ ├── grpc-gateway/ ├── rest-api/ ├── gatling-performance-test/ ├── proto/ │ └── greeting.proto └── README.md


---

## 🔍 What is gRPC?

- gRPC is a **high-performance, open-source Universal RPC framework** initially developed by Google.
- It uses **HTTP/2** for transport, **Protocol Buffers (protobuf)** as the interface description language, and enables efficient communication between distributed systems.

### ✳️ Key Features
- Contract-first API development using **.proto files**
- **HTTP/2** based: multiplexing, streaming, header compression
- **Binary serialization (Protocol Buffers)** for smaller, faster payloads
- Supports **bi-directional streaming**
- Built-in **authentication, load balancing, and deadlines**

---

## 🔍 gRPC vs REST API Comparison

| Criteria                | gRPC                                        | REST API                          |
|:------------------------|:--------------------------------------------|:----------------------------------|
| Transport Protocol       | HTTP/2                                      | HTTP/1.1                          |
| Message Format           | Protocol Buffers (binary)                   | JSON (text-based)                 |
| Performance              | Faster due to binary format & HTTP/2        | Slower due to text-based JSON     |
| Streaming Support        | Bi-directional, Client/Server/Unary         | Limited (via HTTP 1.1 SSE/WebSockets) |
| Contract Definition      | `.proto` file (IDL)                         | No formal contract (Swagger/OpenAPI optional) |
| Language Support         | Multi-language (Go, Java, Python, etc.)     | Multi-language                    |
| Browser Support          | Needs gRPC-web or gateway                   | Native support                    |
| Tooling & Debugging      | Requires tooling (e.g., BloomRPC, Postman with gRPC support) | Mature, browser-friendly tools    |

---

## 📡 gRPC Gateway Integration

**Purpose of gRPC Gateway**  
- Exposes gRPC services as **RESTful HTTP APIs**
- Acts as a bridge for clients unable to consume gRPC (like web browsers)
- Converts REST requests into gRPC and sends them to gRPC server

**Use Case in this POC**
- Enable easy testing of gRPC services via REST endpoints  
- Allows comparison of performance and API behavior via REST and gRPC interfaces

---

## 📈 Performance Testing using Gatling

We’ll use **Gatling** to load test both the gRPC and REST endpoints and compare the throughput and response times.

### ✳️ Test Plan  
- 1000 requests per second  
- Test duration: 2 minutes  
- Compare **Average Response Time**, **Max Response Time**, **Requests/sec**

### 📊 Sample Metrics (Hypothetical Example)

| API Type | Avg Response Time (ms) | Max Response Time (ms) | Requests/sec |
|:----------|:-------------------------|:------------------------|:----------------|
| gRPC      | 10                        | 30                       | 950             |
| REST      | 120                       | 400                      | 720             |

---

## ⚙️ How to Run the POC

### 📦 Prerequisites
- Java 17+
- Maven
- Docker (for containerized run)
- Gatling
- gRPC / REST tools: BloomRPC, Postman

### 🛠️ Steps

1. **Compile proto files**

```bash
protoc --java_out=grpc-server/src/main/java --grpc-java_out=grpc-server/src/main/java proto/greeting.proto


📦 How to Run the POC
📌 Prerequisites
Java 17+

Maven

Docker (if running containers)

Gatling

Tools for testing: BloomRPC / Postman (with gRPC plugin)

🛠️ Steps to Run
Compile .proto Files

bash
Copy
Edit
protoc --java_out=grpc-server/src/main/java --grpc-java_out=grpc-server/src/main/java proto/greeting.proto
Run the gRPC Server

bash
Copy
Edit
cd grpc-server
./mvnw spring-boot:run
Run the gRPC Client

bash
Copy
Edit
cd grpc-client
./mvnw spring-boot:run
Run the gRPC Gateway

bash
Copy
Edit
cd grpc-gateway
./mvnw spring-boot:run
Run the REST API Server

bash
Copy
Edit
cd rest-api
./mvnw spring-boot:run
Execute the Gatling Performance Test

bash
Copy
Edit
cd gatling-performance-test
./mvnw gatling:test
