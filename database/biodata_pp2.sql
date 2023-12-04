-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 04, 2023 at 02:39 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biodata_pp2`
--

-- --------------------------------------------------------

--
-- Table structure for table `biodata`
--

CREATE TABLE `biodata` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT '',
  `jenis_kelamin_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `nomor_hp` varchar(255) DEFAULT '',
  `alamat` varchar(255) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `biodata`
--

INSERT INTO `biodata` (`id`, `nama`, `jenis_kelamin_id`, `nomor_hp`, `alamat`) VALUES
('7f021fc7-1314-4eaa-9f5a-a5445509adbd', 'Martuna', 'a4a9e19a-3ab9-4e14-8efa-37a65b7bab3b', '1515135', 'trdsgf'),
('8f39a6c7-0614-4c23-836a-87c3fa166ae6', 'fdas', 'a4a9e19a-3ab9-4e14-8efa-37a65b7bab3b', '432521', 'rqwwre'),
('c2aa25f1-01c3-4091-b7f5-183a0fa982bc', 'dsa', '7818b781-fc3e-4c02-982b-768f057549b3', '321321', 'rwqrqw'),
('ca0eeedc-4a2e-4210-b599-e593503298b2', 'Martini', '7818b781-fc3e-4c02-982b-768f057549b3', '123123', 'Maritini keren'),
('fc0ce6dc-1b75-46c4-aeef-468c7f384b97', 'weqewq', '7818b781-fc3e-4c02-982b-768f057549b3', '32131', 'rweq');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_kelamin`
--

CREATE TABLE `jenis_kelamin` (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `jenis_kelamin`
--

INSERT INTO `jenis_kelamin` (`id`, `nama`) VALUES
('7818b781-fc3e-4c02-982b-768f057549b3', 'Perempuan'),
('a4a9e19a-3ab9-4e14-8efa-37a65b7bab3b', 'Laki-laki');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jenis_kelamin`
--
ALTER TABLE `jenis_kelamin`
  ADD PRIMARY KEY (`id`) USING BTREE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
