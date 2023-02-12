package endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EndPoints {
    CREATE_ITEM("/create"),
    GET_ITEMS("/"),
    GET_ITEM("/"),
    DELETE_ITEM("/"),
    UPDATE_ITEM("/"),
    REGISTER_USER("/registration"),
    CONFIRM_REGISTRATION("/registration/confirm");
    //TODO divide this class by 2 classes

    private final String path;
}
