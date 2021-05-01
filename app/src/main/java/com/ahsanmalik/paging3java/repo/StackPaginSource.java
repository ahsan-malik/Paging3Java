package com.ahsanmalik.paging3java.repo;

import androidx.annotation.NonNull;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;

import com.ahsanmalik.paging3java.data.ApiService;
import com.ahsanmalik.paging3java.models.Item;
import com.ahsanmalik.paging3java.models.StackApiResponse;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class StackPaginSource extends RxPagingSource<Integer, Item> {

    ApiService apiService;

    Integer page;

    public StackPaginSource(ApiService service){
        this.apiService = service;
    }

    @NotNull
    @Override
    public Single<LoadResult<Integer, Item>> loadSingle(@NotNull LoadParams<Integer> params) {

        page = params.getKey() != null ? params.getKey() : 1;

        return apiService.getAnswers(page, 50, "stackoverflow").
                subscribeOn(Schedulers.io()).map(this::toLoadResult).onErrorReturn(LoadResult.Error::new);
    }

    private LoadResult<Integer, Item> toLoadResult(@NonNull StackApiResponse response) {

        Integer prevPage = page > 1 ? page-1 : null;
        Integer nextPage = response.getHasMore() ? page + 1 : null;

        return new LoadResult.Page<>(
                response.getItems(),
                prevPage, // Only paging forward.
                nextPage,
                LoadResult.Page.COUNT_UNDEFINED,
                LoadResult.Page.COUNT_UNDEFINED);
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NotNull PagingState<Integer, Item> pagingState) {
        Integer anchorPosition = pagingState.getAnchorPosition();
        if (anchorPosition == null) {
            return null;
        }

        LoadResult.Page<Integer, Item> anchorPage = pagingState.closestPageToPosition(anchorPosition);
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
}
