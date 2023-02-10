package endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EndPoints {
    CREATE_ITEM("/create"),
    GET_ITEM("/"),
    DELETE_ITEM("/"),
    REGISTER_USER("/register"),
    CONFIRM_REGISTRATION("/register/confirm");
    //TODO divide this class by 2 classes

    private final String path;
}
