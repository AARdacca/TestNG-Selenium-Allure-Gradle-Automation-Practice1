# 🤖 Automation Testing Project

## 📌 Project Description
This project is an automated testing suite for the web application hosted at **Daily Finance**. The objective is to ensure the key functionalities of the application — such as user registration, password reset, item addition, profile updates, and admin functionalities — are working as expected. The tests include both positive and negative scenarios to validate the robustness and reliability of the application.

## 🛠️ Prerequisites
Before running the tests, ensure you have the following set up:

### 💻 System Requirements:
- 🖥️ Operating System: Windows / Mac / Linux
- ☕ JDK (Java Development Kit) installed (Version 8 or above)
- 🌐 Browser drivers installed (e.g., ChromeDriver for Chrome)

### 🧰 Tools and Frameworks:
- 🕸️ Selenium WebDriver
- 📋 JUnit or TestNG for test management
- 🧱 Maven / Gradle for dependency management

### 🔐 Credentials:
- ✅ A valid Gmail account to test email-related functionality.
- 👨‍💼 Admin credentials for the application (to be securely passed from the terminal).

### 📦 Dependencies:
- 📄 Update the `build.gradle` file with required libraries such as:
  - Selenium
  - JUnit / TestNG
  - Email API libraries (e.g., JavaMail)

## ✅ What I Have Done
The following steps were automated and tested successfully:

**✅ User Registration**
- Registered a new user using a valid Gmail address.
- Validated the receipt of the “Congratulations” email.

**🔁 Password Reset**
- Implemented two negative test cases for invalid email and non-existent users.
- Validated the password reset email for the registered user.
- Successfully updated the password using the reset email link.
- Confirmed successful login with the new password.

🛒 Item Addition
- Added two items: one with all fields filled and another with only mandatory fields.
- Verified both items appear in the item list.

**🧑‍💼 User Profile Update**
- Updated the user’s email address to a new Gmail address.
- Verified successful login with the updated email.
- Ensured login with the previous email fails.

**🛠️ Admin Dashboard Validation**
- Logged in as an admin (securely passing credentials via the terminal).
- Searched for the updated email in the admin dashboard and validated its presence.
- Searched by the updated Gmail and asserted that the updated user email is showing on the admin dashboard.

**📂 Bulk User Registration and Data Extraction**
- Registered 3 additional users by reading data from a CSV file.
- Logged in as admin, retrieved all users from the user table, and successfully wrote the data into a text file.

## 🎯 Objectives

The following test scenarios were automated to validate the core functionalities of the Daily Finance application:

1. 🌐 Visit the site [https://dailyfinance.roadtocareer.net](https://dailyfinance.roadtocareer.net) and register a new user (e.g., `gmailuser+randomdigit@gmail.com`).  
   ✅ Assert that the “Congratulations” email is received.

2. 🔒 Click on the "Reset Password" link.  
   🚫 Write and assert **two negative test cases**:
   - Invalid email format
   - Non-existent email

3. 📧 Enter the valid Gmail account used during registration and click **"Send reset link"**.

4. 🔑 Retrieve the password reset email from Gmail and set a **new password**.

5. 👨‍💻 Log in with the new password to confirm successful authentication.

6. ➕ Add two items:
   - One with **all fields filled**
   - Another with **only mandatory fields**
   ✅ Assert that **both items** appear in the item list.

7. 📝 Go to the user profile and **update the email address** with a new Gmail address.

8. 🔁 Logout and log in with the **updated Gmail account**.  
   ✅ Assert:
   - Login with the new email is successful  
   - Login with the old email fails

9. 👮 Login as an admin (credentials passed securely from the terminal).

10. 🔍 Search by the updated Gmail in the admin dashboard.  
    ✅ Assert that the updated email is **visible**.

11. 📂 Register 3 additional users using data from a **CSV file**.

12. 🗃️ Login as admin and **retrieve all users** from the user table.  
    📄 Write the user data into a **text file**.


## ▶️ How to Run the Tests

Follow these steps to execute the automated tests:

1. 📦 **Clone the Repository**  
   Clone the project from the repository to your local machine.

2. 🛠️ **Set Up the Environment**  
   - Install dependencies using **Maven** or **Gradle**

3. 🔐 **Configure Credentials**  
   - Update the `config.properties` file with your **Gmail credentials** and other necessary configuration details  
   - Pass **admin credentials securely** when prompted by the terminal during execution

4. 🚀 **Run the Tests**  
   Use your preferred test runner (Maven/Gradle) to execute the test suite.

5. 📊 **View Test Reports**  
   - For **Maven**: Navigate to `target/surefire-reports`  
   - For **Gradle**: Navigate to `build/reports/tests`  

---

## 📄 Test Case Link  
🔗 [Google Sheets - Test Cases](https://docs.google.com/spreadsheets/d/1hp5ZUVi7QvY0IrBcJ1CQBWs8Y20IB8HsQMdrTmMw_qU/edit?usp=sharing)

---

## 📁 Reports  

---

## 🎥 Sample Video of Automation Process  

---