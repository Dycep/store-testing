package models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"password"})
public class UserModel {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
}
