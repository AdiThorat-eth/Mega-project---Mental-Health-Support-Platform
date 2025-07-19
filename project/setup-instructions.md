# Mental Health Platform Setup Instructions

## Step-by-Step Setup in IntelliJ IDEA

### 1. Create New Maven Project
- File → New → Project
- Select Maven Archetype
- Choose maven-archetype-quickstart
- GroupId: com.mantra
- ArtifactId: mental-health-platform
- Version: 1.0.0

### 2. Replace pom.xml
Replace the generated pom.xml with the provided Spring Boot configuration

### 3. Create Package Structure
Create these packages under src/main/java/com/mantra/:
- config
- controller
- dto (with subpackages: auth, chatbot, meditation, booking, therapist, forum, contact)
- entity
- repository
- security
- service (with impl subpackage)

### 4. Create Resource Files
Under src/main/resources/:
- application.yml
- application-prod.yml

### 5. Create Test Structure
Under src/test/java/com/mantra/:
- service
- controller

### 6. Copy All Java Files
Copy each Java class to its respective package

### 7. Run the Application
- Navigate to MentalHealthPlatformApplication.java
- Right-click → Run
- Access at http://localhost:8080/swagger-ui.html

## Default Credentials
- Admin: admin/admin123
- User: user/user123

## Key Features
✅ JWT Authentication
✅ Mental Health Chatbot
✅ Meditation Resources
✅ Therapy Booking System
✅ Community Forum
✅ Contact System
✅ Swagger Documentation
✅ H2 Database Console