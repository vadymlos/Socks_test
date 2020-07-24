package entity;

import lombok.Builder;
import lombok.Data;

@Data

public class User2 {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User2(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}

