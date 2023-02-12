package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtil {

    public static void setBaseUri(String uri) {
        RestAssured.baseURI = uri;
    }

    public static <T> T getModel(Response response, Class<T> tClass) {
        return response.as(tClass);
    }
}
