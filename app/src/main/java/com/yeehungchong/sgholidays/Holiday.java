package com.yeehungchong.sgholidays;

import java.util.Date;

public class Holiday {
    private String nama;
    private String date;
    private String iconCode;

    public Holiday(String nama, String date, String iconCode) {
        this.nama = nama;
        this.date = date;
        this.iconCode = iconCode;
    }

    public String getNama() {
        return nama;
    }

    public String getDate() {
        return date;
    }

    public String getIconCode() {
        return iconCode;
    }
}
