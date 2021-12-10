package com.senoramadhani.uas;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    public static String url_corona = "https://api.kawalcorona.com";
    public static  String url_berita = "https://newsapi.org/v2/";
    //function untuk konek dengan Kawalcorona API lewat retrofit 2
    public static Service service() {
        Retrofit r = new Retrofit.Builder()
                .baseUrl(url_corona)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service s;
        s = r.create(Service.class);
        return s;
    }
    //function untuk konek dengan Indonesia news API lewat retrofit 2
    public static Service service_berita() {
        Retrofit r = new Retrofit.Builder()
                .baseUrl(url_berita)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service s;
        s = r.create(Service.class);
        return s;
    }
}
