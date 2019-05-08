<?php
	require_once('koneksi.php');
	if($_SERVER['REQUEST_METHOD']=='GET') {

		$sql = "SELECT * FROM tb_tumbuhan ORDER BY kode ASC";

		/*if(!empty($_GET['search'])){
			$search = strtoupper($_GET['search']);
			$sql = "SELECT * FROM realcount WHERE provinsi LIKE '%$search%' ORDER BY provinsi ASC";
		}*/

	$res = mysqli_query($con,$sql);
	$result = array();
	while($row = mysqli_fetch_array($res)){
		array_push($result, array('kode'=>$row[0], 'nama'=>$row[1], 'jenis'=>$row[2], 'kategori'=>$row[3]));
	}
	if(sizeof($result) < 1){
		$result = null;
	}
	echo json_encode($result);
	mysqli_close($con);
}
