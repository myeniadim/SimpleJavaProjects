public class Login {
    public static void AdminLoginMenu(){
        System.out.println("Welcome to Admin menu");
        int id = Operations.getIntegerInputFromUser("Please enter your id: ");
        Admin admin = FileSystem.getValueOfAdmin(id);
        if(admin != null){
            String password = Operations.getStringInputFromUser("Please enter your password: ");
            if (password.equals(admin.getPassword()))
                Menus.adminMenu(admin);
            else
                System.out.println("Your password is not correct!");
        }else {
            System.out.println("Your id is not correct!");
        }
    }

    public static void CustomerLoginMenu(){
        System.out.println("Welcome to Customer menu");
        int id = Operations.getIntegerInputFromUser("Please enter your id: ");
        Customer customer = FileSystem.getValueOfCustomer(id);
        if(customer != null){
            String password = Operations.getStringInputFromUser("Please enter your password: ");
            if (password.equals(customer.getPassword()))
                Menus.customerMenu(customer);
            else
                System.out.println("Your password is not correct!");
        }else {
            System.out.println("Your id is not correct!");
        }
    }
}
