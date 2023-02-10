package models;

import lombok.Data;

@Data
public class UserModel {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
}
