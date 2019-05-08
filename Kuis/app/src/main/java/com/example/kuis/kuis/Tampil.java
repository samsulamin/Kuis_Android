package com.example.kuis.kuis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Tampil extends AppCompatActivity implements ListView.OnItemClickListener{
    private ListView listView;

    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        getJSON();
    }


    private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Retrofitserver.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String kode = jo.getString(Retrofitserver.TAG_KODE);
                String nama = jo.getString(Retrofitserver.TAG_NAMA);
                String jenis = jo.getString(Retrofitserver.TAG_JENIS);
                String kategori = jo.getString(Retrofitserver.TAG_KATEGORI);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(Retrofitserver.TAG_KODE,kode);
                employees.put(Retrofitserver.TAG_NAMA,nama);
                employees.put(Retrofitserver.TAG_JENIS,jenis);
                employees.put(Retrofitserver.TAG_KATEGORI,kategori);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                Tampil.this, list, R.layout.list_item,
                new String[]{Retrofitserver.TAG_KODE,Retrofitserver.TAG_NAMA,Retrofitserver.TAG_JENIS,Retrofitserver.TAG_KATEGORI},
                new int[]{R.id.kode, R.id.nama,R.id.jenis, R.id.kategori});

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Tampil.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Retrofitserver.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long kode) {
        Intent intent = new Intent(this, Tampil.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String empId = map.get(Retrofitserver.TAG_KODE).toString();
        intent.putExtra(Retrofitserver.EMP_ID,empId);
        startActivity(intent);
    }
}
