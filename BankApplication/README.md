# Bank Application


## Table of Contents

- [About](#about)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)


## About

The Bank Application is a Java-based command-line program that simulates a basic banking system. This application allows both administrators and customers to interact with the bank's services, including managing accounts, performing transactions, and maintaining permissions.

## Features

- **Admin and Customer Access:** The application provides separate interfaces for administrators and customers, each with their own set of functionalities.

- **User Authentication:** Users can log in with their account IDs and passwords to access their accounts.

- **Admin Operations:** Admins can view their permissions, change their passwords, register new admins, view permissions of other admins, add permissions to other admins, and register new customers.

- **Customer Operations:** Customers can check their account balances, deposit and withdraw money, view their previous transactions, and change their passwords.

- **Secure Password Generation:** The application generates secure, random passwords for new users.

- **YAML Data Storage:** User data is stored in YAML files for easy retrieval and management.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java SE Development Kit (JDK) installed.
- SnakeYAML library for YAML file handling.

## Getting Started

To get started with the Bank Application, follow these steps:

1. Clone the repository to your local machine using the following command:

   ```shell
   git clone (https://github.com/myeniadim/SimpleJavaProjects.git)
   ```

2. Compile the Java code using your preferred Java compiler.

3. Run the `Main` class to start the application.

## Usage

Follow these steps to use the Bank Application:

1. Launch the application by running `Main.java`.

2. Choose the appropriate user type (admin or customer) and follow the prompts(For admins default id:100000 password:1234).

3. Perform various banking operations, such as viewing balances, making transactions, and managing accounts.

4. Exit the application when you're done.

