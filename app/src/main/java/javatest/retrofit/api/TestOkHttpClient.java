package javatest.iristai.com.javatest.retrofit.api;

import android.os.Build;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javatest.iristai.com.javatest.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class TestOkHttpClient {

    private static int TIMEOUT_SECONDS = 5;

    public static OkHttpClient setPushHttpLog() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder = request.newBuilder();

                        builder.header("device", "Android")
                                .header("sdk", Integer.toString(Build.VERSION.SDK_INT))
                                .build();
                        return chain.proceed(request);
                    }
                });

        return builder.build();
    }
}

