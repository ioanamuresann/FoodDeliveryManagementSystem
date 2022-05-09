package BusinessLogicLayer;

import java.io.Serializable;

public class Admin implements Serializable {

    private static final long serialVersionUID = -3334572924775156124l;
    //private static final long serialVersionUID = 6529685098267757690L;

    public String username;
    public String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "username= " + username + " || " +
                "password= " + password + "\n";
    }
}
