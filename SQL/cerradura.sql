-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 07-03-2022 a las 13:06:46
-- Versión del servidor: 8.0.28-0ubuntu0.20.04.3
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cerradura`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temperaturas`
--

CREATE TABLE `temperaturas` (
  `id` int NOT NULL,
  `id_usuario` int NOT NULL,
  `nombre` varchar(64) NOT NULL,
  `Temperatura` varchar(64) NOT NULL,
  `Area` varchar(128) NOT NULL,
  `Fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `temperaturas`
--

INSERT INTO `temperaturas` (`id`, `id_usuario`, `nombre`, `Temperatura`, `Area`, `Fecha`) VALUES
(228, 1, ' Giovanni Olmos ', '36.24000168', 'Laboratorio de Sistemas Digitales', '2022-03-05 01:13:11'),
(229, 3, ' Amaury Tovar ', '36.62000656', 'Laboratorio de Sistemas Digitales', '2022-03-05 01:21:33'),
(230, 3, ' Amaury Tovar ', '36.59998703', 'Laboratorio de Sistemas Digitales', '2022-03-05 01:24:03'),
(231, 1, ' Giovanni Olmos ', '39.53998947', 'Laboratorio de Sistemas Digitales', '2022-03-05 01:25:56'),
(232, 1, ' Giovanni Olmos ', '37.37998581', 'Laboratorio de Sistemas Digitales', '2022-03-05 18:41:48'),
(233, 4, ' Vanessa Granados ', '37.19999313', 'Laboratorio de Sistemas Digitales', '2022-03-05 18:42:10'),
(234, 2, ' Gabriel Hurtado ', '37.13999557', 'Laboratorio de Sistemas Digitales', '2022-03-05 18:42:22'),
(235, 1, ' Giovanni Olmos ', '35.3599968', 'Laboratorio de Sistemas Digitales', '2022-03-05 18:57:58'),
(236, 2, ' Gabriel Hurtado ', '37.50001144', 'Laboratorio de Sistemas Digitales', '2022-03-05 21:21:02'),
(237, 2, ' Gabriel Hurtado ', '36.28001022', 'Laboratorio de Sistemas Digitales', '2022-03-05 21:21:26'),
(238, 1, ' Giovanni Olmos ', '37.03998947', 'Laboratorio de Sistemas Digitales', '2022-03-05 21:24:43'),
(239, 3, ' Amaury Tovar ', '36.8599968', 'Laboratorio de Sistemas Digitales', '2022-03-05 21:27:10'),
(240, 3, ' Amaury Tovar ', '36.50001144', 'Laboratorio de Sistemas Digitales', '2022-03-05 21:27:20'),
(241, 1, ' Giovanni Olmos ', '38.34000778', 'Laboratorio de Sistemas Digitales', '2022-03-05 21:34:09'),
(242, 1, ' Giovanni Olmos ', '39.09998703', 'Laboratorio de Sistemas Digitales', '2022-03-05 22:01:44'),
(243, 3, ' Amaury Tovar ', '36.79999924', 'Laboratorio de Sistemas Digitales', '2022-03-05 22:02:07'),
(244, 1, ' Giovanni Olmos ', '36.44001389', 'Laboratorio de Sistemas Digitales', '2022-03-07 02:28:34');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int NOT NULL,
  `identificador` varchar(64) DEFAULT NULL,
  `nombre` varchar(64) NOT NULL,
  `edad` int NOT NULL DEFAULT '0',
  `email` varchar(64) NOT NULL,
  `RFID` varchar(64) NOT NULL,
  `codigo` varchar(64) NOT NULL,
  `dactilar` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `identificador`, `nombre`, `edad`, `email`, `RFID`, `codigo`, `dactilar`) VALUES
(1, 'Gos2398', 'Giovanni Olmos', 24, 'xidotwo@gmail.com', '2357885037', '2172002785', '7'),
(2, 'Gab2398', 'Gabriel Hurtado', 23, 'gabriel@gmail.com', '3284057353', '1234567890', '4'),
(3, 'Amu98', 'Amaury Tovar', 23, 'golden@gmail.com', '2201507601', '2172002786', '5'),
(4, 'Vanessa456', 'Vanessa Granados', 30, 'vane@gamil.com', 'S/N1', '1234569870', 'S/N');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `temperaturas`
--
ALTER TABLE `temperaturas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD UNIQUE KEY `identificador` (`identificador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `temperaturas`
--
ALTER TABLE `temperaturas`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=245;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
