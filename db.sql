-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2025 at 07:32 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hoteldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `username`, `password`, `firstName`, `lastName`) VALUES
(1, 'yan', '12345678', 'yen', 'yun');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `paymentID` int(11) NOT NULL,
  `reservationID` int(11) DEFAULT NULL,
  `paymentDate` date NOT NULL,
  `paymentMethod` varchar(20) DEFAULT NULL CHECK (`paymentMethod` in ('Cash','Card','Online')),
  `amountPaid` decimal(10,2) NOT NULL,
  `status` varchar(20) DEFAULT 'Paid'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reservationdetails`
--

CREATE TABLE `reservationdetails` (
  `detailID` int(11) NOT NULL,
  `reservationID` int(11) NOT NULL,
  `roomID` int(11) NOT NULL,
  `amount` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservationdetails`
--

INSERT INTO `reservationdetails` (`detailID`, `reservationID`, `roomID`, `amount`) VALUES
(9, 2, 5, 2.00),
(10, 3, 6, 2.00),
(11, 4, 5, 1.00),
(12, 5, 5, 1.00),
(13, 6, 5, 4.00),
(21, 14, 8, 12.00);

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE `reservations` (
  `reservationID` int(11) NOT NULL,
  `reservationNo` int(11) DEFAULT NULL,
  `userID` int(11) NOT NULL,
  `checkIn` date NOT NULL,
  `checkOut` date NOT NULL,
  `status` varchar(20) DEFAULT 'Pending',
  `roomTypeID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`reservationID`, `reservationNo`, `userID`, `checkIn`, `checkOut`, `status`, `roomTypeID`) VALUES
(2, 1, 2, '2025-04-28', '2025-04-30', 'Approved', 5),
(3, 1, 1, '2025-04-28', '2025-04-30', 'Approved', 5),
(4, 2, 2, '2025-04-20', '2025-04-21', 'Approved', 5),
(5, 2, 1, '2025-04-25', '2025-04-26', 'Approved', 5),
(6, 3, 2, '2025-04-28', '2025-05-02', 'Approved', 5),
(14, 3, 1, '2025-04-28', '2025-04-30', 'Approved', 8);

-- --------------------------------------------------------

--
-- Table structure for table `reservation_history`
--

CREATE TABLE `reservation_history` (
  `reservationID` int(11) NOT NULL,
  `reservationNo` varchar(50) DEFAULT NULL,
  `userID` varchar(50) DEFAULT NULL,
  `checkIn` date DEFAULT NULL,
  `checkOut` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `roomTypeID` varchar(50) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `roomID` int(11) NOT NULL,
  `roomNumber` varchar(10) NOT NULL,
  `roomTypeID` int(11) NOT NULL,
  `roomStatus` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`roomID`, `roomNumber`, `roomTypeID`, `roomStatus`) VALUES
(5, '1', 5, 'Occupied'),
(6, '2', 6, 'Occupied'),
(7, '3', 7, 'Occupied'),
(8, '4', 8, 'Occupied'),
(9, '5', 9, 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `roomtypes`
--

CREATE TABLE `roomtypes` (
  `roomTypeID` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `occupancy` varchar(20) NOT NULL,
  `price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roomtypes`
--

INSERT INTO `roomtypes` (`roomTypeID`, `type`, `occupancy`, `price`) VALUES
(5, 'AC', 'Single', 1.00),
(6, 'NON/AC', 'Single', 5.00),
(7, 'AC', 'Double', 4.00),
(8, 'NON/AC', 'Single', 6.00),
(9, 'AC', 'Single', 9.00);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `gender` varchar(10) DEFAULT NULL CHECK (`gender` in ('Male','Female'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `password`, `firstName`, `lastName`, `gender`) VALUES
(1, 'hayian', '12345678', 'kwen', 'ann', 'Female'),
(2, 'yen', '12345678', 'a', 'v', 'Female');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminID`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`paymentID`),
  ADD KEY `fk_reservationID_new` (`reservationID`);

--
-- Indexes for table `reservationdetails`
--
ALTER TABLE `reservationdetails`
  ADD PRIMARY KEY (`detailID`),
  ADD KEY `roomID` (`roomID`),
  ADD KEY `fk_reservationID` (`reservationID`);

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`reservationID`),
  ADD KEY `userID` (`userID`),
  ADD KEY `fk_roomTypeID` (`roomTypeID`);

--
-- Indexes for table `reservation_history`
--
ALTER TABLE `reservation_history`
  ADD PRIMARY KEY (`reservationID`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`roomID`),
  ADD UNIQUE KEY `roomNumber` (`roomNumber`),
  ADD KEY `roomTypeID` (`roomTypeID`);

--
-- Indexes for table `roomtypes`
--
ALTER TABLE `roomtypes`
  ADD PRIMARY KEY (`roomTypeID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `paymentID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservationdetails`
--
ALTER TABLE `reservationdetails`
  MODIFY `detailID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `reservationID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `roomID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `roomtypes`
--
ALTER TABLE `roomtypes`
  MODIFY `roomTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `fk_reservationID_new` FOREIGN KEY (`reservationID`) REFERENCES `reservations` (`reservationID`);

--
-- Constraints for table `reservationdetails`
--
ALTER TABLE `reservationdetails`
  ADD CONSTRAINT `fk_reservationID` FOREIGN KEY (`reservationID`) REFERENCES `reservations` (`reservationID`),
  ADD CONSTRAINT `reservationdetails_ibfk_2` FOREIGN KEY (`roomID`) REFERENCES `rooms` (`roomID`);

--
-- Constraints for table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `fk_roomType` FOREIGN KEY (`roomTypeID`) REFERENCES `roomtypes` (`roomTypeID`),
  ADD CONSTRAINT `fk_roomTypeID` FOREIGN KEY (`roomTypeID`) REFERENCES `roomtypes` (`roomTypeID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`);

--
-- Constraints for table `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `rooms_ibfk_1` FOREIGN KEY (`roomTypeID`) REFERENCES `roomtypes` (`roomTypeID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
