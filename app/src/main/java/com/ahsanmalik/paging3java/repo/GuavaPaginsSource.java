package com.ahsanmalik.paging3java.repo;

import androidx.annotation.NonNull;
import androidx.paging.ListenableFuturePagingSource;
import androidx.paging.PagingState;

import com.ahsanmalik.paging3java.data.ApiService;
import com.ahsanmalik.paging3java.models.Item;
import com.ahsanmalik.paging3java.models.StackApiResponse;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.HttpException;

public class GuavaPaginsSource extends ListenableFuturePagingSource<Integer, Item> {

    ApiService apiService;

    Executor mBgExecutor = Executors.newSingleThreadExecutor();

    Integer page;

    public GuavaPaginsSource(ApiService service){
        this.apiService = service;
    }

    @NotNull
    @Override
    public ListenableFuture<LoadResult<Integer, Item>> loadFuture(@NotNull LoadParams<Integer> params) {

        page = params.getKey() != null ? params.getKey() : 1;

        ListenableFuture<LoadResult<Integer, Item>> pageFuture =
                Futures.transform(apiService.getAnswersGuava(page, 50, "stackoverflow"), this::toLoadResult, mBgExecutor);

        ListenableFuture<LoadResult<Integer, Item>> partialLoadResultFuture =
                Futures.catching(pageFuture, HttpException.class, LoadResult.Error::new, mBgExecutor);

        return Futures.catching(partialLoadResultFuture,
                IOException.class, LoadResult.Error::new, mBgExecutor);
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NotNull PagingState<Integer, Item> state) {
        Integer anchorPosition = state.getAnchorPosition();
        if (anchorPosition == null) {
            return null;
        }

        LoadResult.Page<Integer, Item> anchorPage = state.closestPageToPosition(anchorPosition);
        if (anchorPage == null) {
            return null;
        }

        Integer prevKey = anchorPage.getPrevKey();
        if (prevKey != null) {
            return prevKey + 1;
        }

        Integer nextKey = anchorPage.getNextKey();
        if (nextKey != null) {
            return nextKey - 1;
        }
        return null;
    }

    private LoadResult<Integer, Item> toLoadResult(@NonNull StackApiResponse response) {

        Integer prevPage = page > 1 ? page-1 : null;
        Integer nextPage = response.getHasMore() ? page + 1 : null;

        return new LoadResult.Page<>(response.getItems(), prevPage, nextPage);
    }
}
