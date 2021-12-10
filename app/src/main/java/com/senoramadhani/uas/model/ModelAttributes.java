package com.senoramadhani.uas.model;

//untuk ambil data kawalcorona provinsi api di dalam array attributes
public class ModelAttributes {
    private String Country_Region;
    private String Confirmed;
    private String Deaths;
    private String Recovered;
    private String Active;

    public String getCountry_Region() {
        return Country_Region;
    }

    public String getConfirmed() {
        return Confirmed;
    }

    public String getDeaths() {
        return Deaths;
    }

    public String getRecovered() {
        return Recovered;
    }

    public String getActive() {
        return Active;
    }
}
