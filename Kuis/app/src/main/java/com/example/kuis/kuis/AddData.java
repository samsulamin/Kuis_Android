package com.example.kuis.kuis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class AddData extends AppCompatActivity implements View.OnClickListener{
    //Dibawah ini merupakan perintah untuk mendefinikan View
    private EditText editTextKode;
    private EditText editTextnama;
    private EditText editTextJenis;
    private EditText editTextKategori;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        //Inisialisasi dari View
        editTextKode = (EditText) findViewById(R.id.et_kode);
        editTextnama = (EditText) findViewById(R.id.et_nama);
        editTextJenis = (EditText) findViewById(R.id.et_jenis);
        editTextKategori = (EditText) findViewById(R.id.et_kategori);

        buttonAdd = (Button) findViewById(R.id.btn_save);
        buttonView = (Button) findViewById(R.id.btn_tampil);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addEmployee(){

        final String kode = editTextKode.getText().toString().trim();
        final String nama = editTextnama.getText().toString().trim();
        final String jenis = editTextJenis.getText().toString().trim();
        final String kategori = editTextKategori.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(AddData.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(AddData.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Retrofitserver.KEY_EMP_KODE,kode);
                params.put(Retrofitserver.KEY_EMP_NAMA,nama);
                params.put(Retrofitserver.KEY_EMP_JENIS,jenis);
                params.put(Retrofitserver.KEY_EMP_KATEGORI,kategori);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Retrofitserver.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addEmployee();
        }

        if(v == buttonView){
            startActivity(new Intent(this,Tampil.class));
        }
    }
}
