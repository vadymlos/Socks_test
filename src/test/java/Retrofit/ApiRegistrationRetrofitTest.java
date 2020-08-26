package Retrofit;

import api.ApiClient;
import api.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.User2;
import okhttp3.OkHttpClient;
import org.testng.annotations.Test;
import retrofit2.Retrofit;
import utils.Utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiRegistrationRetrofitTest {
    private User2 user2 = new User2(Utils.randomUserName(), "Vadym", "Test", "form@com.com", "123");
    ApiClient apiClient = new ApiClient();
    Retrofit retrofit;

    @Test
    public void createUser() throws IOException {
        OkHttpClient okhttp = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:80")
                .build();
        UserService userService = retrofit.create(UserService.class);
        System.out.println(apiClient.userService.registerNewUser(user2).execute().body());
    }

}
