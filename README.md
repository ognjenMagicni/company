## Project Info
I have built application for package transportation. Users can send detailed description of package, driver will take it and hand it over and manager follow a whole process. Additionally user can rate a service and manager can manage drivers, vehicles and much more.

## Project Setup Guide  

This guide will help you set up the project locally on your machine. Follow the steps carefully to get everything running.

---

### **🛠️ Prerequisites**  
Before you begin, make sure you have the following installed:  
- Node.js and AngularCLI for frontend 
- MySQL and MySQL Workbench for database
- Java and IntelliJ for backend  

---

### **1. Cloning the Repository**  
To clone the project from GitHub, open a terminal and run:  

```sh
git init  
git clone git@github.com:ognjenMagicni/company.git  
cd company
git pull origin master
```

### **2. Setting database**

1. Open MySQL Workbench.
2. Create a new schema named transport.
3. Navigate to Server → Data Import → Import from Disk.
4. Set the import path to the database folder inside the cloned Git project.
5. Click Start Import and wait for the process to complete.

### 3. Setting Up the Backend

1. Open IntelliJ
2. You need to manually update your MySQL username and password in the following file: company/src/main/resources/application.yaml
3. Run FullStackDemo in transport/src/main/java/com/transport/TransportApplication.java
   
### 4. Setting Up the Frontend

1. Open new terminal
2. Navigate to the frontend directory
```sh
cd company/frontend/
npm install  
ng serve
```

### 5. Running the Application
Once both backend and frontend are running, open your browser and go to:
🔗 http://localhost:4200
