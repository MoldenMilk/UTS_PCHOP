package com.example.pchop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pchop.Data.DataGames;

import java.util.List;


public class RVGamesAdapter extends RecyclerView.Adapter<RVGamesAdapter.viewHolder> {

        public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private ViewDataBinding binding;
            public viewHolder(@NonNull ViewDataBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
            @Override
            public void onClick(View view){

            }
        }

        private Context context;
        private List<DataGames> DataGames;
        ViewDataBinding binding;

        public RVGamesAdapter(Context context, List<DataGames> DataGames){
            this.context = context;
            this.DataGames = DataGames;
        }

        @NonNull
        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.rv_games, parent, false);
            return new viewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull viewHolder viewHolder, final int position){
            final DataGames gms = DataGames.get(position);
        }

    @Override
    public int getItemCount() {
        return DataGames.size();
    }
}
