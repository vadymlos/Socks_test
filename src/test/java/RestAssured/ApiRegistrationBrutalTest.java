package RestAssured;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class ApiRegistrationBrutalTest {

    @Test
    public void shouldCanRegisterUserApi(){
        HashMap data = new HashMap();
        data.put("username", "testapi1");
        data.put("password", "testapi1");
        data.put("email", "testapi1");
        data.put("firstName", "testapi1");
        data.put("lastName", "testapi1");

        given()
                .contentType("application/json")
                .body(data)
        .when()
                .post("http://172.32.128.146/register")
        .then()
                .statusCode(200)
                .log().body();
    }
}
