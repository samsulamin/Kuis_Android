-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2019 at 07:19 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tumbuhan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_tumbuhan`
--

CREATE TABLE `tb_tumbuhan` (
  `kode` int(4) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jenis` varchar(25) NOT NULL,
  `kategori` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_tumbuhan`
--

INSERT INTO `tb_tumbuhan` (`kode`, `nama`, `jenis`, `kategori`) VALUES
(2111, 'Kangkung', 'Sayuran', 'AS'),
(4332, 'Bambu Runcing', 'Rumput', 'As');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_tumbuhan`
--
ALTER TABLE `tb_tumbuhan`
  ADD PRIMARY KEY (`kode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
