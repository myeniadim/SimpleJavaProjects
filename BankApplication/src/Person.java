public abstract class Person {
    private String name;
    private String surname;
    private int accountId;
    private String password;

    public Person(String name, String surname, int accountId, String password) {
        this.name = name;
        this.surname = surname;
        this.accountId = accountId;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
