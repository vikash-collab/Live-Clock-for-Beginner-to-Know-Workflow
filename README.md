# Live-Clock-for-Beginner-to-Know-Workflow
<img width="1919" height="900" alt="image" src="https://github.com/user-attachments/assets/a85e186e-6a84-4170-a907-506f95c63b0d" />


# ⏰ Live Clock Web Service – Java Full Stack Project

Perfect! This project demonstrates **how a Spring Boot backend and an HTML/JavaScript frontend are connected** and how a **full-stack application works end to end**.

---

## 🏗️ Full Stack Architecture Overview

This project has **two parts that work together** to display a live digital clock that updates every second.

---

### 🔙 Backend (Java / Spring Boot)

- Located inside the `controller` package
- `ClockController.java` exposes a REST API endpoint: `/time`
- This endpoint returns the **current system time** as a string in `HH:mm:ss` format
- Runs on a server (typically: `http://localhost:8080`)

---

### 🎨 Frontend (HTML / JavaScript)

- Located in `index.html`
- This is the **web page users see in their browser**
- It displays the current time fetched from the backend
- Uses JavaScript to update the time every second without refreshing the page

---

## 🔗 How Frontend and Backend Are Connected

<img width="700" height="701" alt="image" src="https://github.com/user-attachments/assets/83ee9f72-ece8-4e2c-975f-ecf3bd580f3f" />

## 📝 How The JavaScript Code Works (Your Frontend)


---

## 🧠 How the JavaScript Code Works (Frontend)

```javascript
function updateClock() {
    // 1. Send HTTP request to backend's /time endpoint
    fetch('/time')
        // 2. Convert response to text
        .then(response => response.text())
        // 3. Update the HTML element with the time
        .then(time => {
            document.getElementById("clock").innerText = time;
        });
}

// Call updateClock every 1000 milliseconds (1 second)
setInterval(updateClock, 1000);

// Call immediately when page loads
updateClock();
```

---

## 🧠 Backend Implementation

### ClockController.java

```java
@RestController
public class ClockController {

    @GetMapping("/time")
    public String getCurrentTime() {
        return LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
```

## 🕒 Live Clock – Explanation & Execution Flow

### 📌 Explanation

- `fetch('/time')` sends a request to the backend  
- Backend returns the current time as plain text  
- JavaScript dynamically updates the `<div>` on the page  
- `setInterval()` ensures the clock updates every second  

---

## 🔁 Full Execution Flow (Step-by-Step)

1. User opens browser → types `http://localhost:8080`
2. Spring Boot serves `index.html`
3. Browser displays the web page
4. JavaScript executes and calls `fetch('/time')`
5. Browser sends HTTP **GET** request → `/time`
6. Backend receives request → `ClockController.getCurrentTime()` runs
7. Backend calculates current time → returns `"14:30:45"` (example)
8. Frontend receives response → JavaScript updates `<div>`
9. Browser shows updated time
10. Every **1 second** → steps **4–9** repeat automatically

---

## ✅ What’s Good About This Code

- ✔ Backend returns **plain text** (simple and fast)
- ✔ Frontend uses modern **`fetch()` API**
- ✔ Automatic updates every second
- ✔ Clean **separation of concerns**
- ✔ No page refresh required

---

## 💡 Why This Works Well (Spring Boot Advantages)

- Spring Boot automatically serves static files from `/static`
- Same port (`8080`) for frontend and backend → **no CORS issues**
- Frontend can call `/time` directly without full URL
- Minimal configuration, maximum productivity

---

## 🚀 How to Run the Project

1. Generate the project using **Spring Initializr**
   - **Project:** Maven  
   - **Language:** Java  
   - **Java Version:** 17  
   - **Dependency:** Spring Web  

2. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
3. Open your browser and navigate to:
   ```bash
   http://localhost:8080
   ```



# MavenProject format for Spring MVC

```
spring-rest-api/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── springrestapi/
│   │   │               ├── SpringRestApiApplication.java
│   │   │               │
│   │   │               ├── config/
│   │   │               │   ├── SecurityConfig.java
│   │   │               │   ├── SwaggerConfig.java
│   │   │               │   └── DatabaseConfig.java
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   ├── UserController.java
│   │   │               │   ├── ProductController.java
│   │   │               │   └── AuthController.java
│   │   │               │
│   │   │               ├── service/
│   │   │               │   ├── UserService.java
│   │   │               │   ├── ProductService.java
│   │   │               │   └── impl/
│   │   │               │       ├── UserServiceImpl.java
│   │   │               │       └── ProductServiceImpl.java
│   │   │               │
│   │   │               ├── repository/
│   │   │               │   ├── UserRepository.java
│   │   │               │   └── ProductRepository.java
│   │   │               │
│   │   │               ├── model/
│   │   │               │   ├── entity/
│   │   │               │   │   ├── User.java
│   │   │               │   │   ├── Product.java
│   │   │               │   │   └── BaseEntity.java
│   │   │               │   │
│   │   │               │   └── dto/
│   │   │               │       ├── request/
│   │   │               │       │   ├── UserRequestDto.java
│   │   │               │       │   └── ProductRequestDto.java
│   │   │               │       │
│   │   │               │       └── response/
│   │   │               │           ├── UserResponseDto.java
│   │   │               │           ├── ProductResponseDto.java
│   │   │               │           └── ApiResponse.java
│   │   │               │
│   │   │               ├── exception/
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   ├── ResourceNotFoundException.java
│   │   │               │   ├── BadRequestException.java
│   │   │               │   └── CustomException.java
│   │   │               │
│   │   │               ├── security/
│   │   │               │   ├── JwtTokenProvider.java
│   │   │               │   ├── JwtAuthenticationFilter.java
│   │   │               │   └── CustomUserDetailsService.java
│   │   │               │
│   │   │               ├── mapper/
│   │   │               │   ├── UserMapper.java
│   │   │               │   └── ProductMapper.java
│   │   │               │
│   │   │               ├── validator/
│   │   │               │   ├── UserValidator.java
│   │   │               │   └── ProductValidator.java
│   │   │               │
│   │   │               └── util/
│   │   │                   ├── DateUtil.java
│   │   │                   └── Constants.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       ├── application-prod.properties
│   │       ├── application-test.properties
│   │       │
│   │       ├── db/
│   │       │   └── migration/
│   │       │       ├── V1__Create_user_table.sql
│   │       │       ├── V2__Create_product_table.sql
│   │       │       └── V3__Insert_sample_data.sql
│   │       │
│   │       ├── static/
│   │       │   ├── css/
│   │       │   ├── js/
│   │       │   └── images/
│   │       │
│   │       └── templates/
│   │           └── email/
│   │               └── welcome.html
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── springrestapi/
│                       ├── SpringRestApiApplicationTests.java
│                       ├── controller/
│                       │   ├── UserControllerTest.java
│                       │   └── ProductControllerTest.java
│                       ├── service/
│                       │   ├── UserServiceTest.java
│                       │   └── ProductServiceTest.java
│                       └── repository/
│                           ├── UserRepositoryTest.java
│                           └── ProductRepositoryTest.java
│
├── .gitignore
├── pom.xml
├── README.md
├── Dockerfile
└── docker-compose.yml

```



























































