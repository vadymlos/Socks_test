package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        OkHttpClient okhttp = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
        .build();
        init();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost:80")
                .client(okhttp)
                .build();
        return retrofit;
    }
    public void init(){
        UserService userService = retrofit.create(UserService.class);
    }
}
