package dataobjects;

public class User {
    private String username;
    private String password;
    private String confirmPassword;
    private String passportNumber;
    private String currentPassword;
    private String newPassword;
    private String confirmNewPassword;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String currentPassword, String newPassword, String confirmNewPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    public User(String username, String password, String confirmPassword, String passportNumber) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.passportNumber = passportNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }
}

