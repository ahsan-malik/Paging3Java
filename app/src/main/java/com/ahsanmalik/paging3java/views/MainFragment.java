package com.ahsanmalik.paging3java.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahsanmalik.paging3java.databinding.FragmentMainBinding;
import com.ahsanmalik.paging3java.viewModel.PagingViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    PagingViewModel viewModel;
    @Inject PagingAdapter pagingAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);

        initRecyclerView(binding.recyclerView);
        initViewModel();

        return binding.getRoot();
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(requireActivity()).get(PagingViewModel.class);
        /*viewModel.pagingDataFlow.subscribe(itemPagingData ->
                pagingAdapter.submitData(getViewLifecycleOwner().getLifecycle(), itemPagingData));*/
        viewModel.pagingDataLiveData.observe(getViewLifecycleOwner(), itemPagingData ->
                pagingAdapter.submitData(getViewLifecycleOwner().getLifecycle(), itemPagingData));
    }

    private void initRecyclerView(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() == null)
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        if (recyclerView.getAdapter() == null)
            recyclerView.setAdapter(pagingAdapter.withLoadStateFooter(new PagingLoadStateAdapter(view -> pagingAdapter.retry())));
    }
}
