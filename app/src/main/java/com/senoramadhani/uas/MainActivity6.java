package com.senoramadhani.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity6 extends AppCompatActivity {
    Button call, doc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        doc = findViewById(R.id.btndoc);
        call = findViewById(R.id.btncall);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            //function untuk pindah ke mainactivity 7
            public void onClick(View view) {
                Intent i = new Intent(MainActivity6.this, MainActivity7.class);
                startActivity(i);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            //function untuk pergi ke aplikasi telepon dengan nomer 199
            public void onClick(View view) {
                String nomor = "119" ;
                Intent panggil = new Intent(Intent. ACTION_DIAL);
                panggil.setData(Uri.EMPTY. fromParts("tel",nomor,null));
                startActivity(panggil);
            }
        });

    }
}