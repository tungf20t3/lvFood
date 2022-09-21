package com.zantung.listviewfood;

import java.io.Serializable;

public class Food implements Serializable {
    private String Ten, Mota;
    private int Hinh;
    private double gia;

    public Food(String ten, String mota, int hinh, double gia) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;
        this.gia = gia;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
