package com.example.kuis.kuis.Api;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiKeyAdderInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        final HttpUrl url = chain.request()
                .url()
                .newBuilder()
                // .addQueryParameter("api_key", BuildConfig.THE_MOVIE_DB_API)
                .build();
        final Request request = chain.request().newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
