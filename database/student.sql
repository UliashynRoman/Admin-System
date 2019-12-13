-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Дек 13 2019 г., 01:22
-- Версия сервера: 10.4.8-MariaDB
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `student`
--

-- --------------------------------------------------------

--
-- Структура таблицы `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `admin_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `admin`
--

INSERT INTO `admin` (`id`, `email`, `password`, `name`, `admin_status`) VALUES
(1, 'roman@gmail.com', 'Admin1', 'Roman', 'main'),
(5, 'Nowak@gmail.com', 'Nowak1', 'Nowak', 'common'),
(15, 'maria@gmail.com', '123123', 'Maria', 'counter');

-- --------------------------------------------------------

--
-- Структура таблицы `month_payment`
--

CREATE TABLE `month_payment` (
  `id` int(11) NOT NULL,
  `date` varchar(15) NOT NULL,
  `counter_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `month_payment`
--

INSERT INTO `month_payment` (`id`, `date`, `counter_name`) VALUES
(10, '2019-12-05', 'Maria');

-- --------------------------------------------------------

--
-- Структура таблицы `payment_logs`
--

CREATE TABLE `payment_logs` (
  `id` int(11) NOT NULL,
  `admin_name` varchar(25) NOT NULL,
  `transfer_info` varchar(50) NOT NULL,
  `date` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `payment_logs`
--

INSERT INTO `payment_logs` (`id`, `admin_name`, `transfer_info`, `date`) VALUES
(23, 'Maria', '20 pln credited to the student with ID: 25', '2019-12-12 18:40:35'),
(24, 'Roman', '80 pln credited to the student with ID: 25', '2019-12-12 19:17:42'),
(25, 'Roman', '180 pln credited to the student with ID: 20', '2019-12-12 19:17:48'),
(26, 'Maria', '600 pln credited to the student with ID: 25', '2019-12-12 20:20:46'),
(27, 'Roman', '1200 pln credited to the student with ID: 26', '2019-12-12 20:21:52'),
(28, 'Roman', '800 pln credited to the student with ID: 26', '2019-12-12 20:44:08'),
(29, 'Maria', '400 pln credited to the student with ID: 26', '2019-12-12 21:51:48'),
(30, 'Maria', '7000 pln credited to the student with ID: 27', '2019-12-12 21:57:39'),
(31, 'Roman', '900 pln credited to the student with ID: 27', '2019-12-12 22:15:26'),
(32, 'Maria', '888 pln credited to the student with ID: 4', '2019-12-12 22:16:49'),
(33, 'Roman', '130 pln credited to the student with ID: 20', '2019-12-13 01:54:53'),
(34, 'Roman', '20 pln credited to the student with ID: 20', '2019-12-13 02:06:44');

-- --------------------------------------------------------

--
-- Структура таблицы `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `city` varchar(50) NOT NULL,
  `class` int(11) NOT NULL,
  `credit` int(50) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `student`
--

INSERT INTO `student` (`id`, `name`, `email`, `phone`, `city`, `class`, `credit`) VALUES
(4, 'Romario', 'romario@gmail.com', '5771121224', 'Las Vegas', 2, 3388),
(10, 'Michal', 'M@wit.edu.pl', '+48388291', 'Warszawa', 2, 2500),
(13, 'Aleksi', 'Aleksi@Kozminksi.edu.pl', '+3882082922', 'Kryvyi Rih', 4, 2500),
(14, 'Garry', 'Garr@wit.edu.pl', '+49490202', 'Warszawa', 3, 2500),
(15, 'Roman', 'rma@gmail.com', '+33321', 'Warsz', 1, 2500),
(18, 'Fernando', 'fernando@gmail.com', '+48577177222', 'LosSantos', 4, 2500),
(19, 'Trevor', 'nux@gmail.com', '482281177', 'Warszawa', 2, 2500),
(20, 'Ivan', 'Kolpakov@gmail.com', '+412213211', 'Nevada', 1, 2830),
(21, 'Michal', 'M@wit.edu.pl', '+4343422', 'Warszawa', 1, 2500),
(22, 'Briton', 'rma@gmail.com', '+3443124343', 'NewJercy', 1, 2500),
(23, 'Johnatan', 'rma@gmail.com', '+48321224', 'Berlin', 1, 2580),
(25, 'Dimon', 'dim@4gmail.com', '667889772', 'Poznan', 1, 1420),
(26, 'Lera', 'lera@gmail.com', '724577891', 'Warsaw', 2, 2400),
(27, 'Michal', 'michal@gmail.com', '999999887', 'Warsaw', 1, 7900);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `month_payment`
--
ALTER TABLE `month_payment`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `payment_logs`
--
ALTER TABLE `payment_logs`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT для таблицы `month_payment`
--
ALTER TABLE `month_payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT для таблицы `payment_logs`
--
ALTER TABLE `payment_logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT для таблицы `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
