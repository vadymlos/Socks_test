package api;

import entity.ProductSocks;
import entity.User;
import entity.UserForLogin;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class UserApiService {

    private RequestSpecification given(){
        return RestAssured.given();
    }

    public Response registerNewUser(User user3) {
        return given().body(user3)
                .contentType("application/json")
                .when()
                .post("/register")
                .then().extract().response();
    }

    public Response addToCart(ProductSocks productSocks){
        return given().body(productSocks)
                .contentType("application/json")
                .when()
                .post("/cart")
                .then().extract().response();

    }
    public Response checkCart(String sessionCookie){
        return given().cookie("md.sid", sessionCookie)
                .contentType("application/json")
                .when()
                .get("/cart")
                .then().extract().response();
    }
    public Response loginUser(String username, String password){
        return given().auth().preemptive().basic(username, password)
                .contentType("application/json")
                .when()
                .get("/login")
                .then().extract().response();
    }
    public Response addToCartForLoginUser(ProductSocks productSocks, String sessionCookie){
        return given().body(productSocks).cookie("md.sid", sessionCookie)
                .contentType("application/json")
                .when()
                .post("/cart")
                .then().extract().response();

    }
}
