package entity;

import lombok.Data;

@Data
public class UserForLogin {
    private String username;
    private String password;

    public UserForLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

