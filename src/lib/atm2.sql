-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2018 at 12:34 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm2`
--

-- --------------------------------------------------------

--
-- Table structure for table `carduri`
--

CREATE TABLE `carduri` (
  `id` int(4) NOT NULL,
  `nume` varchar(64) COLLATE utf8_romanian_ci NOT NULL,
  `pin` int(4) NOT NULL,
  `status` int(1) NOT NULL,
  `sold` double(7,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

--
-- Dumping data for table `carduri`
--

INSERT INTO `carduri` (`id`, `nume`, `pin`, `status`, `sold`) VALUES
(1, 'Ștefan Halus', 2121, 1, 2906.75),
(2, 'Mihai Damian', 1554, 1, 9170.00),
(3, 'Ion', 5432, 1, 2505.67),
(4, 'IONEescu', 5421, 1, 4700.00);

-- --------------------------------------------------------

--
-- Table structure for table `jurnalretrageri`
--

CREATE TABLE `jurnalretrageri` (
  `id` int(9) NOT NULL,
  `pin` int(4) NOT NULL,
  `sumaRetrasa` double(7,2) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

--
-- Dumping data for table `jurnalretrageri`
--

INSERT INTO `jurnalretrageri` (`id`, `pin`, `sumaRetrasa`, `data`) VALUES
(2, 2121, 50.00, '2018-02-17 15:21:43'),
(3, 1554, 50.00, '2018-02-17 21:48:13'),
(4, 1554, 20.00, '2018-02-17 21:49:01'),
(5, 1554, 200.00, '2018-02-17 21:50:00'),
(6, 1554, 10.00, '2018-02-17 22:28:46'),
(7, 2121, 100.00, '2018-02-18 10:36:40');

-- --------------------------------------------------------

--
-- Table structure for table `jurnalvalidarepin`
--

CREATE TABLE `jurnalvalidarepin` (
  `id` int(9) NOT NULL,
  `pin` int(4) NOT NULL,
  `status` int(2) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

--
-- Dumping data for table `jurnalvalidarepin`
--

INSERT INTO `jurnalvalidarepin` (`id`, `pin`, `status`, `data`) VALUES
(1, 2133, 0, '2018-02-16 23:51:52'),
(2, 3456, 0, '2018-02-16 23:52:02'),
(3, 2121, 1, '2018-02-16 23:52:48'),
(4, 2125, 0, '2018-02-17 00:26:23'),
(5, 2514, 0, '2018-02-17 00:26:44'),
(6, 2122, 0, '2018-02-17 00:38:18'),
(7, 1234, 0, '2018-02-17 00:40:22'),
(8, 1234, 0, '2018-02-17 00:41:18'),
(9, 2122, 0, '2018-02-17 00:47:10'),
(10, 2123, 0, '2018-02-17 00:51:17'),
(11, 2123, 0, '2018-02-17 00:51:23'),
(12, 2123, 0, '2018-02-17 00:51:23'),
(13, 2123, 0, '2018-02-17 00:51:24'),
(14, 2123, 0, '2018-02-17 00:51:24'),
(15, 2123, 0, '2018-02-17 00:51:24'),
(16, 2123, 0, '2018-02-17 00:51:24'),
(17, 2123, 0, '2018-02-17 00:51:25'),
(18, 2123, 0, '2018-02-17 00:51:25'),
(19, 2123, 0, '2018-02-17 00:51:25'),
(20, 2123, 0, '2018-02-17 00:51:26'),
(21, 2121, 1, '2018-02-17 00:51:33'),
(22, 2122, 0, '2018-02-17 00:58:02'),
(23, 2121, 1, '2018-02-17 00:58:24'),
(24, 2122, 0, '2018-02-17 00:59:18'),
(25, 1554, 1, '2018-02-17 00:59:34'),
(26, 2122, 0, '2018-02-17 01:12:21'),
(27, 2121, 1, '2018-02-17 01:12:34'),
(28, 2121, 1, '2018-02-17 01:15:08'),
(29, 2121, 1, '2018-02-17 01:16:57'),
(30, 2121, 1, '2018-02-17 01:18:05'),
(31, 2121, 1, '2018-02-17 01:18:58'),
(32, 2121, 1, '2018-02-17 01:20:37'),
(33, 1554, 1, '2018-02-17 01:22:04'),
(34, 2121, 1, '2018-02-17 01:27:20'),
(35, 2121, 1, '2018-02-17 01:28:38'),
(36, 2121, 1, '2018-02-17 01:29:53'),
(37, 2121, 1, '2018-02-17 01:53:27'),
(38, 2121, 1, '2018-02-17 01:54:31'),
(39, 2121, 1, '2018-02-17 02:10:46'),
(40, 2121, 1, '2018-02-17 02:11:37'),
(41, 2121, 1, '2018-02-17 02:12:22'),
(42, 2121, 1, '2018-02-17 02:15:54'),
(43, 2121, 1, '2018-02-17 02:16:18'),
(44, 2121, 1, '2018-02-17 02:24:53'),
(45, 2121, 1, '2018-02-17 02:48:03'),
(46, 2121, 1, '2018-02-17 02:59:00'),
(47, 2121, 1, '2018-02-17 03:03:41'),
(48, 2121, 1, '2018-02-17 03:05:26'),
(49, 2121, 1, '2018-02-17 03:07:54'),
(50, 2121, 1, '2018-02-17 03:16:36'),
(51, 2121, 1, '2018-02-17 03:18:07'),
(52, 2121, 1, '2018-02-17 03:19:59'),
(53, 2121, 1, '2018-02-17 03:32:17'),
(54, 2121, 1, '2018-02-17 11:19:11'),
(55, 2121, 1, '2018-02-17 11:24:19'),
(56, 5421, 1, '2018-02-17 11:30:32'),
(57, 5421, 1, '2018-02-17 11:35:06'),
(58, 5432, 1, '2018-02-17 11:36:36'),
(59, 5432, 1, '2018-02-17 11:37:54'),
(60, 5432, 1, '2018-02-17 11:42:06'),
(61, 2121, 1, '2018-02-17 11:43:41'),
(62, 5432, 1, '2018-02-17 11:43:59'),
(63, 5432, 1, '2018-02-17 11:48:28'),
(64, 5432, 1, '2018-02-17 11:50:50'),
(65, 5432, 1, '2018-02-17 11:54:54'),
(66, 5432, 1, '2018-02-17 14:15:17'),
(67, 5432, 1, '2018-02-17 14:17:10'),
(68, 5432, 1, '2018-02-17 14:18:53'),
(69, 2121, 1, '2018-02-17 14:20:15'),
(70, 2121, 1, '2018-02-17 14:25:31'),
(71, 2121, 1, '2018-02-17 14:42:04'),
(72, 2122, 0, '2018-02-17 14:43:04'),
(73, 2122, 0, '2018-02-17 14:43:16'),
(74, 2121, 1, '2018-02-17 15:03:28'),
(75, 2121, 1, '2018-02-17 15:21:29'),
(76, 2122, 0, '2018-02-17 15:38:25'),
(77, 2122, 0, '2018-02-17 15:38:35'),
(78, 2122, 0, '2018-02-17 15:38:41'),
(79, 2122, 0, '2018-02-17 15:39:07'),
(80, 2122, 0, '2018-02-17 15:39:13'),
(81, 2121, 1, '2018-02-17 15:39:25'),
(82, 2121, 1, '2018-02-17 16:23:43'),
(83, 2121, 1, '2018-02-17 16:27:20'),
(84, 2121, 1, '2018-02-17 16:43:26'),
(85, 2121, 1, '2018-02-17 18:52:55'),
(86, 2121, 1, '2018-02-17 18:55:48'),
(87, 2121, 1, '2018-02-17 21:08:28'),
(88, 2121, 1, '2018-02-17 21:20:52'),
(89, 1554, 1, '2018-02-17 21:48:53'),
(90, 1554, 1, '2018-02-17 21:49:40'),
(91, 1554, 1, '2018-02-17 21:51:49'),
(92, 2121, 1, '2018-02-18 10:16:09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carduri`
--
ALTER TABLE `carduri`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `pin` (`pin`),
  ADD KEY `pin_2` (`pin`);

--
-- Indexes for table `jurnalretrageri`
--
ALTER TABLE `jurnalretrageri`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jurnalretrageri_ibfk_1` (`pin`);

--
-- Indexes for table `jurnalvalidarepin`
--
ALTER TABLE `jurnalvalidarepin`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carduri`
--
ALTER TABLE `carduri`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `jurnalretrageri`
--
ALTER TABLE `jurnalretrageri`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `jurnalvalidarepin`
--
ALTER TABLE `jurnalvalidarepin`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jurnalretrageri`
--
ALTER TABLE `jurnalretrageri`
  ADD CONSTRAINT `jurnalretrageri_ibfk_1` FOREIGN KEY (`pin`) REFERENCES `carduri` (`pin`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
