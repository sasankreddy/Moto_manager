**Vehicle Management System**
Welcome to the Vehicle Management System, a comprehensive microservices-based application designed to streamline vehicle rental and maintenance operations. This project is structured to provide efficient management of vehicles, rentals, and maintenance expenses, all while ensuring seamless user interactions.

**🚀 Features**

**🔑 User and Vehicle Management**
User Registration and Login: Easily register and log in to manage your vehicles and rentals.
User Validation: Ensures that only registered users can access rental and maintenance services.
Vehcile Registration : allows user to register vehcile by taking the details
**🚗 Vehicle Rental Service**
Post Vehicles for Rent: Allows users to list their vehicles for rental with detailed specifications, including vehicle type, fuel type, brand, rental duration, location, and price.
Update and Delete Rentals: Modify or remove rental listings as needed.
Search Available Rentals: Search for available rental vehicles based on filters like vehicle type, location, dates, and price range.
**🔧 Maintenance Expense Tracking**
Expense Logging: Track maintenance and fuel expenses based on kilometers driven within a specified month.
Expense Calculation: Automatically calculate maintenance charges and fuel expenses, giving you a clear overview of monthly costs.
Vehicle Verification: Ensures that only registered vehicles can have their expenses logged and tracked.

**🛠️ Tools and Technologies**

**Core Technologies**
**Java & Spring Boot**: Chosen for its powerful ecosystem, robustness, and ease of building microservices.
**Spring Data JPA**: Simplifies database interactions, allowing easy integration with relational databases.
**MySQL**: Used as the database for storing user, vehicle, and expense data due to its reliability and scalability.
**DevOps Tools**
**Docker**: Containers are used to package microservices, ensuring consistent environments across all stages of development and deployment.
**Jenkins**: Automates the CI/CD pipeline, handling the build, test, and deployment processes to streamline and speed up development cycles.
**Kubernetes**: Manages container orchestration, ensuring high availability and scalability of the microservices.
**Ansible**: Simplifies the setup and configuration of the infrastructure, automating the deployment process.

**Why These Technologies?**
Microservices Architecture: Provides scalability, flexibility, and ease of maintenance, allowing independent development and deployment of services.
Spring Boot: Rapid development with built-in features that minimize boilerplate code, making it easier to focus on business logic.
Docker & Kubernetes: Ensure that applications are isolated, reproducible, and can scale easily with demand.
Jenkins & Ansible: Together, they create a robust CI/CD pipeline, reducing manual intervention and enhancing deployment speed and reliability.

**🔄 CI/CD Pipeline**

Our CI/CD pipeline is designed with Jenkins, leveraging Docker for containerization and deployment. The pipeline follows a structured process to ensure smooth integration, testing, and deployment of microservices.

**Pipeline Overview:**

**Pull Images**: The pipeline pulls the latest Docker images for vehiclemanager, rentalmanager, and maintenancemanager from Docker Hub. It also pulls the MySQL image for database integration.

**Create Docker Network**: A dedicated Docker network is created to ensure isolated and secure communication between the microservices and the database.

**Deploy Microservices in Order:**

Vehicle Manager: First, the vehiclemanager service is deployed, ensuring it is up and running as the primary service.
Rental Manager: Next, the rentalmanager service is deployed to interact with the vehicle management service.
Maintenance Manager: Finally, the maintenancemanager service is deployed to complete the microservice ecosystem.
Database Integration: A MySQL container is deployed within the same Docker network, providing a robust and consistent backend for all services to connect to.

**Verification:** The pipeline includes a verification step to check the status of all deployed containers, ensuring that each service is running as expected.

**Cleanup**: After the deployment and verification stages, the pipeline cleans up by removing all running containers and the Docker network to maintain a clean state.


**🛠️ Future Work and Enhancements**
Enhanced User Interface: Develop a more interactive and user-friendly front-end for better user experience.
Advanced Filtering: Introduce more filtering options for vehicle searches, such as rating and availability status.
Automated Maintenance Alerts: Add features that notify users of upcoming maintenance based on usage patterns.
AI-driven Pricing Suggestions: Use machine learning to suggest optimal pricing for rentals based on market trends.
Integration with Payment Gateways: Allow users to pay for rentals and maintenance services directly within the platform.
We are continuously improving and expanding our system to include more features and enhance existing functionalities. Stay tuned for future updates!
