public class Main {
    public static void main(String[] args) {
        int option;
        System.out.println("----------------------------");
        System.out.println("Welcome to Bank Application");
        System.out.println("(0) - Admin Page");
        System.out.println("(1) - Customer Page");
        System.out.println("(2)- Exit");
        System.out.println("----------------------------");
        do {
            option = Operations.getIntegerInputFromUser("Please select an operation (0-2)");
            switch (option){
                case 0:
                    Login.AdminLoginMenu();
                    break;
                case 1:
                    Login.CustomerLoginMenu();
                    break;
                case 2:
                    System.out.println("***************");
                    break;
                default:
                    System.out.println("Please select a correct operation (0-2)");
                    break;
            }
        }while (option != 2);
        System.out.println("Thanks for using bank application!");
    }

}