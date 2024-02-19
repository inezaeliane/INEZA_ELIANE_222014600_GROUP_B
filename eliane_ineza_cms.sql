-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 10:13 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eliane_ineza_cms`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Fname` varchar(30) DEFAULT NULL,
  `Lname` varchar(30) DEFAULT NULL,
  `Gender` varchar(15) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Martial_status` varchar(30) DEFAULT NULL,
  `Dob` int(10) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `SetPassword` varchar(15) DEFAULT NULL,
  `ConfirmPassword` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Fname`, `Lname`, `Gender`, `Phone`, `Martial_status`, `Dob`, `Email`, `SetPassword`, `ConfirmPassword`) VALUES
('INEZA', 'Eliane', '2003', '0786230112', NULL, NULL, 'ineza@gmail.com', '1234', '1234'),
('Ishimwe', 'Emilie', '2001', '0786231337', NULL, NULL, 'ishimwe@gmail.com', '1234', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `Aid` int(10) NOT NULL,
  `issueDate` varchar(20) DEFAULT NULL,
  `returnDate` varchar(20) DEFAULT NULL,
  `Pid` int(11) DEFAULT NULL,
  `Cid` int(11) DEFAULT NULL,
  `Did` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`Aid`, `issueDate`, `returnDate`, `Pid`, `Cid`, `Did`) VALUES
(1, '10-05-2023', '11-06-2023', 1, 1, 1),
(2, '12-05-203', '15-06-2023', 5, 2, 3),
(3, '11-05-2023', '13-06-2023', 6, 1, 2),
(5, '20-05-2023', '25-06-2023', 8, 3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `clinic`
--

CREATE TABLE `clinic` (
  `Cid` int(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clinic`
--

INSERT INTO `clinic` (`Cid`, `name`, `location`, `type`) VALUES
(1, 'Kabyayi Hospital', 'Muhanga', 'PUBLIC'),
(2, 'Umurage medical clinic ', 'Muhanga', 'PRIVATE'),
(3, 'CHUB', 'Huye', 'PUBLIC');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `Did` int(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `qualification` varchar(30) DEFAULT NULL,
  `specialisation` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Did`, `name`, `telephone`, `email`, `qualification`, `specialisation`) VALUES
(1, 'GASHUMBA Diane', '0788452254', 'gashumba@gmail.com', 'Doctor', 'Ophthamology'),
(2, 'Hirwa Benjamin', '07884672254', 'hirwa@gmail.com', 'Assistant doctor', 'Pediatrics'),
(3, 'DUSHIME Elissa', '0788467254', 'dushime@gmail.com', 'Doctor', 'Orthopedic Surgery'),
(4, 'Gasana Hirwa Adolphe', '07884671154', 'gasana@gmail.com', 'Doctor', 'Emergency'),
(5, 'IRAKOZE Deborah', '0788453456', 'irakoze@gmail.com', 'Doctor', 'Pediatrics'),
(6, 'GASHEMA Roger', '0788456789', 'gashema@gmail.com', 'Doctor', 'Pediatrics'),
(7, 'RURANGWA Martin', '0788456789', 'rurangwa@gmail.co', 'Assistant doctor', 'NeuroSurgery'),
(8, 'MUGEMANA Patric', '0788456784', 'mugema@gmail.com', 'Doctor', 'Internal Medicine'),
(9, 'GASHUMBA Diane', '0788452387', 'gashumba@gmail.com', 'Doctor', 'Ophthamology'),
(10, 'GASHEMA Gaspard', '0789674532', 'gashema@gmail.com', 'Assistant doctor', 'NeuroSurgery');

-- --------------------------------------------------------

--
-- Table structure for table `nurse`
--

CREATE TABLE `nurse` (
  `Nid` int(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nurse`
--

INSERT INTO `nurse` (`Nid`, `name`, `gender`, `telephone`, `email`) VALUES
(1, 'RWEMA Xavier', 'Male', '0788456432', 'rwema@gmail.com'),
(2, 'GASARO Gery KEZA', 'Female', '0788459832', 'gasaro@gmail.com'),
(3, 'UWASE Hannah', 'Female', '0788459867', 'uwase@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `Pid` int(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`Pid`, `name`, `gender`, `telephone`, `email`, `address`) VALUES
(1, 'HIRWA  samson', 'Male', '0788674532', 'hirwa@gmail.com', 'Huye'),
(4, 'SANGWA Donatha', 'Female', '07986421468', 'sangwa@gmail.com', 'Huye'),
(5, 'GANZA Bruno SHIMWA', 'Male', '0788454367', 'ganza@gmail.com', 'Huye'),
(6, 'IRADUKUNDA Furah Nancy', 'Male', '0786540234', 'iradukunda@gmail.com', 'Huye'),
(7, 'CYUSA Honore', 'Male', '0782427988', 'cyusa@gmail.com', 'KIGALI'),
(8, 'SHIMWA Delice', 'Female', '0788452279', 'shimwa@gmail.com', 'Muhanga'),
(10, 'Ganza Hakimu Remy', 'Male', '0786234567', 'ganza@gmail.com', 'Huye'),
(11, 'SANO Bella', 'Male', '0788452297', 'sano@gmail.com', 'Huye');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `Sid` int(10) NOT NULL,
  `service_name` varchar(30) DEFAULT NULL,
  `service_cost` int(15) DEFAULT NULL,
  `Pid` int(11) DEFAULT NULL,
  `Cid` int(11) DEFAULT NULL,
  `Did` int(11) DEFAULT NULL,
  `Aid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`Sid`, `service_name`, `service_cost`, `Pid`, `Cid`, `Did`, `Aid`) VALUES
(1, 'Internal Medicine', 2000, 1, 1, 1, 1),
(2, 'Orphtamology', 2500, 7, 1, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`Aid`),
  ADD KEY `Pid` (`Pid`),
  ADD KEY `Cid` (`Cid`),
  ADD KEY `Did` (`Did`);

--
-- Indexes for table `clinic`
--
ALTER TABLE `clinic`
  ADD PRIMARY KEY (`Cid`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`Did`);

--
-- Indexes for table `nurse`
--
ALTER TABLE `nurse`
  ADD PRIMARY KEY (`Nid`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`Pid`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`Sid`),
  ADD KEY `Pid` (`Pid`),
  ADD KEY `Cid` (`Cid`),
  ADD KEY `Did` (`Did`),
  ADD KEY `Aid` (`Aid`),
  ADD KEY `service_name` (`service_name`),
  ADD KEY `service_name_2` (`service_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `Aid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `clinic`
--
ALTER TABLE `clinic`
  MODIFY `Cid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `Did` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `nurse`
--
ALTER TABLE `nurse`
  MODIFY `Nid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `Pid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `Sid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`Pid`) REFERENCES `patient` (`Pid`),
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`Cid`) REFERENCES `clinic` (`Cid`),
  ADD CONSTRAINT `appointment_ibfk_3` FOREIGN KEY (`Did`) REFERENCES `doctor` (`Did`);

--
-- Constraints for table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `service_ibfk_1` FOREIGN KEY (`Pid`) REFERENCES `patient` (`Pid`),
  ADD CONSTRAINT `service_ibfk_2` FOREIGN KEY (`Cid`) REFERENCES `clinic` (`Cid`),
  ADD CONSTRAINT `service_ibfk_3` FOREIGN KEY (`Did`) REFERENCES `doctor` (`Did`),
  ADD CONSTRAINT `service_ibfk_4` FOREIGN KEY (`Aid`) REFERENCES `appointment` (`Aid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
