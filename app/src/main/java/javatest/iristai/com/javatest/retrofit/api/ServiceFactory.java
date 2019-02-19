package javatest.iristai.com.javatest.retrofit.api;

import javatest.iristai.com.javatest.utils.DomainPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {
    public static DataApiService pushDomainService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DomainPool.HOST_TEST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(TestOkHttpClient.setPushHttpLog())
                .build();

        return retrofit.create(DataApiService.class);
    }
}
