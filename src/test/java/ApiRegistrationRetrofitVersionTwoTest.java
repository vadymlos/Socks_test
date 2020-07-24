import api.UserServiceVersionTwo;
import entity.User2;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.Utils;

import java.io.IOException;

public class ApiRegistrationRetrofitVersionTwoTest {
    public static void main(String[] args) throws IOException {
        User2 user2 = new User2(Utils.randomUserName(), "Vadym", "Test", "form@com.com", "123");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        System.out.println(retrofit.create(UserServiceVersionTwo.class).registerNewUser(user2).execute().toString());
    }
}
