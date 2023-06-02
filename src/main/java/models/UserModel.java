package models;

import lombok.Data;

import java.util.Objects;

@Data
public class UserModel {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel)) return false;
        UserModel userModel = (UserModel) o;
        return firstName.equals(userModel.firstName) && lastName.equals(userModel.lastName) && email.equals(userModel.email) && phone.equals(userModel.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phone);
    }
}
