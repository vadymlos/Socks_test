package Retrofit;

import api.MyCookieJar;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import org.testng.annotations.BeforeMethod;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import steps.retrofit.ApiStep2Retro;

public class BaseTestForRetrofit {

    Retrofit retrofit;
    ApiStep2Retro apiStep2Retro;

    @BeforeMethod
    public void BeforeMethod(){
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new MyCookieJar())
                .build();
        retrofit = new Retrofit.Builder().client(client)
                .baseUrl("http://localhost/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
        apiStep2Retro = new ApiStep2Retro(retrofit);
//        System.out.println(retrofit.create(UserServiceVersionTwo.class).registerNewUser(user2).execute());
    }
}
