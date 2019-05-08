package com.example.kuis.kuis.Api;

import com.example.kuis.kuis.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiRequest {
    //Response intercept(@NonNull Interceptor.Chain chain) throws IOException;

    //save
    @POST("Insert.php")
    Call<ResponseModel> seveData (@Body ResponseModel Data);

}
