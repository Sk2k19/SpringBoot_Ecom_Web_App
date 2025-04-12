# 🛍️ Product Management APIs using Spring Boot + FakeStore API

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.x-brightgreen)
![Build](https://img.shields.io/badge/build-passing-success)
![REST](https://img.shields.io/badge/API-RESTful-orange)
![License](https://img.shields.io/badge/license-MIT-blue)

> 🔨 A production-style Product API backend built with Spring Boot, integrated with **FakeStore API** and enhanced by **custom exception handling**, global error responses, and clean architecture.

---

## 📘 Overview

This project showcases a fully functional Product Management API built with `Spring Boot`. It integrates with the public [FakeStore API](https://fakestoreapi.com/) to perform real-world operations like create, read, and update products.

It focuses on writing **scalable**, **clean**, and **debug-friendly code** using best backend practices.

---

## 🚀 Features

✅ Create Product  
✅ Get All Products  
✅ Update Product by ID (PATCH)  
✅ Custom Exception Classes for clarity  
✅ Global Exception Handling with `@ControllerAdvice`  
✅ External API Integration using `RestTemplate`  
✅ Clean and modular service-layer architecture  
✅ Debug-friendly logs and response messages

---

## 📂 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/products` | Create a new product |
| `GET`  | `/products` | Fetch all products |
| `PATCH` | `/products/{id}` | Update product by ID |

---

## 📦 Tech Stack

| Tech        | Purpose                              |
|-------------|--------------------------------------|
| **Java 17** | Core programming language            |
| **Spring Boot 3.x** | Backend framework             |
| **RestTemplate** | External API consumption         |
| **Lombok** | Reducing boilerplate code            |
| **Maven** | Project management & dependencies      |
| **ControllerAdvice** | Global error handling       |
| **Custom Exceptions** | Specific error responses    |

---

## 🛡️ Error Handling & Debugging

- ✅ Global exception handler using `@RestControllerAdvice`
- ✅ Custom exceptions like `InvalidProductIdException` for clarity
- ✅ All errors return clean, consistent **JSON responses**
- ✅ Helps with debugging and API client feedback

### 🧪 Sample Error Response:

```json
{
  "timestamp": "2025-04-12T12:34:56.789",
  "status": 404,
  "error": "Product Not Found",
  "message": "Product with ID 15 does not exist",
  "path": "/products/15"
}
