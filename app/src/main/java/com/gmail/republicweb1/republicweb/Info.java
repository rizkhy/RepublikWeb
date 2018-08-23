package com.gmail.republicweb1.republicweb;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Info extends AppCompatActivity {

    private List<Anggota> anggotas;
    RecyclerView recyclerView;
    private GridLayoutManager gridLayout;
    private InfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        recyclerView = findViewById(R.id.recyclerview);
        anggotas = new ArrayList<>();
        ambilDataDariDB(0);

        gridLayout = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayout);

        adapter = new InfoAdapter(this, anggotas);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (gridLayout.findLastCompletelyVisibleItemPosition() == anggotas.size() - 0) {
                    ambilDataDariDB(anggotas.get(anggotas.size() - 1).getId());
                }

            }
        });
    }

    private void ambilDataDariDB(int id) {

        AsyncTask<Integer, Void, Void> asyncTask = new AsyncTask<Integer, Void, Void>() {
            ProgressDialog pdLoading = new ProgressDialog(Info.this);
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //this method will be running on UI thread
                pdLoading.setMessage("\tLoading...");
                pdLoading.setCancelable(false);
                pdLoading.show();
            }
            @Override
            protected Void doInBackground(Integer... id) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://hmjsimobile.000webhostapp.com/tampil_data.php?id=" + id[0])
                        .build();
                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);
                        Anggota anggota = new Anggota(object.getInt("id"), object.getString("username"), object.getString("nama"),
                                object.getString("tmpt_lahir"), object.getString("tgl_lahir"),  object.getString("jk"),
                                object.getString("alamat"),  object.getString("no_hp"),  object.getString("email"),
                                object.getString("riwayat_organisasi"));
                        Info.this.anggotas.add(anggota);
                    }

                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
                pdLoading.dismiss();
            }
        };
        asyncTask.execute(id);
    }
}