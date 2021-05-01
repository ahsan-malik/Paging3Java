package com.ahsanmalik.paging3java.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;
import androidx.paging.PagingSource;
import androidx.paging.rxjava3.PagingRx;

import com.ahsanmalik.paging3java.data.ApiService;
import com.ahsanmalik.paging3java.models.Item;
import com.ahsanmalik.paging3java.repo.GuavaPaginsSource;
import com.ahsanmalik.paging3java.repo.StackPaginSource;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Flowable;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

@HiltViewModel
public class PagingViewModel extends ViewModel {

    ApiService apiService;
    //public Flowable<PagingData<Item>> pagingDataFlow;
    public LiveData<PagingData<Item>> pagingDataLiveData;

    @Inject
    public PagingViewModel(ApiService apiService) {
        this.apiService = apiService;
        init();
    }

    private void init() {
        CoroutineScope scop = ViewModelKt.getViewModelScope(this);

        Pager<Integer, Item> pager = new Pager<>(new PagingConfig(/* pageSize = */ 50), () -> new GuavaPaginsSource(apiService));

        //rxjava3

        /*pagingDataFlow = PagingRx.getFlowable(pager);
        PagingRx.cachedIn(pagingDataFlow, scop);*/

     pagingDataLiveData = PagingLiveData.cachedIn(PagingLiveData.getLiveData(pager), scop);

    }


}
