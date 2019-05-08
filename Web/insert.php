<?php

	/*if($_SERVER['REQUEST_METHOD']=='POST') {

		$response = array();
		//mendapatkan data
		$inputJSON = file_get_contents('php://input');
		$data = json_decode($inputJSON, TRUE);
		
		$kode = $data['kode'];
		$nama = strtoupper($data['nama']);
		$jenis = $data['jenis'];
		$kategori = $data['kategori'];

		require_once('koneksi.php');
		//Cek npm sudah terdaftar apa belum
		$sql = "SELECT * FROM tb_tumbuhan WHERE kode ='$kode'";
		$check = mysqli_fetch_array(mysqli_query($con,$sql));
		if(isset($check)){
			$response["value"] = 0;
			$response["message"] = "oops! Kode sudah terdaftar!";
			echo json_encode($response);
		} else {
			$sql = "INSERT INTO tb_tumbuhan (kode , nama, jenis, kategori ) VALUES('$kode','$nama','$jenis','$kategori')";
			if(mysqli_query($con,$sql)) {
				$response["value"] = 1;
				$response["message"] = "Sukses Tambah Data";
				echo json_encode($response);
			} else {
				$response["value"] = 0;
				$response["message"] = "oops! Coba lagi!";
				echo json_encode($response);
			}
		}
		// tutup database
		mysqli_close($con);
	} else {
		$response["value"] = 0;
		$response["message"] = "oops! Coba lagi!";
		echo json_encode($response);
	}
*/

	if($_SERVER['REQUEST_METHOD']=='POST'){

		//Mendapatkan Nilai Variable
		$kode = $_POST['kode'];
		$nama = $_POST['nama'];
		$jenis = $_POST['jenis'];
		$kategori = $_POST['kategori'];

		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_tumbuhan (kode,nama,jenis,kategori) VALUES ('$kode','$nama','$jenis','$kategori')";

		//Import File Koneksi database
		require_once('koneksi.php');

		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Data Tumbuhan';
		}else{
			echo 'Gagal Menambahkan Data Tumbuhan';
		}

		mysqli_close($con);
	}
?>