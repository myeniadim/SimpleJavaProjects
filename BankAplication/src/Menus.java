public class Menus { //changePassword
    public static void adminMenu(Admin admin) {
        int option;
        System.out.println(" ");
        System.out.println("Welcome " + admin.getName() + " " + admin.getSurname());
        System.out.println(" ");
        System.out.println("----------------------------");
        System.out.println("(0) - See Your Permissions");
        System.out.println("(1) - Change Your Password");
        System.out.println("(2) - Register a New Admin");
        System.out.println("(3) - See an Admin's Permissions");
        System.out.println("(4) - Add Permission to an Admin");
        System.out.println("(5) - Register a New Customer");
        System.out.println("(6) - Check a Customer's Balance");
        System.out.println("(7) - Deposit a Customer's Money");
        System.out.println("(8) - Withdraw a Customer's Money");
        System.out.println("(9) - Exit");
        System.out.println("----------------------------");
        String name;
        String surname;
        int id;
        String password;
        Admin newAdmin;
        Customer newCustomer;
        double amount;
        do {
            option = Operations.getIntegerInputFromUser("Please select an operation (0-8)");
            switch (option){
                case 0:
                    System.out.println("Your permissions: " + admin.getPermissions().toString());
                    break;
                case 1:
                    String oldpassword = Operations.getStringInputFromUser("Please enter your old password: ");
                    if (admin.getPassword().equals(oldpassword)){
                        password = Operations.getStringInputFromUser("Please enter the new password: ");
                        admin.setPassword(password);
                        FileSystem.writeAdmin(admin);
                        System.out.println("Your password is changed succesfully!");
                    }else {
                        System.out.println("Your password is not correct!");
                    }
                    break;
                case 2:
                    if (admin.hasPermission("registerAdmin")) {
                        name = Operations.getStringInputFromUser("Please enter the new admin's name");
                        surname = Operations.getStringInputFromUser("Please enter the new admin's surname");
                        id = Operations.GenerateId("Admin");
                        password = Operations.GeneratePassword();
                        newAdmin = new Admin(name, surname, id, password);
                        FileSystem.createFile("Admins\\"+id);
                        FileSystem.writeAdmin(newAdmin);
                        System.out.println("The new admin is registered. Name: " + name + " Surname: " + surname);
                        System.out.println("ID: " + id + " Password: " + password);
                        System.out.println("Please say the admin to change his/her password!");
                    }else {
                        System.out.println("You have not permission to do that!");
                    }
                    break;
                case 3:
                    if (admin.hasPermission("seePermission")){
                        id = Operations.getIntegerInputFromUser("Please enter the admin's id: ");
                        newAdmin = FileSystem.getValueOfAdmin(id);
                        if (newAdmin != null){
                            System.out.println(newAdmin.getName() + " " + newAdmin.getSurname() + "'s permissions are: " + newAdmin.getPermissions().toString());
                        }else {
                            System.out.println("There is no admin with that id!");
                        }
                    }else {
                        System.out.println("You have not permission to do that!");
                    }
                case 4:
                    if (admin.hasPermission("addPermission")) {
                        id = Operations.getIntegerInputFromUser("Please enter the admin's id: ");
                        newAdmin = FileSystem.getValueOfAdmin(id);
                        if (newAdmin != null) {
                            String permission = Operations.getStringInputFromUser("Please enter the permission you want: ");
                            if ((permission.equals("registerAdmin")) || permission.equals("addPermission") || permission.equals("customerOperations")) {
                                if (!newAdmin.hasPermission(permission)) {
                                    newAdmin.addPermissions(permission);
                                    FileSystem.writeAdmin(newAdmin);
                                    System.out.println("The permission is added to Admin succesfully!");
                                }else {
                                    System.out.println("The admin has already that permission!");
                                }
                            }else {
                                System.out.println("There are 4 permissions: registerAdmin, addPermission, customerOperations, seePermission");
                            }
                        }else{
                            System.out.println("There is no admin with that id!");
                        }
                    }else {
                        System.out.println("You have not permission to do that!");
                    }
                    break;
                case 5:
                    if (admin.hasPermission("customerOperations")) {
                        name = Operations.getStringInputFromUser("Please enter the new customer's name");
                        surname = Operations.getStringInputFromUser("Please enter the new customer's surname");
                        id = Operations.GenerateId("Customer");
                        password = Operations.GeneratePassword();
                        FileSystem.createFile("Customers\\"+id);
                        newCustomer = new Customer(name, surname, id, password, 0,0);
                        FileSystem.writeCustomer(newCustomer);
                        System.out.println("The new customer is registered. Name: " + name + " Surname: " + surname);
                        System.out.println("ID: " + id + " Password: " + password);
                        System.out.println("Please say the customer to change his/her password!");
                    }else {
                        System.out.println("You have not permission to do that!");
                    }
                    break;
                case 6:
                    if (admin.hasPermission("customerOperations")){
                        id = Operations.getIntegerInputFromUser("Please enter the customer's id: ");
                        newCustomer = FileSystem.getValueOfCustomer(id);
                        if (newCustomer != null){
                            System.out.println(newCustomer.getName()+" " + newCustomer.getSurname() + "'s balance is: " + newCustomer.getBalance());
                        }else {
                            System.out.println("There is no customer with that id!");
                        }
                    }else {
                        System.out.println("You have not permission to do that!");
                    }
                    break;
                case 7:
                    if (admin.hasPermission("customerOperations")){
                        id = Operations.getIntegerInputFromUser("Please enter the customer's id: ");
                        newCustomer = FileSystem.getValueOfCustomer(id);
                        if (newCustomer != null){
                            amount = Operations.getIntegerInputFromUser("Please enter the amount which is customer wants to deposit: ");
                            newCustomer.deposit(amount);
                            FileSystem.writeCustomer(newCustomer);
                        }else {
                            System.out.println("There is no customer with that id!");
                        }
                    }else {
                        System.out.println("You have not permission to do that!");
                    }
                    break;
                case 8:
                    if (admin.hasPermission("customerOperations")){
                        id = Operations.getIntegerInputFromUser("Please enter the customer's id: ");
                        newCustomer = FileSystem.getValueOfCustomer(id);
                        if (newCustomer != null){
                            amount = Operations.getIntegerInputFromUser("Please enter the amount which is customer wants to withdraw: ");
                            newCustomer.withdraw(amount);
                            FileSystem.writeCustomer(newCustomer);
                        }else {
                            System.out.println("There is no customer with that id!");
                        }
                    }else {
                        System.out.println("You have not permission to do that!");
                    }
                    break;
                case 9:
                    System.out.println("***************");
                    break;
                default:
                    System.out.println("Please select a correct operation (0-8)");
                    break;
            }
        }while (option != 9);
    }

    public static void customerMenu(Customer customer) {
        int option;
        System.out.println(" ");
        System.out.println("Welcome " + customer.getName() + " " + customer.getSurname());
        System.out.println(" ");
        System.out.println("----------------------------");
        System.out.println("(0) - Check Your Balance");
        System.out.println("(1) - Deposit Your Money");
        System.out.println("(2) - Withdraw Your Money");
        System.out.println("(3) - See Your Previous Transaction");
        System.out.println("(4) - Change Password");
        System.out.println("(5) - Exit");
        System.out.println("----------------------------");
        double amount;
        do {
            option = Operations.getIntegerInputFromUser("Please select an operation (0-4)");
            switch (option){
                case 0:
                    System.out.println("Your balance is: " + customer.getBalance());
                    break;
                case 1:
                    amount = Operations.getIntegerInputFromUser("Please enter the amount which is you want to deposit: ");
                    customer.deposit(amount);
                    FileSystem.writeCustomer(customer);
                    break;
                case 2:
                    amount = Operations.getIntegerInputFromUser("Please enter the amount which is you want to withdraw: ");
                    customer.withdraw(amount);
                    FileSystem.writeCustomer(customer);
                    break;
                case 3:
                    double prevTrans = customer.getPrevTrans();
                    if (prevTrans > 0){
                        System.out.println("Your money was deposited: " + prevTrans);
                    } else if (prevTrans < 0) {
                        System.out.println("Your money was withdrawn: " + Math.abs(prevTrans));
                    }else {
                        System.out.println("There is no previous transfer!");
                    }
                    break;
                case 4:
                    String oldpassword = Operations.getStringInputFromUser("Please enter your old password: ");
                    if (customer.getPassword().equals(oldpassword)){
                        String password = Operations.getStringInputFromUser("Please enter the new password: ");
                        customer.setPassword(password);
                        FileSystem.writeCustomer(customer);
                        System.out.println("Your password is changed succesfully!");
                    }else {
                        System.out.println("Your password is not correct!");
                    }
                    break;
                case 5:
                    System.out.println("***************");
                    break;
                default:
                    System.out.println("Please select a correct operation (0-4)");
                    break;
            }
        }while (option != 5);
    }
}
