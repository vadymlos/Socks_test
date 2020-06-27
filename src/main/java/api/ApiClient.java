package api;

import com.google.gson.Gson;
import entity.User2;
import okhttp3.OkHttpClient;
import retrofit.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.awt.*;
import java.net.URI;
import java.util.concurrent.TimeUnit;

public class ApiClient {
    public Retrofit retrofit;
    public UserService userService;

    public Retrofit getRetrofit() {
        OkHttpClient.Builder okhttp = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS);
        init();
        return retrofit = new Retrofit().Builder()
                .baseUrl("https://localhost:80")
                .client(okhttp)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
    public void init(){
        UserService userService = retrofit.create(UserService.class);
    }
}
