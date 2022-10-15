package Students;

public class User {
    private String username;
    private String password;
    private String identityNumber;
    private String phoneNumber;

    public User() {
    }

    public User(String username, String password, String identityNumber, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identity) {
        this.identityNumber = identityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
