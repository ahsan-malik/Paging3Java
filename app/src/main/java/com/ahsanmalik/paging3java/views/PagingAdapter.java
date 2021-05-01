package com.ahsanmalik.paging3java.views;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ahsanmalik.paging3java.databinding.RecyclerviewUsersBinding;
import com.ahsanmalik.paging3java.models.Item;

import javax.inject.Inject;

public class PagingAdapter extends PagingDataAdapter<Item, PagingAdapter.ViewHolder> {

    @Inject
    public PagingAdapter() {
        super(diff);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RecyclerviewUsersBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = getItem(position);
        if (item != null)
            holder.binding.setItem(item);
    }

    static DiffUtil.ItemCallback<Item> diff = new
            DiffUtil.ItemCallback<Item>() {
                @Override
                public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
                    return oldItem.getAnswerId().equals(newItem.getAnswerId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
                    return oldItem.equals(newItem);
                }
            };

    static class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerviewUsersBinding binding;

        public ViewHolder(@NonNull RecyclerviewUsersBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
