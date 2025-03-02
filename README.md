# **CoffeeAvenue - Point of Sale System** ☕  

## **Overview**  
CoffeeAvenue is a **Java-based Point of Sale (POS) system** designed for coffee shops. The system manages **orders, employees, customers, menu items, sales tracking, and admin settings**. It features **user authentication, reporting, and transaction logs**, providing a complete POS solution for efficient business operations.  

## **Features** 🚀  
✅ **User Authentication** – Secure login for admins and employees  
✅ **Order Management** – Add, update, and process customer orders  
✅ **Menu Management** – Add, modify, and remove menu items  
✅ **Customer Management** – Store and manage customer details  
✅ **Employee Management** – Track employee roles and details  
✅ **Sales & Reports** – Generate sales reports and track transactions  
✅ **User Activity Log** – Monitor actions performed by users  

## **Tech Stack** 🛠  
- **Programming Language:** Java (JDK 8+)  
- **IDE:** NetBeans  
- **Database:** MySQL  
- **GUI:** Swing (Java GUI components)  

## **Project Structure** 📂  
```
CoffeeAvenue/
│── nbproject/        # NetBeans project files (exclude private/)
│── src/              # Source code
│   ├── coffeeavenue/ # Main Java package
│   ├── images/       # UI assets & icons
│   ├── meta-inf/     # Configuration files
│── test/             # (Optional) Test cases
│── .gitignore        # Git ignore file
│── README.md         # Project documentation
```

## **Installation & Setup** 💻  
1. **Clone the repository:**  
   ```bash
   git clone https://github.com/vinuvii/CoffeeAvenue.git
   cd CoffeeAvenue
   ```
2. **Import the project into NetBeans.**  
3. **Set up the database:**  
   - Import the `coffeeavenue.sql` file into MySQL.  
   - Update database connection details in the Java code (`DatabaseConnection.java`).  
4. **Run the application** from NetBeans.  
