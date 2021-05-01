package com.ahsanmalik.paging3java.data;

import com.ahsanmalik.paging3java.models.StackApiResponse;
import com.google.common.util.concurrent.ListenableFuture;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("answers")
    Single<StackApiResponse> getAnswers(@Query("page") Integer page, @Query("pagesize") Integer pagesize, @Query("site") String site);

    @GET("answers")
    ListenableFuture<StackApiResponse> getAnswersGuava(@Query("page") Integer page, @Query("pagesize") Integer pagesize, @Query("site") String site);
}
