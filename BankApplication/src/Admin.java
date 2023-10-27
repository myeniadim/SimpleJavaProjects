import java.util.ArrayList;

public class Admin extends Person {
    private ArrayList<String> permissions;

    public Admin(String name, String surname, int accountId, String password) {
        super(name, surname, accountId, password);
        permissions = new ArrayList<>();
    }
    public void setPermissions(ArrayList<String> permission){
        this.permissions=permission;
    }
    public void addPermissions(String permission){
        this.permissions.add(permission);
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }

    public boolean hasPermission(String permission){
        return (permissions.contains(permission));
    }
}
