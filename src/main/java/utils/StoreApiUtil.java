package utils;

import endpoints.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.UserModel;

public class StoreApiUtil {

    public static Response deleteItem(String id){
        // TODO refactor method in actual project
        return RestAssured.given().delete(EndPoints.DELETE_ITEM.getPath().concat(id));
    }

    public static String registerUser(UserModel user){
        RequestSpecification request = RestAssured.given()
                .queryParam("firstName", user.getFirstName())
                .queryParam("lastName", user.getLastName())
                .queryParam("password", user.getPassword())
                .queryParam("email", user.getEmail())
                .queryParam("phone", user.getPhone());
        Response response = request.post(EndPoints.REGISTER_USER.getPath());
        return response.asPrettyString();
    }

    public static Response confirmRegistration(String token){
        RequestSpecification request = RestAssured.given()
                .pathParam("token", token);
        return request.get(EndPoints.CONFIRM_REGISTRATION.getPath());
    }
}
