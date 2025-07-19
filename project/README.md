# Mantra - Mental Health Support Platform

A comprehensive mental health support platform backend built with Spring Boot, providing secure user authentication, AI chatbot support, meditation resources, therapy booking, community forum, and contact services.

## 🎯 Features

### Core Modules

1. **User Authentication**
   - JWT-based authentication with Spring Security
   - User registration and login
   - Role-based access control (USER, ADMIN)
   - Password encryption with BCrypt

2. **AI Chatbot Support**
   - Mental health support chatbot with contextual responses
   - Handles stress, anxiety, depression, and general mental health queries
   - Extensible architecture for AI service integration

3. **Meditation Resources**
   - Meditation audio/video resource management
   - Admin-only resource creation
   - Duration tracking and categorization

4. **Therapy Booking System**
   - Therapist profile management
   - Session booking with date/time scheduling
   - Booking status tracking
   - User booking history

5. **Community Forum**
   - User-generated posts and discussions
   - Reply system for community engagement
   - Mental health topic discussions

6. **Contact System**
   - Contact form for user feedback
   - Support request management
   - Status tracking for inquiries

## 🛠️ Technology Stack

- **Java 17+**
- **Spring Boot 3.2.0**
- **Spring Security** (JWT Authentication)
- **Spring Data JPA** (Database Operations)
- **H2 Database** (Development) / **MySQL** (Production)
- **Lombok** (Boilerplate Code Reduction)
- **JWT** (io.jsonwebtoken)
- **OpenAPI/Swagger** (API Documentation)
- **Maven** (Build Tool)

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA recommended)

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd mental-health-platform
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - API Base URL: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - H2 Console: `http://localhost:8080/h2-console`

### Default Credentials

**Admin User:**
- Username: `admin`
- Password: `admin123`

**Regular User:**
- Username: `user`
- Password: `user123`

## 📚 API Documentation

### Authentication Endpoints
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login

### Chatbot Endpoints
- `POST /api/chatbot/message` - Send message to AI chatbot

### Meditation Endpoints
- `GET /api/meditations` - Get all meditation resources
- `POST /api/meditations` - Create meditation resource (Admin only)

### Therapy Endpoints
- `GET /api/therapists` - Get all therapists
- `POST /api/bookings` - Book therapy session
- `GET /api/bookings/user/{userId}` - Get user bookings

### Forum Endpoints
- `GET /api/posts` - Get all forum posts
- `POST /api/posts` - Create new post
- `POST /api/replies` - Reply to post

### Contact Endpoints
- `POST /api/contact` - Submit contact form

## 🔒 Security Features

- JWT token-based authentication
- Password encryption with BCrypt
- Role-based access control
- CORS configuration for frontend integration
- Secure endpoint protection

## 🗄️ Database Schema

### Users Table
- id, username, email, password, role, created_at, updated_at

### Therapists Table
- id, name, specialty, bio, years_of_experience, is_available, created_at, updated_at

### Meditations Table
- id, title, description, url, duration_minutes, created_at, updated_at

### Therapy Bookings Table
- id, user_id, therapist_id, session_datetime, status, notes, created_at, updated_at

### Posts Table
- id, user_id, title, content, created_at, updated_at

### Replies Table
- id, post_id, user_id, content, created_at, updated_at

### Contacts Table
- id, name, email, subject, message, status, created_at

## 🧪 Testing

Run the test suite:
```bash
mvn test
```

The project includes:
- Unit tests for services
- Integration tests for controllers
- Security testing with MockMvc

## 📋 Configuration

### Development (application.yml)
- H2 in-memory database
- Debug logging enabled
- H2 console accessible

### Production (application-prod.yml)
- MySQL database configuration
- Reduced logging
- Security hardening

## 🔧 Environment Variables

For production deployment, configure:
- `DB_USERNAME` - Database username
- `DB_PASSWORD` - Database password
- `JWT_SECRET` - JWT signing secret
- `JWT_EXPIRATION` - Token expiration time

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/mantra/
│   │   ├── config/          # Configuration classes
│   │   ├── controller/      # REST controllers
│   │   ├── dto/            # Data transfer objects
│   │   ├── entity/         # JPA entities
│   │   ├── repository/     # Data repositories
│   │   ├── security/       # Security components
│   │   └── service/        # Business logic
│   └── resources/
│       ├── application.yml
│       └── application-prod.yml
└── test/                   # Test classes
```

## 🚀 Deployment

The application is ready for deployment to:
- Docker containers
- Cloud platforms (AWS, Azure, GCP)
- Traditional servers

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Support

For support and questions:
- Email: support@mantra.com
- Documentation: `/swagger-ui.html`
- Issues: Create an issue in the repository

---

**Mantra** - Supporting mental health through technology 🧠💚