package Retrofit;

import entity.ResponseBodyUser;
import entity.User2;
import org.testng.annotations.Test;
import retrofit2.Response;
import utils.Utils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

public class ApiRegistrationRetrofitVersionTwoTest extends BaseTestForRetrofit {


    @Test(description = "Register new user")
    public void shouldCanRegisterNewUser() throws IOException{

        Response<ResponseBodyUser> response = apiStep2Retro.registerNewUser(new User2(Utils.randomUserName(), "Vadym", "Test", "form@com.com", "123"));
        assertThat(response.code(), is(200));
        String userId = response.body().getId();
        assertThat(userId, notNullValue());
        System.out.println(userId);

    }
}
