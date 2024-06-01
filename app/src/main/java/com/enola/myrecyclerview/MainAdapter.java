package com.enola.myrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter <MainAdapter.MainViewHolder>{
   private List<String> items = new ArrayList<>();
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false);

        return new MainViewHolder(view );
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        String item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setItems(List<String> items){
        this.items = items;
        notifyDataSetChanged();

    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        private TextView tvItem;

        public MainViewHolder(View view) {
            super(view);
            tvItem = view.findViewById(R.id.tv_item);
        }
        void bind(String string){
            tvItem.setText((string));
        }
    }
}
