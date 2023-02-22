package utils;

import endpoints.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.ItemModel;
import models.UserModel;

public class StoreAPIUtil {

    public static Response deleteItem(String id){
        // TODO refactor method in actual project
        return RestAssured.given().delete(EndPoints.DELETE_ITEM.getPath().concat(id));//TODO return id of item
    }
//TODO consider about returning Response instead of ItemModel
    public static ItemModel[] getItems(){
        return APIUtil.getModel(RestAssured.given().get(EndPoints.GET_ITEM.getPath()), ItemModel[].class);
    }

    public static ItemModel getItem(String id){
        return APIUtil.getModel(RestAssured.given().get(EndPoints.GET_ITEM.getPath().concat(id)), ItemModel.class);
    }

    public static String createItem(ItemModel item){
        RequestSpecification request = RestAssured.given().body(item).contentType(ContentType.JSON);
        Response response = request.post(EndPoints.CREATE_ITEM.getPath());
        JsonPath jsonPath = new JsonPath(response.asString());
        return jsonPath.getString("id");
    }

    public static Response updateItem(String itemId, String name){
        RequestSpecification request = RestAssured.given()
                .queryParam("name", name);
        return request.put(EndPoints.UPDATE_ITEM.getPath().concat(itemId));//TODO return id of item
    }

    public static String registerUser(UserModel user){
        RequestSpecification request = RestAssured.given().body(user).contentType(ContentType.JSON);
        Response response = request.post(EndPoints.REGISTER_USER.getPath());
        return response.asPrettyString();
    }

//    public static Response confirmRegistration(String token){
//        RequestSpecification request = RestAssured.given()
//                .queryParam("token", token);
//        return request.get(EndPoints.CONFIRM_REGISTRATION.getPath());//TODO return message 'confirmed'
//    }
    public static String confirmRegistration(String token){
        RequestSpecification request = RestAssured.given()
                .queryParam("token", token);
        return request.get(EndPoints.CONFIRM_REGISTRATION.getPath()).asPrettyString();//TODO return message 'confirmed'
    }
}
