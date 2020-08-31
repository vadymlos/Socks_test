package Retrofit;

import api.MyCookieJar;
import com.codeborne.selenide.Configuration;
import com.google.gson.GsonBuilder;
import driver.SelenoidDriverProvider;
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
        Configuration.baseUrl = "http://172.32.128.10";
        Configuration.holdBrowserOpen = true;
//        Configuration.browser = "chrome";  //    SelenoidDriverProvider.class.getName();
        Configuration.fastSetValue = true;
        Configuration.driverManagerEnabled = true;

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new MyCookieJar())
                .build();
        retrofit = new Retrofit.Builder().client(client)
                .baseUrl("http://localhost/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
        apiStep2Retro = new ApiStep2Retro(retrofit);
    }
}
