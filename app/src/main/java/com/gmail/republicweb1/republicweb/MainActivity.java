package com.gmail.republicweb1.republicweb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    Button btn_logout;
    TextView txt_nama, txt_username;
    String nama, username;
    SharedPreferences sharedpreferences;

    public static final String TAG_nama = "nama";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nama = (TextView) findViewById(R.id.txt_nama);
        txt_username = (TextView) findViewById(R.id.txt_username);
//        btn_logout = (Button) findViewById(R.id.btn_logout);

        sharedpreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);

        nama = getIntent().getStringExtra(TAG_nama);
        username = getIntent().getStringExtra(TAG_USERNAME);

        txt_nama.setText(": " + nama);
        txt_username.setText(": " + username);

//        btn_logout.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                // update login session ke FALSE dan mengosongkan nilai nama dan username
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                editor.putBoolean(Login.session_status, false);
//                editor.putString(TAG_nama, null);
//                editor.putString(TAG_USERNAME, null);
//                editor.commit();
//
//                Intent intent = new Intent(MainActivity.this, Login.class);
//                finish();
//                startActivity(intent);
//            }
//        });

    }

//    public void clikInfo(View view){
//        Intent intent = new Intent(MainActivity.this, Info.class);
//        startActivity(intent);
//    }
}
