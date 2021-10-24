package com.example.pchop;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pchop.Data.DataGames;

public class RVGamesAdapter extends RecyclerView.Adapter<RVGamesAdapter.viewHolder> {
    //  Attribute listDosen kita pada adapter
    private final DataGames[] listGames;

    // Kelas ini berguna untuk menghubungkan view view yang ada pada item di recycler view kita.
    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_namaItem;
        TextView tv_harga;
        TextView tv_desc;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_namaItem = itemView.findViewById(R.id.tv_namaItem);
            tv_harga = itemView.findViewById(R.id.tv_harga);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setMessage("Data yang dipilih adalah " + tv_namaItem.getText().toString()).setTitle("Data Dosen")
                    .setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).show();
        }
    }

    //  Constructor adapter kita
    RVGamesAdapter(DataGames[] data){
        listGames = data;
    }

    @NonNull
    @Override
    public RVGamesAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //  Disini kita menghubungkan layout item recycler view kita
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_games,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVGamesAdapter.viewHolder holder, int position) {
        //  Karena kita sudah mendefinisikan dan menghubungkan view kita,
        //  kita bisa memakai view tersebut dan Melakukan setText pada view tersebut

        holder.tv_namaItem.setText(listGames[position].getnama_item());
        holder.tv_harga.setText(String.valueOf(listGames[position].getHarga()));
        holder.tv_desc.setText(listGames[position].getDesc());
    }

    @Override
    public int getItemCount() {
        //  Disini kita memberitahu jumlah dari item pada recycler view kita.
        return listGames.length;
    }
}
