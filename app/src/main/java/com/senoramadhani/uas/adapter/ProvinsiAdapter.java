package com.senoramadhani.uas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.senoramadhani.uas.R;
import com.senoramadhani.uas.model.ModelAttributes;
import com.senoramadhani.uas.model.ModelObject;

import java.util.List;

public class ProvinsiAdapter extends RecyclerView.Adapter<ProvinsiAdapter.ViewHolder> {
    Context context;
    List<ModelObject> objects;

    //function Konstruktor untuk mengisi Adapter dengan untaian data yang hendak ditaruh
    public ProvinsiAdapter(Context context, List<ModelObject> objects) {
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    //function yang akan ditaruh oleh LayoutManager ketika hendak membuat tampilan RecyclerView
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_provinsi,parent,false);

        return new ViewHolder(v);
    }

    @Override
    //function untuk mengisi data di RecyclerView
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelAttributes attributes = objects.get(position).getAtribut();
        holder.Country_Region.setText(attributes.getCountry_Region());
        holder.Confirmed.setText("Terkonfirmasi: "+attributes.getConfirmed());
        holder.Recovered.setText("Pasien Sembuh : "+attributes.getRecovered());
        holder.Active.setText("Kasus Positif : "+attributes.getActive());
        holder.Deaths.setText("Kasus Meninggal : "+attributes.getDeaths());
    }

    @Override
    //function untuk berapa data yang akan di ambil
    public int getItemCount() {
        return objects.size();
    }

    //Kelas publik yang akan dipakai sebagai ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Country_Region, Confirmed, Deaths, Recovered, Active;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Country_Region = itemView.findViewById(R.id.Country_Region);
            Confirmed = itemView.findViewById(R.id.Confirmed);
            Deaths = itemView.findViewById(R.id.Deaths);
            Recovered = itemView.findViewById(R.id.Recovered);
            Active = itemView.findViewById(R.id.Active);
        }
    }
}
