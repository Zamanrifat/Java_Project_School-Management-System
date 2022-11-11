-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2019 at 06:04 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
--
-- Database: `schoolmanagement`
--
CREATE DATABASE IF NOT EXISTS `schoolmanagement` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `schoolmanagement`;

-- --------------------------------------------------------

--
-- Table structure for table `admininfo`
--

CREATE TABLE `admininfo` (
  `userName` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `position` varchar(15) NOT NULL,
  `phone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admininfo`
--

INSERT INTO `admininfo` (`userName`, `password`, `position`, `phone`) VALUES
('msr@nayeem', 'msr@nayeem', 'admin', '01770848793'),
('rifat', '1234', 'user', '01799015977');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `name` varchar(30) NOT NULL,
  `id` int(5) NOT NULL,
  `class` varchar(10) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `nationality` varchar(20) NOT NULL,
  `fother's name` varchar(30) NOT NULL,
  `fother's no` varchar(14) NOT NULL,
  `mother's name` varchar(30) NOT NULL,
  `mother's no` varchar(14) NOT NULL,
  `religion` varchar(10) NOT NULL,
  `address` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`name`, `id`, `class`, `gender`, `nationality`, `fother's name`, `fother's no`, `mother's name`, `mother's no`, `religion`, `address`) VALUES
('asd', 1, 'One', 'das', 'das', 'ad', 'asd', 'asd', 'asd', 'asd', 'asd'),
('abs', 2, 'One', 'Male', 'bd', 'na', '0177', 'ms', '0188', 'islam', 'dhakak');

-- --------------------------------------------------------

--
-- Table structure for table `teacherinfo`
--

CREATE TABLE `teacherinfo` (
  `Name` varchar(30) NOT NULL,
  `id` int(5) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `phone` varchar(14) NOT NULL,
  `address` varchar(30) NOT NULL,
  `Joining Date` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacherinfo`
--

INSERT INTO `teacherinfo` (`Name`, `id`, `mail`, `phone`, `address`, `Joining Date`) VALUES
('nayeem', 2, '@gmail.com', '0188', 'dhaka', '30-10-2012');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacherinfo`
--
ALTER TABLE `teacherinfo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `teacherinfo`
--
ALTER TABLE `teacherinfo`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
