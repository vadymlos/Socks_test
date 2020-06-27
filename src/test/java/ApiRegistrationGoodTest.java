import api.UserApiService;
import entity.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class ApiRegistrationGoodTest {

    private UserApiService userApiService = new UserApiService();

    @BeforeMethod
    static void setUp() {
        RestAssured.port = 80;
    }



    @Test(description = "Registration new user")
    public void testCanRegisterNewUser() {
        User user3 = new User(Utils.randomUserName(), "Vadym", "Test", "form@com.com", "123");

        Response response = userApiService.registerNewUser(user3);
        assertThat(response.statusCode(), equalTo(200));
        String s = response.body().jsonPath().get("id").toString();
        assertThat(s, not(isEmptyOrNullString()));
    }
}
