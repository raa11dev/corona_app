package com.senoramadhani.uas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//untuk ambil data news indonesia api di dalam array source
public class Source {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
