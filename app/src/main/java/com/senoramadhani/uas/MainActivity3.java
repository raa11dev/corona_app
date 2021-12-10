package com.senoramadhani.uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.senoramadhani.uas.adapter.ProvinsiAdapter;
import com.senoramadhani.uas.model.ModelObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView list;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.show();
        list = findViewById(R.id.recyclerView);
        list.setLayoutManager(new LinearLayoutManager(this));
        getProvinsi();
    }
    //function untuk menampilkan data covid untuk setiap provinsi
    public void getProvinsi(){
        Call<List<ModelObject>> call = Api.service().getProvinsi();
        call.enqueue(new Callback<List<ModelObject>>() {
            @Override
            public void onResponse(Call<List<ModelObject>> call, Response<List<ModelObject>> response) {
                list.setAdapter(new ProvinsiAdapter(MainActivity3.this, response.body()));
                dialog.cancel();
            }
            @Override
            public void onFailure(Call<List<ModelObject>> call, Throwable t) {
                Toast.makeText(MainActivity3.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
    }
}