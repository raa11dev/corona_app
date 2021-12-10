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

import com.senoramadhani.uas.adapter.BeritaAdapter;
import com.senoramadhani.uas.model.Articles;
import com.senoramadhani.uas.model.Covid;
import com.senoramadhani.uas.model.ModelDataIndonesia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    TextView selengkapnya;
    TextView tTanggal, tSembuh, tPositif, tMeninggal, tDirawat;
    int hari, tahun;
    String bulan;
    ProgressDialog dialog;
    Button prov, info;
    RecyclerView recyclerView;
    BeritaAdapter adapter;
    List<Articles> articles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        info = findViewById(R.id.btninfo);
        //funtion button untuk ke info covid di mainactivity6
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity6.class);
                startActivity(i);
            }
        });
        selengkapnya = findViewById(R.id.selengkapnya);
        //funtion button untuk ke list seluruh berita di mainactivity5
        selengkapnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(i);
            }
        });
        recyclerView =findViewById(R.id.recyclerViewberita);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        prov = findViewById(R.id.prov);
        //funtion button untuk ke list seluruh data covid per provinsi di mainactivity3
        prov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(i);
            }
        });
        Calendar calendar = Calendar.getInstance();
        hari = calendar.get(Calendar.DAY_OF_MONTH);
        bulan = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        tahun = calendar.get(Calendar.YEAR);
        String finaltanggal = hari + " " + bulan + " " +tahun;
        tTanggal = findViewById(R.id.tanggal);
        tTanggal.setText(finaltanggal);
        tSembuh = findViewById(R.id.sembuh);
        tPositif = findViewById(R.id.posotif);
        tMeninggal = findViewById(R.id.meninggal);
        tDirawat = findViewById(R.id.dirawat);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.show();
        getDataIndo();
        getBerita();
    }
    //function untuk menampilkan data berita yang keluar hanya 3
    public void getBerita(){
        Call<Covid> call = Api.service_berita().getBerita();
        call.enqueue(new Callback<Covid>() {
            @Override
            public void onResponse(Call<Covid> call, Response<Covid> response) {
                if(response.isSuccessful() && response.body().getArticles() != null){
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new BeritaAdapter(MainActivity2.this,articles);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<Covid> call, Throwable t) {
                Toast.makeText(MainActivity2.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //function untuk menampilkan data covid indonesia
    public void getDataIndo(){
        Call<List<ModelDataIndonesia>> call = Api.service().getData();
        call.enqueue(new Callback<List<ModelDataIndonesia>>() {
            @Override
            public void onResponse(Call<List<ModelDataIndonesia>> call, Response<List<ModelDataIndonesia>> response) {
                tSembuh.setText(response.body().get(0).getSembuh());
                tPositif.setText(response.body().get(0).getPositif());
                tDirawat.setText(response.body().get(0).getDirawat());
                tMeninggal.setText(response.body().get(0).getMeninggal());
                dialog.cancel();
            }
            @Override
            public void onFailure(Call<List<ModelDataIndonesia>> call, Throwable t) {
                Toast.makeText(MainActivity2.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
    }
}