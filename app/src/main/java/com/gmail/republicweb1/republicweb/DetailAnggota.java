package com.gmail.republicweb1.republicweb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by MYWINDOWS on 1/4/2018.
 */

public class DetailAnggota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_anggota);

        Bundle bundle = getIntent().getExtras();
        String valueUsername = bundle.getString("username");
        String valueNama = bundle.getString("nama");
        String valueTmpt_lahir = bundle.getString("tmpt_lahir");
        String valueTgl_lahir = bundle.getString("tgl_lahir");
        String valueJk = bundle.getString("jk");
        String valueAlamat = bundle.getString("alamat");
        String valueNo_hp = bundle.getString("no_hp");
        String valueEmail = bundle.getString("email");
        String valueRiwayat_organisasi = bundle.getString("riwayat_organisasi");

        TextView username = findViewById(R.id.txt_username);
        TextView nama = findViewById(R.id.txt_nama);
        TextView tmpt_lahir = findViewById(R.id.txt_tmpt_lahir);
        TextView tgl_lahir = findViewById(R.id.txt_tgl_lahir);
        TextView jk = findViewById(R.id.txt_jk);
        TextView alamat = findViewById(R.id.txt_alamat);
        TextView no_hp = findViewById(R.id.txt_no_hp);
        TextView email = findViewById(R.id.txt_email);
        TextView riwayat_organisasi = findViewById(R.id.txt_riwayat_organisasi);

        username.setText(valueUsername);
        nama.setText(valueNama);
        tmpt_lahir.setText(valueTmpt_lahir);
        tgl_lahir.setText(valueTgl_lahir);
        jk.setText(valueJk);
        alamat.setText(valueAlamat);
        no_hp.setText(valueNo_hp);
        email.setText(valueEmail);
        riwayat_organisasi.setText(valueRiwayat_organisasi);
    }
}
