import api.UserApiService;
import entity.ProductSocks;
import entity.User;
import entity.UserForLogin;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class ApiRegistrationAndAddToCartTest {

    private UserApiService userApiService = new UserApiService();
    private String sessionUser;

    @BeforeMethod
    public void setUp() {
        RestAssured.port = 80;
        User user4 = new User(Utils.randomUserName(), "Vadym", "Test", "form@com.com", "123");

        Response response = userApiService.registerNewUser(user4);

        assertThat(response.statusCode(), equalTo(200));
        String userId = response.body().jsonPath().get("id").toString();
        assertThat(userId, not(isEmptyOrNullString()));

        Response response2 = userApiService.loginUser(user4.getUsername(), user4.getPassword());

        assertThat(response2.statusCode(), equalTo(200));
        sessionUser = response2.getCookie("md.sid");
        System.out.println(sessionUser);
    }

    @Test(description = "Login user add product to cart")
    public void testCanAddToCartLoginUser() {
        ProductSocks productSocks = new ProductSocks("itemId", "3395a43e-2d88-40de-b95f-e00e1502085b");

        Response response = userApiService.addToCartForLoginUser(productSocks, sessionUser);

        assertThat(response.statusCode(), equalTo(201));
        String idOrder = response.body().htmlPath().get("id").toString();
        assertThat(idOrder, not(isEmptyOrNullString()));

        Response response1 = userApiService.checkCart(sessionUser);

        assertThat(response1.statusCode(), equalTo(200));
        String product = response1.body().jsonPath().get("quantity").toString();
        assertThat(product, not(isEmptyOrNullString()));
    }
}
