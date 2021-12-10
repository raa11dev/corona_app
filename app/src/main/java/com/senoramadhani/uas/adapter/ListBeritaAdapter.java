package com.senoramadhani.uas.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.senoramadhani.uas.MainActivity4;
import com.senoramadhani.uas.R;
import com.senoramadhani.uas.model.Articles;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListBeritaAdapter extends RecyclerView.Adapter<ListBeritaAdapter.ViewHolder> {
    Context context;
    List<Articles> articles;

    //function Konstruktor untuk mengisi Adapter dengan untaian data yang hendak ditaruh.
    public ListBeritaAdapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    //function yang akan ditaruh oleh LayoutManager ketika hendak membuat tampilan RecyclerView
    public ListBeritaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.berita,parent,false);
        return new ViewHolder(view);
    }

    @Override
    //function untuk mengisi data di RecyclerView
    public void onBindViewHolder(@NonNull ListBeritaAdapter.ViewHolder holder, int position) {
        Articles a = articles.get(position);
        holder.tTittle.setText(a.getTitle());
        holder.tSource.setText(a.getSource().getName());
        holder.tDate.setText(a.getPublishedAt());

        String imgurl = a.getUrlToImage();
        Picasso.with(context).load(imgurl).into(holder.tImage);
    }

    @Override
    //function untuk berapa data yang akan di ambil
    public int getItemCount() {
        return articles.size();
    }

    //Kelas publik yang akan dipakai sebagai ViewHolder dan agar bisa di klik RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tTittle, tSource, tDate;
        ImageView tImage;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tTittle = itemView.findViewById(R.id.judul);
            tSource = itemView.findViewById(R.id.sumber);
            tDate = itemView.findViewById(R.id.tanggalberita);
            tImage = itemView.findViewById(R.id.gambarberita);
            cardView = itemView.findViewById(R.id.cardView);
            itemView.setOnClickListener(this);
        }

        @Override
        //function agar RecyclerView bisa di klik
        public void onClick(View view) {
            Intent intent = new Intent(context, MainActivity4.class);
            intent.putExtra("URL_NAME", articles.get(getAdapterPosition()).getUrl());
            context.startActivity(intent);
        }
    }
}
