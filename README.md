# Dynamic Timetable Generator

Welcome to the Dynamic Timetable Generator! This application automates the process of creating timetables for academic departments.

## Features

- **User Authentication**: Implemented JWT token-based authentication for secure user login and access to timetable generation functionalities.
- **Dynamic Timetable Generation**: Generates timetables for academic departments based on input data such as department details, courses, teachers, and timing preferences.
- **No-conflict Algorithm**: Utilizes a pure Java algorithm to ensure that no conflicts occur between teachers, courses, or laboratories in the generated timetables.
- **Email Integration**: Integrated email functionality to send generated timetables to admin email addresses, streamlining the administrative process.

## Technologies Used

- **Backend**:
  - Spring Boot
  - Java

- **Database**:
  - MySQL

- **Authentication**:
  - JWT (JSON Web Tokens)

## Installation

## Steps To Run Application Backend

1. If you already cloned my depository then we follow the given steps if not, first cloned the repository by given command:
 ```bash
   git clone https://github.com/TalonTech-CVMUHackathon/TalonTech-ServerSide.git
   ```
2. Open the code of backend folder in your preferred IDE like intelliJ IDEA
3. Configure given code in your application properties in resource folder.
    ```bash
    server.port=8080
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url= *Database URL
    spring.datasource.username= *Database Username
    spring.datasource.password= *Database Password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username= *Your Email Id
    spring.mail.password= *Application Password Of Your Email ID
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    ```
4. Make sure that you apply all the given dependencies in your porm.xml file.
    Dependencies:
    ```bash
   <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
		<groupId>com.itextpdf</groupId>
		<artifactId>itextpdf</artifactId>
		<version>5.5.13</version> 
		</dependency>
		<dependency>
			<groupId>org.apache.pdfbox</groupId>
			<artifactId>pdfbox</artifactId>
			<version>2.0.3</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.11.5</version>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId> <!-- or jjwt-gson if Gson is preferred -->
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>3.0.3</version>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>
    ```
5. Run the project, it will run on 
    ```bash
    http://localhost:8080/
    ```
6. you have to provide APIs through http://localhost:8080/.
## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

    1. Fork the repository.
    2. Create a new branch for your feature or bug fix.
    3. Make your changes and commit them.
    4. Push to your fork and submit a pull request.
