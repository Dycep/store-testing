package utils;

import io.restassured.RestAssured;

public class APIUtil {

    public static void setBaseUri(String uri) {
        RestAssured.baseURI = uri;
    }
}
