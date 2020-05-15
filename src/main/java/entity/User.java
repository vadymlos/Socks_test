package entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private String firstName;
    private String pwd;
    private String email;
}
