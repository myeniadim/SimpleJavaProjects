# Description


This project is a simple banking application developed using object-oriented programming with Java.

You can login to the application as an Admin or a Customer. 

Admins can:
```
See their permissions
Change their password
Register a new admin
See an admin's permissions
Add permission to an admin
Register a new customer
Check a customer's balance
Deposit money into a customer's account
Withdraw money from a customer's account
```
Customers can:
```
Check their balance
Deposit money into their account
Withdraw money from their account
See their previous transactions
Change their password
```
# Classes

There are three classes: Person, Admin, and Customer. Admin and Customer are subclasses of the Person class. The Person class has the following properties: name, surname, id, and password. The Admin class has the following property: permissions. The Customer class has the following properties: balance and previous transfer.These properties are stored in YAML files. For example, when a new admin is created, a file named 'admin's id'.yml is created, and the properties are written into it.

```yaml
#100000.yml
password: 1234
surname: admin
permissions:
- customerOperations
- registerAdmin
- addPermission
- seePermission
name: admin
```


## Installation

To clone the repository, open a terminal and navigate to the directory where you want to clone the repository. Then, run the following command:

```bash
git clone https://github.com/myeniadim/SimpleJavaProjects.git
```

## Usage

Enter the following directory:

```bash
SimpleJavaProjects\BankAplication\src
```
Then, open the Main.java file and run the code.
