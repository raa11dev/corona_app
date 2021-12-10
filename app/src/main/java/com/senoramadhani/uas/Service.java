package com.senoramadhani.uas;

import com.senoramadhani.uas.model.Covid;
import com.senoramadhani.uas.model.ModelDataIndonesia;
import com.senoramadhani.uas.model.ModelObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    //ambil data indonesia
    @GET("/indonesia/")
    Call<List<ModelDataIndonesia>>getData();

    //ambil data provinsi
    @GET("/")
    Call<List<ModelObject>> getProvinsi();

    //ambil data indonesia news api
    @GET("top-headlines?q=covid&country=id&category=health&apiKey=401ed03bc7c54ee684ff0ebae6ee5ca6")
    Call<Covid> getBerita();
}
