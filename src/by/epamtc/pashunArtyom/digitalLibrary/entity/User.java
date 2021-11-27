package by.epamtc.pashunArtyom.digitalLibrary.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1146217472146721476L;
    private static User guestInstance;
    private String userLogin;
    private String userPassword;
    private UserRole userRole;

    public User() {
        this.userRole = UserRole.GUEST;
    }

    public User(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userRole = UserRole.USER;
    }

    public static User getGuestInstance() {
        if (guestInstance == null)
            guestInstance = new User();
        return guestInstance;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public int hashCode() {
        return 2 + 31 * ((userLogin == null) ? 0 : userLogin.hashCode()) + ((userPassword == null) ? 0 : userPassword.hashCode())
                + ((userRole == null) ? 0 : userRole.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User user = (User) obj;
        return ((userLogin == user.userLogin) || (userLogin != null && userLogin.equals(user.getUserLogin())))
                && ((userPassword == user.userPassword) || (userPassword != null && userPassword.equals(user.getUserPassword())))
                && ((userRole == user.userRole) || (userRole != null && userRole.equals(user.getUserRole())));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@"
                + "userLogin: " + userLogin
                + "userPassword: " + userPassword
                + "userRole: " + userRole;
    }
}
