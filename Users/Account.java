package Users;

import Enums.AccountStatus;

public class Account {
    private String id;
    private String password;
    private AccountStatus status;

    public boolean resetPassword() {
        if (password == null || password.isEmpty()) {
            return false;
        }
        password = "defaultPassword";
        return true;
    }

    public Account(String id, String password, AccountStatus status) {
        this.id = id;
        this.password = password;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
    public boolean resetPassword(String newPassword) {
        if (newPassword == null || newPassword.isEmpty()) {
            return false;
        }
        password = newPassword;
        return true;
    }
    public boolean login(String enteredId, String enteredPassword) {
        if (status != AccountStatus.ACTIVE) {
            return false;
        }

        return id.equals(enteredId) && password.equals(enteredPassword);
    }

    public boolean logout() {
        return true;
    }
}
