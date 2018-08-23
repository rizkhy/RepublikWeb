package com.gmail.republicweb1.republicweb;

/**
 * Created by MYWINDOWS on 1/2/2018.
 */

public class Anggota {
    private int id;
    private String username, nama, tmpt_lahir, tgl_lahir,
            jk, alamat, no_hp, email, riwayat_organisasi;

    public Anggota(int id, String username, String nama, String tmpt_lahir,
                   String tgl_lahir, String jk, String alamat,
                   String no_hp, String email, String riwayat_organisasi) {
        this.id = id;
        this.username = username;
        this.nama = nama;
        this.tmpt_lahir = tmpt_lahir;
        this.tgl_lahir = tgl_lahir;
        this.jk = jk;
        this.alamat = alamat;
        this.no_hp = no_hp;
        this.email = email;
        this.riwayat_organisasi = riwayat_organisasi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTmpt_lahir() {
        return tmpt_lahir;
    }

    public void setTmpt_lahir(String tmpt_lahir) {
        this.tmpt_lahir = tmpt_lahir;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRiwayat_organisasi() {
        return riwayat_organisasi;
    }

    public void setRiwayat_organisasi(String riwayat_organisasi) { this.riwayat_organisasi = riwayat_organisasi; }
}
