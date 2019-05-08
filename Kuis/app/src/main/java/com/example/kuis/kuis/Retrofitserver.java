package com.example.kuis.kuis;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitserver {
    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.42.93/Android_kuis/insert.php";
    //public static final String URL_GET_ALL = "http://192.168.42.93/Android_kuis/index.php";
    public static final String URL_GET_ALL = "http://192.168.42.93/Android_kuis/index.php";

    public static final String URL_GET_EMP = "http://192.168.1.9/Android/pegawai/tampilPgw.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.1.9/Android/pegawai/updatePgw.php";
    public static final String URL_DELETE_EMP = "http://192.168.1.9/Android/pegawai/hapusPgw.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_KODE = "kode";
    public static final String KEY_EMP_NAMA = "nama";
    public static final String KEY_EMP_JENIS = "jenis"; //desg itu variabel untuk posisi
    public static final String KEY_EMP_KATEGORI = "kategori"; //salary itu variabel untuk gajih

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_KODE = "kode";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_JENIS = "jenis";
    public static final String TAG_KATEGORI = "kategori";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}
