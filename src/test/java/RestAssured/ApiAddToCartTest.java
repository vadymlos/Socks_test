package RestAssured;

import api.UserApiService;
import entity.ProductSocks;
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



public class ApiAddToCartTest {
    private UserApiService userApiService = new UserApiService();

    @BeforeMethod
    static void setUp() {
        RestAssured.port = 80;
    }



    @Test(description = "Not login user add product to cart")
    public void testCanAddToCartNotLoginUser() {
        ProductSocks productSocks = new ProductSocks("itemId", "3395a43e-2d88-40de-b95f-e00e1502085b");
        Response response = userApiService.addToCart(productSocks);

        assertThat(response.statusCode(), equalTo(201));
        String idOrder = response.body().htmlPath().get("id").toString();
        String cookieValue = response.getCookie("md.sid");
        assertThat(idOrder, not(isEmptyOrNullString()));

        Response response1 = userApiService.checkCart(cookieValue);

        assertThat(response1.statusCode(), equalTo(200));
        String product = response1.body().jsonPath().get("quantity").toString();
        assertThat(product, not(isEmptyOrNullString()));
    }
}
