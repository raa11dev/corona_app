package com.senoramadhani.uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.senoramadhani.uas.adapter.ListBeritaAdapter;
import com.senoramadhani.uas.model.Articles;
import com.senoramadhani.uas.model.Covid;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity5 extends AppCompatActivity {
    RecyclerView recyclerView;
    ListBeritaAdapter adapter;
    List<Articles> articles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        recyclerView = findViewById(R.id.recyclerBerita);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getBerita();
    }
    //function untuk menampilkan seluruh data berita
    public void getBerita(){
        Call<Covid> call = Api.service_berita().getBerita();
        call.enqueue(new Callback<Covid>() {
            @Override
            public void onResponse(Call<Covid> call, Response<Covid> response) {
                if(response.isSuccessful() && response.body().getArticles() != null){
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new ListBeritaAdapter(MainActivity5.this,articles);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<Covid> call, Throwable t) {
                Toast.makeText(MainActivity5.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}