# Hospital Management System

A comprehensive Hospital Management System built with Spring Boot, designed to streamline hospital operations including doctor management, patient records, appointments, prescriptions, and billing.

## 🏥 Features

- **Doctor Management**: Create, update, retrieve, and manage doctor profiles with specialization details
- **Patient Management**: Complete patient record management with medical history
- **Appointment Scheduling**: Book and manage appointments with slot allocation
- **Prescription Management**: Digital prescription creation and management
- **Invoice & Billing**: Automated invoice generation with detailed itemization
- **Medicine Management**: Track medications prescribed with dosage instructions
- **RESTful API**: Comprehensive REST APIs for all operations
- **API Documentation**: Interactive Swagger UI for API testing and documentation

## 🛠️ Tech Stack

- **Backend Framework**: Spring Boot 3.5.5
- **Language**: Java 21
- **Database**: MySQL
- **ORM**: Spring Data JPA / Hibernate
- **Build Tool**: Maven
- **Additional Libraries**:
  - Lombok (Code generation)
  - MapStruct (DTO mapping)
  - SpringDoc OpenAPI (API documentation)
  - MySQL Connector

## 📋 Prerequisites

Before running this application, ensure you have:

- Java 21 or higher installed
- MySQL Server installed and running
- Maven 3.6+ installed
- IDE (IntelliJ IDEA, Eclipse, or VS Code with Java extensions)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <your-repository-url>
cd HospitalMgmtSys
```

### 2. Configure Database

Create a MySQL database and update the `src/main/resources/application.properties` file with your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

Or using the Maven wrapper:

**Windows:**
```bash
mvnw.cmd spring-boot:run
```

**Linux/Mac:**
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## 📚 API Documentation

Once the application is running, access the interactive Swagger UI documentation at:

```
http://localhost:8080/swagger-ui.html
```

### Available Endpoints

#### Doctor Management
- `POST /doctor/create` - Create a new doctor
- `GET /doctor/getDoctorInfo/{id}` - Get doctor details by ID
- `GET /doctor/getAllDoctors` - Get all doctors
- `PUT /doctor/update/{id}` - Update doctor information

#### Additional Modules
*(Coming soon: Patient, Appointment, Prescription, and Invoice management endpoints)*

## 🗂️ Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/HospitalMgmtSys/
│   │       ├── config/          # Configuration classes
│   │       ├── constants/       # Application constants
│   │       ├── controller/      # REST Controllers
│   │       ├── dto/             # Data Transfer Objects
│   │       ├── entity/          # JPA Entities
│   │       ├── mapper/          # MapStruct Mappers
│   │       ├── repository/      # Spring Data Repositories
│   │       └── service/         # Business Logic Services
│   │           └── impl/        # Service Implementations
│   └── resources/
│       └── application.properties
└── test/                        # Test classes
```

## 📦 Database Schema

The system includes the following main entities:

- **Doctor**: Healthcare professionals with specialization and qualification details
- **Patient**: Patient records with personal and medical information
- **Appointment**: Scheduling system for doctor-patient appointments
- **Prescription**: Digital prescriptions linked to doctors and patients
- **Medicine**: Medication details with dosage and instructions
- **Invoice**: Billing system with itemized charges
- **InvoiceItem**: Individual line items in invoices
- **Slot**: Time slot management for appointments

## 🔧 Configuration

### Application Properties

Key configuration options in `application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Server Configuration
server.port=8080

# Swagger Configuration
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

## 🧪 Testing

Run tests using Maven:

```bash
mvn test
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

Your Name - [Your GitHub Profile](https://github.com/yourusername)

## 🙏 Acknowledgments

- Spring Boot Documentation
- Spring Data JPA
- Swagger/OpenAPI
- Lombok Project
- MapStruct

## 📞 Support

For support, email your-email@example.com or open an issue in the repository.

## 🔮 Future Enhancements

- [ ] User authentication and authorization (Spring Security)
- [ ] Role-based access control (Admin, Doctor, Receptionist)
- [ ] Email notifications for appointments
- [ ] Report generation (PDF/Excel)
- [ ] Dashboard with analytics
- [ ] Mobile app integration
- [ ] Telemedicine features
- [ ] Lab test management
- [ ] Pharmacy integration
- [ ] Insurance claim processing

---

**Note**: This application is under active development. Feel free to contribute or report issues!
