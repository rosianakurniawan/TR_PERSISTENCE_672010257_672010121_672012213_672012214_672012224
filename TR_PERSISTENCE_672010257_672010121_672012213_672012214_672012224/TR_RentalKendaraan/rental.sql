-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 07, 2015 at 10:59 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rental`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_booking`
--

CREATE TABLE IF NOT EXISTS `tbl_booking` (
  `id_booking` bigint(20) NOT NULL AUTO_INCREMENT,
  `nama_sewa` varchar(30) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `lama_sewa` int(3) NOT NULL,
  `tgl_booking` varchar(30) NOT NULL DEFAULT '00/00/0000 00:00:00',
  `tgl_ambil` varchar(30) NOT NULL DEFAULT '00/00/0000 00:00:00',
  `plat_no` varchar(10) NOT NULL,
  `id_rental` varchar(10) NOT NULL,
  `jenis_kendaraan` varchar(10) NOT NULL,
  PRIMARY KEY (`id_booking`),
  KEY `plat_no` (`plat_no`,`id_rental`),
  KEY `id_rental` (`id_rental`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `tbl_booking`
--

INSERT INTO `tbl_booking` (`id_booking`, `nama_sewa`, `no_hp`, `alamat`, `lama_sewa`, `tgl_booking`, `tgl_ambil`, `plat_no`, `id_rental`, `jenis_kendaraan`) VALUES
(2, 'Rendy', '789456123321', 'Kemiri 2', 6, '08/05/2015 09:30:00', '08/06/2015 09:30:00', 'H 1111 DK', 'rnt001sl', 'Motor'),
(5, 'Siti', '97987987987987', 'Kemiri Raya', 12, '08/06/2015 09:30:00', '08/07/2015 02:38:58', 'H 8787 BB', 'rnt001sl', 'Mobil');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kendaraan`
--

CREATE TABLE IF NOT EXISTS `tbl_kendaraan` (
  `plat_no` varchar(10) NOT NULL,
  `jenis_kendaraan` varchar(20) NOT NULL,
  `gambar` varchar(250) NOT NULL,
  `status` varchar(10) NOT NULL,
  `id_rental` varchar(10) NOT NULL,
  `id_user` varchar(10) NOT NULL,
  PRIMARY KEY (`plat_no`),
  KEY `id_rental` (`id_rental`,`id_user`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_kendaraan`
--

INSERT INTO `tbl_kendaraan` (`plat_no`, `jenis_kendaraan`, `gambar`, `status`, `id_rental`, `id_user`) VALUES
('AD 9090 DA', 'Mobil', 'belum', 'Ada', 'rnt001sl', 'ur001'),
('B 45 DKI', 'Mobil', 'belum', 'Ada', 'rnt002sl', 'ur002'),
('B 881 UYE', 'Motor', 'belum', 'Ada', 'rnt002sl', 'ur002'),
('H 111 HH', 'Mobil', 'belum', 'Ada', 'rnt001sl', 'ur001'),
('H 1111 DK', 'Motor', 'belum', 'Booking', 'rnt001sl', 'ur001'),
('H 7676 B', 'Mobil', 'belum', 'Dipakai', 'rnt001sl', 'ur001'),
('H 8787 BB', 'Mobil', 'belum', 'Booking', 'rnt001sl', 'ur001'),
('H 9000 WB', 'Motor', 'belum', 'Dipakai', 'rnt001sl', 'ur001'),
('K 2345 MB', 'Mobil', 'belum', 'Dipakai', 'rnt001sl', 'ur001'),
('R 212 KK', 'Motor', 'belum', 'Dipakai', 'rnt001sl', 'ur001');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE IF NOT EXISTS `tbl_login` (
  `id_user` varchar(10) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` varchar(5) NOT NULL,
  `id_rental` varchar(10) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `user_name` (`user_name`),
  KEY `id_rental` (`id_rental`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`id_user`, `user_name`, `password`, `status`, `id_rental`) VALUES
('ur001', 'admin', 'admin', 'off', 'rnt001sl'),
('ur002', 'root', 'root', 'off', 'rnt002sl');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_rental`
--

CREATE TABLE IF NOT EXISTS `tbl_rental` (
  `id_rental` varchar(10) NOT NULL,
  `nama_rental` varchar(50) NOT NULL,
  `pemilik_rental` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_telp` varchar(12) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id_rental`),
  UNIQUE KEY `nama_rental` (`nama_rental`),
  UNIQUE KEY `id_rental` (`id_rental`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_rental`
--

INSERT INTO `tbl_rental` (`id_rental`, `nama_rental`, `pemilik_rental`, `alamat`, `no_telp`, `status`) VALUES
('rnt001sl', 'Kemiri Rent', 'Pak Bambang', 'Jl. Kemiri II', '085689562325', 'Ada'),
('rnt002sl', 'Two Rent', 'Bp. Joko', 'Jl. Turent', '0123456789', 'Ada'),
('rnt003sl', 'Ardy Rent', 'Bp. Ardy', 'Jl.Kemiri 1', '0213546879', 'Ada');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaksi`
--

CREATE TABLE IF NOT EXISTS `tbl_transaksi` (
  `id_trans` bigint(20) NOT NULL AUTO_INCREMENT,
  `nama_sewa` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_telp` varchar(12) NOT NULL,
  `lama_sewa` int(3) NOT NULL,
  `tarif` varchar(50) NOT NULL,
  `ambil` varchar(20) NOT NULL DEFAULT '00/00/0000 00:00:00',
  `kembali` varchar(20) DEFAULT '00/00/0000 00:00:00',
  `over_time` double DEFAULT NULL,
  `biaya_over` varchar(50) DEFAULT NULL,
  `bayar` varchar(50) DEFAULT NULL,
  `status_transaksi` varchar(20) DEFAULT NULL,
  `id_rental` varchar(10) NOT NULL,
  `plat_no` varchar(10) NOT NULL,
  PRIMARY KEY (`id_trans`),
  KEY `id_rental` (`id_rental`,`plat_no`),
  KEY `plat_no` (`plat_no`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=580 ;

--
-- Dumping data for table `tbl_transaksi`
--

INSERT INTO `tbl_transaksi` (`id_trans`, `nama_sewa`, `alamat`, `no_telp`, `lama_sewa`, `tarif`, `ambil`, `kembali`, `over_time`, `biaya_over`, `bayar`, `status_transaksi`, `id_rental`, `plat_no`) VALUES
(567, 'Joko', 'Kauman', '08564545465', 12, 'Rp 175.000,00', '08/04/2015 02:38:58', '08/05/2015 03:24:19', 13, 'Rp 153.120,00', 'Rp 328.120,00', 'Lunas', 'rnt001sl', 'H 7676 B'),
(568, 'Nana', 'Cemara', '123456789456', 12, '175.000', '08/04/2015 04:26:56', '08/05/2015 04:34:03', 12.12, 'Rp 145.440,00', 'Rp 320.440,00', 'Lunas', 'rnt001sl', 'H 111 HH'),
(572, 'Arif', 'Kemiri Candi', '789456123456', 12, 'Rp 175.000,00', '08/04/2015 04:00:29', '08/05/2015 04:11:04', 12, 'Rp 146.160,00', 'Rp 321.160,00', 'Lunas', 'rnt001sl', 'H 9000 WB'),
(573, 'Jeni', 'Salatiga', '789456123456', 12, 'Rp 175.000,00', '08/05/2015 04:35:31', '08/06/2015 05:45:09', 13.16, 'Rp 157.920,00', 'Rp 332.920,00', 'Lunas', 'rnt001sl', 'AD 9090 DA'),
(574, 'Alvin', 'Kemiri Candi', '456789123', 6, 'Rp 125.000,00', '08/05/2015 04:36:45', '00/00/0000 00:00:00', 0, '0', '0', 'Belum Dibayar', 'rnt001sl', 'H 7676 B'),
(575, 'Ridwan', 'Kemiri Raya', '08885245698', 24, 'Rp 275.000,00', '08/05/2015 04:37:11', '00/00/0000 00:00:00', 0, '0', '0', 'Belum Dibayar', 'rnt001sl', 'H 9000 WB'),
(576, 'Nana', 'Kauman', '998908', 12, 'Rp 175.000,00', '08/05/2015 04:37:32', '00/00/0000 00:00:00', 0, '0', '0', 'Belum Dibayar', 'rnt001sl', 'R 212 KK'),
(577, 'Reinhart', 'Sumopuro', '123456789', 12, 'Rp 175.000,00', '08/05/2015 09:30:00', '08/06/2015 08:24:47', 10.91, 'Rp 130.920,00', 'Rp 305.920,00', 'Lunas', 'rnt001sl', 'H 111 HH'),
(578, 'Albert', 'Cemara', '08564545465', 12, 'Rp 175.000,00', '08/05/2015 09:30:00', '00/00/0000 00:00:00', 0, '0', '0', 'Belum Dibayar', 'rnt001sl', 'K 2345 MB'),
(579, 'JUJU', 'Kauman', '6767', 6, 'Rp 125.000,00', '08/06/2015 01:27:02', '08/06/2015 08:27:45', 1.01, 'Rp 12.120,00', 'Rp 137.120,00', 'Lunas', 'rnt001sl', 'H 111 HH');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_booking`
--
ALTER TABLE `tbl_booking`
  ADD CONSTRAINT `tbl_booking_ibfk_1` FOREIGN KEY (`id_rental`) REFERENCES `tbl_rental` (`id_rental`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_booking_ibfk_2` FOREIGN KEY (`plat_no`) REFERENCES `tbl_kendaraan` (`plat_no`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_kendaraan`
--
ALTER TABLE `tbl_kendaraan`
  ADD CONSTRAINT `tbl_kendaraan_ibfk_1` FOREIGN KEY (`id_rental`) REFERENCES `tbl_rental` (`id_rental`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_kendaraan_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `tbl_login` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD CONSTRAINT `tbl_login_ibfk_1` FOREIGN KEY (`id_rental`) REFERENCES `tbl_rental` (`id_rental`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD CONSTRAINT `tbl_transaksi_ibfk_1` FOREIGN KEY (`id_rental`) REFERENCES `tbl_rental` (`id_rental`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_transaksi_ibfk_2` FOREIGN KEY (`plat_no`) REFERENCES `tbl_kendaraan` (`plat_no`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
