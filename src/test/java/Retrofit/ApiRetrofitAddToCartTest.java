package Retrofit;

import entity.Item;
import entity.ProductSocks;
import okhttp3.ResponseBody;
import org.testng.annotations.Test;
import retrofit2.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.List;

public class ApiRetrofitAddToCartTest extends BaseTestForRetrofit {

    @Test(description = "Not login user add product to cart")
    public void shouldCanAddProductToCart() throws IOException {
        ProductSocks productSocks = new ProductSocks("itemId", "3395a43e-2d88-40de-b95f-e00e1502085b");

        Response<ResponseBody> response = apiStep2Retro.canAddProductToCart(productSocks);
        assertThat(response.code(), is(201));
        String cookieProduct = response.headers().get("Set-Cookie");
        String valueCookieProduct = cookieProduct.substring(cookieProduct.indexOf("=")+1, cookieProduct.indexOf(";"));
        assertThat(cookieProduct, notNullValue());
//        System.out.println(valueCookieProduct);

        Response<List<Item>> response2 = apiStep2Retro.checkCartWithProduct();
        assertThat(response2.code(), is(200));
//        Item productAvailable = response2.body().get();
//        assertThat(productAvailable, notNullValue());

//        String quantity = productAvailable.

//        System.out.println(productAvailable.getQuantity());
    }
}
