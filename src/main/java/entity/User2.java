package entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User2 {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
