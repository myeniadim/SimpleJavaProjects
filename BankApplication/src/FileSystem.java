import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    public static boolean checkFile(String fileName){
        File file = new File(fileName+".yml");
        return file.exists();
    }

    public static void createFile(String fileName){
        if (!checkFile(fileName)){
            try {
                File file = new File(fileName+".yml");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeAdmin(Admin admin){
        String filePath = "Admins\\" + admin.getAccountId() + ".yml";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", admin.getName());
        dataMap.put("surname", admin.getSurname());
        dataMap.put("password", admin.getPassword());
        dataMap.put("permissions", admin.getPermissions());
        try {
            DumperOptions options = new DumperOptions();
            options.setPrettyFlow(true);
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            PrintWriter writer = new PrintWriter(new File(filePath));
            Yaml yaml = new Yaml(options);
            yaml.dump(dataMap, writer);
        }catch (IOException e){
        }
    }
    public static void writeCustomer(Customer customer){
        String filePath = "Customers\\" + customer.getAccountId() + ".yml";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", customer.getName());
        dataMap.put("surname", customer.getSurname());
        dataMap.put("password", customer.getPassword());
        dataMap.put("balance", customer.getBalance());
        dataMap.put("previousTrans", customer.getPrevTrans());
        try {
            DumperOptions options = new DumperOptions();
            options.setPrettyFlow(true);
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            PrintWriter writer = new PrintWriter(new File(filePath));
            Yaml yaml = new Yaml(options);
            yaml.dump(dataMap, writer);
        }catch (IOException e){
        }
    }

    public static Admin getValueOfAdmin(int id) {
        Admin admin = null;
        String filePath = "Admins\\" + id + ".yml";
        try {
            DumperOptions options = new DumperOptions();
            options.setPrettyFlow(true);
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            InputStream inputStream = new FileInputStream(new File(filePath));
            Yaml yaml = new Yaml(options);
            Map<String, Object> dataMap = yaml.load(inputStream);
            admin = new Admin(dataMap.get("name").toString(), dataMap.get("surname").toString(), id, dataMap.get("password").toString());
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList = (ArrayList<String>) dataMap.get("permissions");
            admin.setPermissions(arrayList);
        }catch (IOException e){
        }
        return admin;
    }

    public static Customer getValueOfCustomer(int id){
        Customer customer = null;
        String filePath = "Customers\\" + id + ".yml";
        try {
            DumperOptions options = new DumperOptions();
            options.setPrettyFlow(true);
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            InputStream inputStream = new FileInputStream(new File(filePath));
            Yaml yaml = new Yaml(options);
            Map<String, Object> dataMap = yaml.load(inputStream);
            customer = new Customer(dataMap.get("name").toString(), dataMap.get("surname").toString(), id, dataMap.get("password").toString(),Double.parseDouble(dataMap.get("balance").toString()), Double.parseDouble(dataMap.get("previousTrans").toString()));
        } catch (IOException ignored) {
        }
        return customer;
    }


    public static int getLastID(String folderPath){
        int id = 100000-1;
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files!=null){
            try {
                File file = files[files.length-1];
                String fileName = file.getName().replaceAll(".yml", "");
                id = Integer.parseInt(fileName);
            }catch (ArrayIndexOutOfBoundsException e){
            }
        }
        return id;
    }
}


