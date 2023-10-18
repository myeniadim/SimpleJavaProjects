import java.util.Scanner;
import java.security.SecureRandom;
//add encrpyt password
public class Operations {
    public static int getIntegerInputFromUser(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextInt();
    }
    public static String getStringInputFromUser(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
    public static int GenerateId(String type){
        String filePath = "Customers\\"; //100000
        if (type.equals("Admin"))
            filePath = "Admins\\";
        int lastId = FileSystem.getLastID(filePath);
        return lastId+1;
    }
    public static String GeneratePassword(){
        int length = 12;
        String characters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuopasdfghjklizxcvbnm!@#$%^&*()-_=+";
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length;i++){
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }
}
