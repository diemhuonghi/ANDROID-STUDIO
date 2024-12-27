package com.example.hocsqlite1;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

public class Contact {
    private int ma;
    private String ten;
    private String sodienthoai;
    public Contact(){

    }
    public Contact(int ma , String ten, String sodienthoai){
        this.ma=ma;
        this.ten=ten;
        this.sodienthoai=sodienthoai;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    @NonNull
    @Override
    public String toString() {
        return ma +" "+ten+" "+sodienthoai;
    }
}
