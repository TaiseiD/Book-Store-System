# 📚 Bookstore System (Java + MySQL)

## 🧾 Overview

The **Bookstore System** is a **Java-based terminal application** designed to efficiently manage and explore a bookstore’s inventory.
It connects to a **MySQL database** using the **JDBC (Java Database Connectivity)** driver.
The system supports two main roles: **User** and **Storekeeper**, each with distinct privileges and features.

---

## 👥 User Roles

### 🔹 User

* Can log in using a registered account.
* Can **search books** by keywords.
* Can **view**:

  * **Popular books** (based on tags).
  * **Newly stocked books** (recently added to the system).

### 🔹 Storekeeper

* Can log in using storekeeper credentials.
* Can **add new books** to the database.
* Can **restock existing books** (update quantities).
* Can **view all books** with their stock status.
* Has **management-level access** to maintain and update inventory data.

---

## ⚙️ Features

* 🔐 Login system with role-based access (User / Storekeeper).
* 📚 Book management — add, update, delete, or search for books.
* 🔄 Restock functionality — update book quantities easily.
* 🔍 Search and filter books by category or keyword.
* 📊 View reports for **popular** and **newly stocked** titles.
* 💾 MySQL integration for persistent data storage.

---

## 🗃️ Database Integration

The project connects to a **MySQL database** hosted either locally or remotely using the following configuration:

```java
String url = "jdbc:mysql://localhost:3306/bookstore_db";
String user = "root";
String password = "";
```

**Tables used:**

* `users`
* `books`

---

## 🚀 How to Run

1. Open **XAMPP** and start the **MySQL** server.
2. Import the SQL file (`database.sql`) into your MySQL database.
3. Compile and run the Java program:

   ```bash
   javac Main.java
   java Main
   ```
4. Log in as a **User** or **Storekeeper** to explore system features.

---

## 💡 Notes

* This is a **terminal-based** (non-GUI) application for simplicity and performance.
* Can be extended in the future using **Java Swing** or **JavaFX**.
* Ideal for **academic projects** or **small bookstore inventory management**.
