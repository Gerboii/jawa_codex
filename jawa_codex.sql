-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 21-04-2026 a las 18:05:25
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `jawa_codex`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `droids`
--

CREATE TABLE `droids` (
  `id` bigint(20) NOT NULL,
  `height` int(11) DEFAULT NULL,
  `mass` int(11) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `plating_color` varchar(255) DEFAULT NULL,
  `primary_function` varchar(255) DEFAULT NULL,
  `sensor_color` varchar(255) DEFAULT NULL,
  `manufacturer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `droids`
--

INSERT INTO `droids` (`id`, `height`, `mass`, `model`, `name`, `plating_color`, `primary_function`, `sensor_color`, `manufacturer_id`) VALUES
(1, 96, 32, 'R2 series', 'R2-D2', 'White/Blue', 'Astromech droid', 'Red', 1),
(2, 171, 75, '3PO series', 'C-3PO', 'Gold', 'Protocol droid', 'Yellow', 2),
(3, 67, 18, 'BB series', 'BB-8', 'White/Orange', 'Astromech droid', 'Black', 3),
(4, 216, 104, 'KX series', 'K-2SO', 'Black', 'Security droid', 'Red', 4),
(5, 200, 140, 'IG series', 'IG-88', 'Silver', 'Assassin droid', 'Red', 5),
(6, 180, 75, 'HK series', 'HK-47', 'Bronze', 'Assassin droid', 'Red', 6),
(7, 170, 60, 'Custom', 'L3-37', 'White', 'Pilot droid', 'Green', 7),
(8, 97, 32, 'R5 series', 'R5-D4', 'White/Red', 'Astromech droid', 'Red', 1),
(9, 104, 35, 'C1 series', 'Chopper', 'White/Orange', 'Astromech droid', 'Orange', 1),
(10, 160, 48, 'EV series', 'EV-9D9', 'Gray', 'Supervisor droid', 'Red', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `manufacturers`
--

CREATE TABLE `manufacturers` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `manufacturers`
--

INSERT INTO `manufacturers` (`id`, `name`) VALUES
(1, 'Industrial Automaton'),
(2, 'Cybot Galactica'),
(3, 'BB Astromech'),
(4, 'Arakyd Industries'),
(5, 'Holowan Laboratories'),
(6, 'Czerka Corporation'),
(7, 'L3-37'),
(8, 'MerenData, Corellian Engineering Corporation'),
(9, 'Incom Corporation'),
(10, 'Sienar Fleet Systems'),
(11, 'Kuat Drive Yards'),
(12, 'Kuat Systems Engineering'),
(13, 'Alliance Underground Engineering'),
(14, 'Slayn & Korpil'),
(15, 'Koensayr Manufacturing'),
(16, 'Kuat Drive Yards, Fondor Shipyards'),
(17, 'Fondor Shipyards'),
(18, 'Gallofree Yards, Inc.'),
(19, 'Theed Palace Space Vessel Engineering Corps'),
(20, 'Incom Corporation, Subpro Corporation'),
(21, 'Republic Sienar Systems'),
(22, 'Corellian Engineering Corporation'),
(23, 'Razalon'),
(24, 'Aratech Repulsor Company'),
(25, 'Huppla Pasa Tisc Shipwrights Collective'),
(26, 'SoroSuub Corporation'),
(27, 'Cygnus Spaceworks'),
(28, 'Haor Chall Engineering'),
(29, 'Colla Designs, Phlac-Arphocc Automata Industries'),
(30, 'Baktoid Fleet Ordnance'),
(31, 'Free Dac Volunteers Engineering Corps'),
(32, 'Hoersch-Kessel Drive'),
(33, 'Kuat Drive Yards, Incom corporation'),
(34, 'Corellia Mining Corporation'),
(35, 'Bespin Motors');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `starships`
--

CREATE TABLE `starships` (
  `id` bigint(20) NOT NULL,
  `mglt` int(11) DEFAULT NULL,
  `cargo_capacity` int(11) DEFAULT NULL,
  `consumables` varchar(255) DEFAULT NULL,
  `cost_in_credits` int(11) DEFAULT NULL,
  `crew` int(11) DEFAULT NULL,
  `hyperdrive_rating` int(11) DEFAULT NULL,
  `lenght` int(11) DEFAULT NULL,
  `max_atmosphering_speed` int(11) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `passengers` int(11) DEFAULT NULL,
  `starship_class` varchar(255) DEFAULT NULL,
  `manufacturer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `starships`
--

INSERT INTO `starships` (`id`, `mglt`, `cargo_capacity`, `consumables`, `cost_in_credits`, `crew`, `hyperdrive_rating`, `lenght`, `max_atmosphering_speed`, `model`, `name`, `passengers`, `starship_class`, `manufacturer_id`) VALUES
(1, 75, 100000, '2 months', 100000, 4, 50, 3475, 1050, 'YT-1300 light freighter', 'Millennium Falcon', 6, 'Light freighter', 22),
(2, 100, 110, '1 week', 149999, 1, 100, 1250, 1050, 'T-65 X-wing starfighter', 'X-wing', 0, 'Starfighter', 9),
(3, 100, 65, '2 days', 75000, 1, 100, 899, 1200, 'Twin Ion Engine/Ln Starfighter', 'TIE Fighter', 0, 'Starfighter', 10),
(4, 60, 36000000, '2 years', 150000000, 47060, 200, 160000, 975, 'Imperial I-class Star Destroyer', 'Star Destroyer', 0, 'Capital ship', 11),
(5, 70, 80000, '1 month', NULL, 1, 300, 2150, 1000, 'Firespray-31-class patrol and attack craft', 'Slave 1', 6, 'Patrol craft', 12),
(6, 120, 40, '1 week', 175000, 1, 100, 960, 1300, 'RZ-1 A-wing interceptor', 'A-wing', 0, 'Interceptor', 13),
(7, 91, 45, '1 week', 220000, 1, 200, 1690, 950, 'A/SF-01 B-wing starfighter', 'B-wing', 0, 'Assault starfighter', 14),
(8, 80, 110, '1 week', 135000, 2, 100, 2340, 1000, 'BTL Y-wing starfighter', 'Y-wing', 0, 'Assault starfighter', 15),
(9, 40, 250000000, '6 years', 1143350000, 279144, 400, 1900000, 975, 'Executor-class Star Dreadnought', 'Executor', 38000, 'Star Dreadnought', 16),
(10, 20, 19000000, '6 months', 3000000, 6, 400, 9000, 650, 'GR-75 medium transport', 'Rebel transport', 90, 'Medium transport', 18),
(11, 75, 2000000, '1 month', NULL, 8, 180, 7600, 920, 'J-type 327 Nubian', 'Naboo Royal Starship', 20, 'Yacht', 19),
(12, 100, 110, '5 days', NULL, 3, 100, 1450, 1000, 'Aggressive ReConnaissance-170 starfighter', 'ARC-170', 0, 'Starfighter', 20),
(13, 85, 60, '2 days', NULL, 1, 100, 547, 1500, 'Eta-2 Actis-class light interceptor', 'Eta-2 Actis', 0, 'Interceptor', 12),
(14, 60, 20000000, '6 years', NULL, 7400, 200, 113700, 975, 'Venator-class', 'Venator-class Star Destroyer', 2000, 'Capital ship', 11),
(15, 100, 65, '3 days', NULL, 1, 100, 1100, 1100, 'N-1', 'Naboo N-1 Starfighter', 0, 'Starfighter', 19),
(16, 85, 60, '2 days', NULL, 1, 100, 547, 1500, 'Eta-2 Actis-class interceptor', 'Jedi Interceptor', 0, 'Interceptor', 12),
(17, 80, 150000, '1 month', NULL, 1, 150, 2650, 1180, 'Scimitar', 'Sith Infiltrator', 6, 'Starfighter', 21),
(18, 90, 60, '2 days', NULL, 1, 100, 790, 1050, 'Alpha-3 Nimbus-class V-wing starfighter', 'V-wing', 0, 'Starfighter', 12),
(19, 90, 60, '2 days', NULL, 1, 100, 800, 1150, 'Delta-7 Aethersprite-class light interceptor', 'Delta-7 Aethersprite', 0, 'Interceptor', 12),
(20, 50, 80000, '1 month', NULL, 6, 100, 2000, 850, 'Lambda-class T-4a shuttle', 'Imperial Shuttle', 20, 'Shuttle', 10),
(21, 60, 3000000, '1 year', 3500000, 165, 200, 15000, 950, 'CR90 corvette', 'Tantive IV', 30, 'Corvette', 22),
(22, 70, 80000, '1 month', NULL, 1, 300, 2150, 1000, 'Firespray-31-class patrol and attack craft', 'Slave II', 6, 'Patrol craft', 12),
(23, 60, 40, '2 days', NULL, 1, 100, 780, 850, 'TIE/sa bomber', 'TIE Bomber', 0, 'Bomber', 10),
(24, 60, 36000000, '2 years', 150000000, 47060, 200, 160000, 975, 'Imperial I-class Star Destroyer', 'Imperial Star Destroyer', 0, 'Capital ship', 11),
(25, NULL, 10, '1 day', NULL, 1, NULL, 200, 180, 'FC-20 speeder bike', 'Sith Speeder', 0, 'Speeder', 23),
(26, NULL, 4, '2 days', NULL, 1, NULL, 300, 360, '74-Z speeder bike', 'Speeder Bike', 1, 'Speeder', 24),
(27, 60, 180000, '1 month', NULL, 3, 150, 1520, NULL, 'Punworcca 116-class interstellar sloop', 'Solar Sailer', 11, 'Sloop', 25),
(28, 100, 30, '2 days', NULL, 1, 100, 980, 1200, 'Nantex-class territorial defense starfighter', 'Geonosian Starfighter', 0, 'Starfighter', 25),
(29, 75, 500000, '2 months', NULL, 6, 100, 2000, 850, 'YT-2000 light freighter', 'Hound\'s Tooth', 10, 'Light freighter', 22),
(30, 80, 150000, '1 month', NULL, 1, 150, 2650, 1180, 'Sith Infiltrator', 'Scimitar', 6, 'Starfighter', 21),
(31, 110, 75, '2 days', NULL, 1, 100, 960, 1250, 'TIE/in interceptor', 'Tie Interceptor', 0, 'Starfighter', 10),
(32, 75, 500000, '2 months', NULL, 8, 180, 11500, 920, 'J-type diplomatic barge', 'Naboo Royal Cruiser', 50, 'Yacht', 19),
(33, NULL, 5, '2 days', NULL, 1, NULL, 340, 250, 'X-34', 'X-34 Landspeeder', 1, 'Landspeeder', 26),
(34, NULL, 10, '2 days', NULL, 2, NULL, 530, 650, 'T-47 airspeeder', 'Snowspeeder', 0, 'Airspeeder', 9),
(35, 70, 70000, '2 months', NULL, 4, 100, 4390, 1025, 'VCX-100 light freighter', 'The Ghost', 6, 'Light freighter', 22),
(36, 90, 40000, '1 month', NULL, 1, 100, 1410, 1050, 'VCX-series auxiliary starfighter', 'Phantom', 6, 'Auxiliary starfighter', 22),
(37, 70, 70000, '2 months', NULL, 2, 75, 2150, 950, 'YT-2400 light freighter', 'Outrider', 6, 'Light freighter', 22),
(38, 75, 50000, '1 month', NULL, 2, 100, 2400, 1000, 'ST-70 Assault Ship', 'Razor Crest', 6, 'Assault ship', 11),
(39, 75, 300000, '1 month', NULL, 8, 180, 2920, 920, 'J-type star skiff', 'Naboo Yacht', 30, 'Yacht', 19),
(40, 80, 40000, '1 month', NULL, 4, 100, 2420, 950, 'UT-60D', 'U-wing', 8, 'Transport', 9),
(41, 105, 75, '2 days', NULL, 1, 100, 920, 1200, 'TIE Advanced x1', 'TIE Advanced x1', 0, 'Starfighter', 10),
(42, 75, 2000000, '1 month', NULL, 8, 180, 7600, 920, 'J-type 327', 'J-type 327 Nubian', 20, 'Yacht', 19),
(43, 75, 2000000, '1 month', NULL, 8, 180, 7600, 920, 'J-type 327 Nubian', 'Naboo Royal Starship', 20, 'Yacht', 19),
(44, 100, 65, '3 days', NULL, 1, 100, 1100, 1100, 'N-1', 'Naboo N-1 Starfighter', 0, 'Starfighter', 19),
(45, 80, 150000, '1 month', NULL, 1, 150, 2650, 1180, 'Scimitar', 'Sith Infiltrator', 6, 'Starfighter', 21),
(46, 70, 70000, '1 month', NULL, 2, 100, 2230, 1050, 'Omicron-class attack shuttle', 'Havoc Marauder', 12, 'Attack shuttle', 27),
(47, 80, 100000, '1 month', NULL, 1, 100, 3480, 1000, 'Fondor Haulcraft', 'Luthen\'s Ship', 6, 'Haulcraft', 17),
(48, 60, 3000000, '1 year', 3500000, 165, 200, 15000, 950, 'CR90 corvette', 'Tantive IV', 30, 'Corvette', 22),
(49, 75, 100000, '2 months', 100000, 4, 50, 3475, 1050, 'YT-1300 light freighter', 'Millennium Falcon', 6, 'Light freighter', 22),
(50, 90, 60, '2 days', NULL, 1, 100, 800, 1150, 'Delta-7 Aethersprite-class light interceptor', 'Jedi Starfighter', 0, 'Interceptor', 12),
(51, 100, NULL, NULL, NULL, NULL, 100, 350, 1200, 'Variable Geometry Self-Propelled Battle Droid', 'Vulture Droid', NULL, 'Starfighter', 28),
(52, 100, NULL, NULL, NULL, NULL, 100, 540, 1180, 'Droid Tri-Fighter', 'Tri-Fighter', NULL, 'Starfighter', 29),
(53, 100, NULL, NULL, NULL, NULL, 100, 1490, 1180, 'Baktoid Armor Workshop', 'Hyena Bomber', NULL, 'Starfighter', 29),
(54, 100, NULL, NULL, NULL, NULL, 100, 1200, 950, 'Heavy Missile Platform', 'Droid Gunship', NULL, 'Gunship', 30),
(55, 60, 14000000, '6 years', NULL, 216, 150, 484500, 975, 'Subjugator-class heavy cruiser', 'Malevolence', 0, 'Heavy cruiser', 31),
(56, 60, 15000000, '6 years', NULL, 600, 150, 108800, 950, 'Providence-class Dreadnought', 'Invisible Hand', 0, 'Dreadnought', 31),
(57, 60, 14000000, '6 years', NULL, 216, 150, 484500, 975, 'Subjugator-class heavy cruiser', 'Malevolence', 0, 'Heavy cruiser', 31),
(58, 60, 15000000, '6 years', NULL, 600, 150, 108800, 950, 'Providence-class Dreadnought', 'Invisible Hand', 0, 'Dreadnought', 31),
(59, 60, 55000000, '6 years', NULL, 150, 200, 317000, 950, 'Lucrehulk-class battleship', 'Droid Control Ship', 0, 'Battleship', 32),
(60, 60, 20000000, '6 years', NULL, 7400, 200, 113700, 975, 'Venator-class', 'Venator-class Star Destroyer', 2000, 'Capital ship', 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehicles`
--

CREATE TABLE `vehicles` (
  `id` bigint(20) NOT NULL,
  `cargo_capacity` int(11) DEFAULT NULL,
  `consumables` varchar(255) DEFAULT NULL,
  `cost_in_credits` int(11) DEFAULT NULL,
  `crew` int(11) DEFAULT NULL,
  `lenght` int(11) DEFAULT NULL,
  `max_atmosphering_speed` int(11) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `passengers` int(11) DEFAULT NULL,
  `vehicle_class` varchar(255) DEFAULT NULL,
  `manufacturer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehicles`
--

INSERT INTO `vehicles` (`id`, `cargo_capacity`, `consumables`, `cost_in_credits`, `crew`, `lenght`, `max_atmosphering_speed`, `model`, `name`, `passengers`, `vehicle_class`, `manufacturer_id`) VALUES
(1, 10, NULL, NULL, 2, 450, 650, 't-47 airspeeder', 'Snowspeeder', 0, 'airspeeder', 9),
(2, 65, '2 days', 75000, 1, 630, 1200, 'Twin Ion Engine/Ln Starfighter', 'TIE Fighter', 0, 'Starfighter', 10),
(3, 50000, '2 months', 150000, 46, 3680, 30, 'Digger Crawler', 'Sand Crawler', 30, 'Wheeled', 34),
(4, 5, NULL, 10550, 1, 340, 250, 'X-34 Landspeeder', 'X-34 Landspeeder', 1, 'Landspeeder', 26),
(5, 15, '2 days', 86500, 1, 780, 850, 'TIE/sa Bomber', 'TIE Bomber', 0, 'Bomber', 10),
(6, 1000, NULL, 226500, 5, 2060, 60, 'All Terrain Armored Transport', 'AT-AT', 40, 'Walker', 11),
(7, 200, NULL, 89100, 2, 860, 90, 'All Terrain Scout Transport', 'AT-ST', 0, 'Walker', 11),
(8, 5, NULL, 4000, 1, 150, 180, 'FC-20 Speeder Bike', 'Sith Speeder', 0, 'Speeder', 23),
(9, 4, '2 days', 8000, 1, 300, 360, '74-Z Speeder Bike', 'Speeder Bike', 1, 'Speeder', 24),
(10, 5, '2 days', 8000, 1, 300, 500, '74-Z Speeder Bike', 'Imperial Speeder Bike', 1, 'Speeder', 24),
(11, 10, NULL, 75000, 2, 700, 1500, 'Storm IV Twin-Pod', 'Cloud Car', 0, 'Air speeder', 35),
(12, 150000, '1 month', NULL, 1, 2650, 1180, 'Sith Infiltrator', 'Sith Infiltrator', 6, 'Starfighter', 10),
(13, 45, '1 week', 220000, 1, 1690, 950, 'B-Wing starfighter', 'B-Wing', 0, 'Starfighter', 14),
(14, 80000, '1 month', 150000, 1, 2150, 1000, 'Firespray-31-class patrol and attack craft', 'Slave 1', 6, 'Patrol craft', 12),
(15, 180000, '1 month', 285000, 3, 1520, 1600, 'Punworcca 116-class interstellar sloop', 'Solar Sailer', 11, 'Sloop', 25),
(16, 30, '2 days', 125000, 1, 980, 1200, 'Nantex-class territorial defense starfighter', 'Geonosian Starfighter', 0, 'Starfighter', 25),
(17, 500000, '2 months', 150000, 6, 2000, 850, 'YT-2000 light freighter', 'Hound\'s Tooth', 10, 'Light freighter', 22),
(18, 150000, '1 month', 200000, 1, 2650, 1180, 'Sith Infiltrator', 'Scimitar', 6, 'Starfighter', 21),
(19, 75, '2 days', 75000, 1, 960, 1250, 'TIE/in interceptor', 'Tie Interceptor', 0, 'Starfighter', 10),
(20, 500000, '2 months', 200000, 8, 11500, 920, 'J-type diplomatic barge', 'Naboo Royal Cruiser', 50, 'Yacht', 19),
(21, 5, '2 days', 10550, 1, 340, 250, 'X-34', 'X-34 Landspeeder', 1, 'Landspeeder', 26),
(22, 10, NULL, NULL, 2, 450, 650, 'T-47 airspeeder', 'Snowspeeder', 0, 'Airspeeder', 9),
(23, 10, NULL, 75000, 2, 700, 1500, 'Storm IV Twin-Pod', 'Cloud Car', 0, 'Air speeder', 35),
(24, 65, '2 days', 75000, 1, 630, 1200, 'Twin Ion Engine/Ln Starfighter', 'TIE Fighter', 0, 'Starfighter', 10),
(25, 5, NULL, 4000, 1, 150, 180, 'FC-20 speeder bike', 'Sith Speeder', 0, 'Speeder', 23),
(26, 150000, '1 month', NULL, 1, 2650, 1180, 'Sith Infiltrator', 'Sith Infiltrator', 6, 'Starfighter', 10),
(27, 15, '2 days', 86500, 1, 780, 850, 'TIE/sa Bomber', 'Tie Bomber', 0, 'Bomber', 10),
(28, 1000, NULL, 226500, 5, 2060, 60, 'All Terrain Armored Transport', 'AT-AT', 40, 'Walker', 11),
(29, 200, NULL, 89100, 2, 860, 90, 'All Terrain Scout Transport', 'AT-ST', 0, 'Walker', 11),
(30, 180000, '1 month', 285000, 3, 1520, 1600, 'Punworcca 116-class interstellar sloop', 'Solar Sailer', 11, 'Sloop', 25),
(31, 30, '2 days', 125000, 1, 980, 1200, 'Nantex-class territorial defense starfighter', 'Geonosian Starfighter', 0, 'Starfighter', 25),
(32, 500000, '2 months', 150000, 6, 2000, 850, 'YT-2000 light freighter', 'Hound\'s Tooth', 10, 'Light freighter', 22),
(33, 80000, '1 month', 150000, 1, 2150, 1000, 'Firespray-31-class patrol and attack craft', 'Slave 1', 6, 'Patrol craft', 12),
(34, 150000, '1 month', 200000, 1, 2650, 1180, 'Sith Infiltrator', 'Scimitar', 6, 'Starfighter', 21),
(35, 75, '2 days', 75000, 1, 960, 1250, 'TIE/in interceptor', 'Tie Interceptor', 0, 'Starfighter', 10),
(36, 500000, '2 months', 200000, 8, 11500, 920, 'J-type diplomatic barge', 'Naboo Royal Cruiser', 50, 'Yacht', 19),
(37, 10, NULL, NULL, 2, 450, 650, 'T-47 airspeeder', 'Snowspeeder', 0, 'airspeeder', 9),
(38, 50000, '2 months', 150000, 46, 3680, 30, 'Digger Crawler', 'Sand Crawler', 30, 'Wheeled', 34),
(39, 5, NULL, 10550, 1, 340, 250, 'X-34 Landspeeder', 'X-34 Landspeeder', 1, 'Landspeeder', 26),
(40, 15, '2 days', 86500, 1, 780, 850, 'TIE/sa Bomber', 'TIE Bomber', 0, 'Bomber', 10),
(41, 1000, NULL, 226500, 5, 2060, 60, 'All Terrain Armored Transport', 'AT-AT', 40, 'Walker', 11),
(42, 200, NULL, 89100, 2, 860, 90, 'All Terrain Scout Transport', 'AT-ST', 0, 'Walker', 11),
(43, 5, NULL, 4000, 1, 150, 180, 'FC-20 Speeder Bike', 'Sith Speeder', 0, 'Speeder', 23),
(44, 4, '2 days', 8000, 1, 300, 360, '74-Z Speeder Bike', 'Speeder Bike', 1, 'Speeder', 24),
(45, 5, '2 days', 8000, 1, 300, 500, '74-Z Speeder Bike', 'Imperial Speeder Bike', 1, 'Speeder', 24),
(46, 10, NULL, 75000, 2, 700, 1500, 'Storm IV Twin-Pod', 'Cloud Car', 0, 'Air speeder', 35),
(47, 150000, '1 month', NULL, 1, 2650, 1180, 'Sith Infiltrator', 'Sith Infiltrator', 6, 'Starfighter', 10),
(48, 45, '1 week', 220000, 1, 1690, 950, 'B-Wing starfighter', 'B-Wing', 0, 'Starfighter', 14),
(49, 80000, '1 month', 150000, 1, 2150, 1000, 'Firespray-31-class patrol and attack craft', 'Slave 1', 6, 'Patrol craft', 12),
(50, 180000, '1 month', 285000, 3, 1520, 1600, 'Punworcca 116-class interstellar sloop', 'Solar Sailer', 11, 'Sloop', 25);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `droids`
--
ALTER TABLE `droids`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfl48nprh049lvr6omck8guhnl` (`manufacturer_id`);

--
-- Indices de la tabla `manufacturers`
--
ALTER TABLE `manufacturers`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `starships`
--
ALTER TABLE `starships`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKftgvxqreqd1kssb7e6i77lpf2` (`manufacturer_id`);

--
-- Indices de la tabla `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnxnkm10xpu2xo4bk1pkgjfr94` (`manufacturer_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `droids`
--
ALTER TABLE `droids`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `manufacturers`
--
ALTER TABLE `manufacturers`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `starships`
--
ALTER TABLE `starships`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `vehicles`
--
ALTER TABLE `vehicles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `droids`
--
ALTER TABLE `droids`
  ADD CONSTRAINT `FKfl48nprh049lvr6omck8guhnl` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturers` (`id`);

--
-- Filtros para la tabla `starships`
--
ALTER TABLE `starships`
  ADD CONSTRAINT `FKftgvxqreqd1kssb7e6i77lpf2` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturers` (`id`);

--
-- Filtros para la tabla `vehicles`
--
ALTER TABLE `vehicles`
  ADD CONSTRAINT `FKnxnkm10xpu2xo4bk1pkgjfr94` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
