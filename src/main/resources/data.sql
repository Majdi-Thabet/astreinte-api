-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 25 sep. 2022 à 13:45
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `astreinte`
--

-- --------------------------------------------------------

--
-- Structure de la table `astreinte`
--

CREATE TABLE `astreinte` (
  `id` bigint(20) NOT NULL,
  `datedebut` date DEFAULT NULL,
  `datefin` date DEFAULT NULL,
  `datepermutation` varchar(255) DEFAULT NULL,
  `dureeastreinte` int(11) NOT NULL,
  `intervention` varchar(255) DEFAULT NULL,
  `prime` double NOT NULL,
  `raison` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `collaborateur_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `astreinte`
--

INSERT INTO `astreinte` (`id`, `datedebut`, `datefin`, `datepermutation`, `dureeastreinte`, `intervention`, `prime`, `raison`, `status`, `type`, `collaborateur_id`) VALUES
(295, '2022-06-20', '2022-06-25', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 37),
(297, '2022-07-02', '2022-07-07', NULL, 8, 'prod et support', 150, 'encongeeeeeee', 1, 'astreinte de jour', 64),
(298, '2022-07-08', '2022-07-13', NULL, 5, 'prod et support', 150.2, NULL, 2, 'astreinte de jour', 37),
(299, '2022-07-14', '2022-07-19', NULL, 5, 'prod et support', 150.2, NULL, 3, 'astreinte de jour', 35),
(300, '2022-07-20', '2022-07-20', NULL, 5, 'prod et support', 150.3, NULL, 0, 'astreinte de jour', 64),
(301, '2022-06-20', '2022-06-25', NULL, 5, 'prod et support', 150.2, NULL, 3, 'astreinte de jour', 37),
(302, '2022-06-26', '2022-07-01', NULL, 5, 'prod et support', 150.2, NULL, 2, 'astreinte de jour', 35),
(303, '2022-07-02', '2022-07-07', NULL, 5, 'prod et support', 150.2, NULL, 1, 'astreinte de jour', 64),
(304, '2022-07-08', '2022-07-13', NULL, 5, 'prod et support', 150.2, NULL, 2, 'astreinte de jour', 37),
(305, '2022-07-14', '2022-07-19', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 35),
(306, '2022-07-20', '2022-07-20', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 64),
(307, '2022-06-20', '2022-06-25', NULL, 5, 'prod et support', 150.2, NULL, 1, 'astreinte de jour', 37),
(308, '2022-06-20', '2022-06-25', NULL, 5, 'prod et support', 150.2, NULL, 2, 'astreinte de jour', 37),
(309, '2022-06-26', '2022-07-01', NULL, 5, 'prod et support', 150.2, NULL, 3, 'astreinte de jour', 35),
(310, '2022-06-26', '2022-07-01', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 35),
(312, '2022-07-02', '2022-07-07', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 64),
(311, '2022-07-02', '2022-07-07', NULL, 5, 'prod et support', 150.2, NULL, 2, 'astreinte de jour', 64),
(313, '2022-07-08', '2022-07-13', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 37),
(314, '2022-07-08', '2022-07-13', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 37),
(315, '2022-07-14', '2022-07-19', NULL, 5, 'prod et support', 150.2, NULL, 1, 'astreinte de jour', 35),
(316, '2022-07-14', '2022-07-19', NULL, 5, 'prod et support', 150.2, NULL, 2, 'astreinte de jour', 35),
(317, '2022-07-20', '2022-07-20', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 64),
(318, '2022-07-20', '2022-07-20', NULL, 5, 'prod et support', 150.2, NULL, 1, 'astreinte de jour', 64),
(319, '2022-06-20', '2022-06-25', NULL, 5, 'prod et support', 150.2, NULL, 1, 'astreinte de jour', 37),
(320, '2022-06-26', '2022-07-01', NULL, 5, 'prod et support', 150.2, NULL, 3, 'astreinte de jour', 35),
(321, '2022-07-02', '2022-07-07', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 64),
(322, '2022-07-08', '2022-07-13', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 37),
(323, '2022-07-14', '2022-07-19', NULL, 5, 'prod et support', 150.2, NULL, 3, 'astreinte de jour', 35),
(324, '2022-07-20', '2022-07-20', NULL, 5, 'prod et support', 150.2, NULL, 1, 'astreinte de jour', 64),
(325, '2022-07-14', '2022-07-20', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 37),
(326, '2022-07-21', '2022-07-27', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 35),
(327, '2022-07-28', '2022-07-28', NULL, 6, 'prod et support', 150.2, NULL, 1, 'astreinte de jour', 64),
(329, '2022-07-15', '2022-07-23', NULL, 8, 'prod et support', 150.2, NULL, 2, 'astreinte de jour', 37),
(330, '2022-07-24', '2022-07-27', NULL, 8, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 35),
(331, '2022-07-28', '2022-08-05', NULL, 8, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 64),
(332, '2022-08-06', '2022-08-14', NULL, 8, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 328),
(333, '2022-07-16', '2022-07-29', NULL, 5, 'prod et support', 150.5, 'encongeeeeee', 1, 'astreinte de nuit', 35),
(334, '2022-07-15', '2022-07-21', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 37),
(335, '2022-07-22', '2022-07-23', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 35),
(336, '2022-07-24', '2022-07-30', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 64),
(337, '2022-07-31', '2022-08-06', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 328),
(338, '2022-07-15', '2022-07-21', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 37),
(339, '2022-07-22', '2022-07-23', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 35),
(340, '2022-07-24', '2022-07-30', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 64),
(341, '2022-07-31', '2022-08-06', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 328),
(342, '2022-07-15', '2022-07-20', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 63),
(343, '2022-07-21', '2022-07-28', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 63),
(344, '2022-07-15', '2022-07-20', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 63),
(345, '2022-07-21', '2022-07-28', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 63),
(346, '2022-07-15', '2022-07-20', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 63),
(347, '2022-07-21', '2022-07-28', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 63),
(348, '2022-07-23', '2022-07-28', NULL, 5, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 63),
(349, '2022-07-24', '2022-07-28', NULL, 4, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 63),
(351, '2022-06-21', '2022-06-27', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 37),
(352, '2022-06-28', '2022-07-04', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 35),
(353, '2022-07-05', '2022-07-11', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 64),
(354, '2022-07-12', '2022-07-18', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 328),
(355, '2022-07-19', '2022-07-25', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 37),
(356, '2022-07-26', '2022-07-27', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 35),
(357, '2022-07-28', '2022-08-03', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 64),
(358, '2022-08-04', '2022-08-10', NULL, 6, 'prod et support', 150.2, NULL, 0, 'astreinte de jour', 328);

-- --------------------------------------------------------

--
-- Structure de la table `astreinte_demandeastreintes`
--

CREATE TABLE `astreinte_demandeastreintes` (
  `astreinte_id` bigint(20) NOT NULL,
  `demandeastreintes_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur`
--

CREATE TABLE `collaborateur` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `poste` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `configastreinte_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `collaborateur`
--

INSERT INTO `collaborateur` (`id`, `email`, `nom`, `password`, `poste`, `prenom`, `username`, `department_id`, `sexe`, `configastreinte_id`) VALUES
(37, 'fehmiii@gmail.com', 'bchirrr', '$2a$10$Feiva.qFBRmD8VAgqz.y8.xTvFMHJdubwuoxKSUEZSp3p/wP5wCbW', 'ingenieurr', 'fehmiii', 'fehmi.bchir', 1, '0', NULL),
(35, 'amel@gmail.com', 'gaoud', '$2a$10$UZgpdNHoPP0YqkqsGnM7WeCcobzz0er76.5J8thmqPHvPERYtlKXW', 'ingenieur', 'amel', 'amel.gaoud', 1, '1', NULL),
(46, 'fehmi1@gmail.com', 'bchir1', '$2a$10$YCXl0X/mE9Z1tr5l9ADjIuFQ92m7apri1BqOBBmgoxDHVmvbEWPZG', 'ingenieur1', 'fehmi1', 'nader45ejl9ouaer', 1, '0', NULL),
(63, 'nadia@gmail.com', 'benrekaya', '$2a$10$UrmjQ5T4HzTe9PMQ8mwbjOGbHQkEabzJauf9H/vIfbrrZ/3saHn8u', 'ingenieur', 'nadia', 'nadia.benrekaya', 2, '1', NULL),
(64, 'syrine@gmail.com', 'slimene', '$2a$10$57Uae5QdWpQwKrTxpEi3Hur4ajtiKy6fvc07s7mrmtTqHbZ1FVBKW', 'ingenieur', 'syrine', 'syrine.slimene', 1, '1', NULL),
(205, 'wafa.latiri@gmail.com', 'wafa', '$2a$10$N2Kdqfnhd0A4Paee.4bzj.2FM6a.YcslmlUxMWmp5t3GHSwvlJhbi', 'chef equipe', 'latiri', 'wafa.latiri', 1, '1', NULL),
(328, 'amel1@gmal.com', 'gaoud', '$2a$10$/AFsP8wsoWpBowOsK/9GouLcm/iH4xVqQHeAIfMK1t.Pr/AGRG1bm', 'ingenieur', 'amel', 'amel1.gaoud', 1, '1', NULL),
(359, 'wafalaatiri@gmail.com', 'laatiri', '$2a$10$xY/wtLjgIAA4jo3zGeGDTuLCPC0.Xzhj/ecJyRjh3aTreHaA/22wW', 'ingenieur', 'wafa', 'wafa.laatiri', 1, '1', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur_astreintes`
--

CREATE TABLE `collaborateur_astreintes` (
  `collaborateur_id` bigint(20) NOT NULL,
  `astreintes_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur_configastreintes`
--

CREATE TABLE `collaborateur_configastreintes` (
  `collaborateur_id` bigint(20) NOT NULL,
  `configastreintes_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur_demandeastreintes`
--

CREATE TABLE `collaborateur_demandeastreintes` (
  `collaborateur_id` bigint(20) NOT NULL,
  `demandeastreintes_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur_departments`
--

CREATE TABLE `collaborateur_departments` (
  `collaborateur_id` bigint(20) NOT NULL,
  `departments_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur_roles`
--

CREATE TABLE `collaborateur_roles` (
  `collaborateur_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `collaborateur_roles`
--

INSERT INTO `collaborateur_roles` (`collaborateur_id`, `roles_id`) VALUES
(24, 1),
(26, 1),
(22, 1),
(19, 1),
(25, 2),
(37, 1),
(35, 1),
(46, 2),
(55, 1),
(63, 1),
(64, 1),
(205, 2),
(328, 1),
(359, 2);

-- --------------------------------------------------------

--
-- Structure de la table `configastreinte`
--

CREATE TABLE `configastreinte` (
  `id` bigint(20) NOT NULL,
  `astreintebycollaborateur` float NOT NULL,
  `datedebutconfig` date DEFAULT NULL,
  `datefinconfig` date DEFAULT NULL,
  `dureeconfigastreinte` int(11) NOT NULL,
  `nombreastreintes` int(11) NOT NULL,
  `nombrecollaborateurs` int(11) NOT NULL,
  `periodeastreinte` int(11) NOT NULL,
  `collaborateur_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `configastreinte`
--

INSERT INTO `configastreinte` (`id`, `astreintebycollaborateur`, `datedebutconfig`, `datefinconfig`, `dureeconfigastreinte`, `nombreastreintes`, `nombrecollaborateurs`, `periodeastreinte`, `collaborateur_id`) VALUES
(14, 1.5, '2022-06-21', '2022-07-27', 36, 6, 4, 6, 37),
(3, 2, '2022-06-20', '2022-07-20', 30, 6, 3, 5, 205),
(4, 2, '2022-06-20', '2022-07-20', 30, 6, 3, 5, 205),
(7, 0.25, '2022-07-15', '2022-07-23', 8, 1, 4, 6, 205),
(8, 0.25, '2022-07-15', '2022-07-23', 8, 1, 4, 6, 205),
(9, 0.5, '2022-07-15', '2022-07-28', 13, 2, 4, 5, 63),
(10, 0.5, '2022-07-15', '2022-07-28', 13, 2, 4, 5, 63),
(11, 0.5, '2022-07-15', '2022-07-28', 13, 2, 4, 5, 63),
(12, 0.2, '2022-07-23', '2022-07-29', 6, 1, 5, 5, 63);

-- --------------------------------------------------------

--
-- Structure de la table `configastreinte_astreinte_list`
--

CREATE TABLE `configastreinte_astreinte_list` (
  `configastreinte_id` bigint(20) NOT NULL,
  `astreinte_list_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `configastreinte_astreinte_list`
--

INSERT INTO `configastreinte_astreinte_list` (`configastreinte_id`, `astreinte_list_id`) VALUES
(14, 356),
(3, 308),
(14, 355),
(3, 309),
(3, 311),
(14, 354),
(14, 353),
(3, 314),
(14, 352),
(3, 315),
(3, 317),
(14, 351),
(4, 319),
(4, 320),
(4, 321),
(4, 322),
(4, 323),
(4, 324),
(14, 358),
(14, 357),
(7, 334),
(7, 335),
(7, 336),
(7, 337),
(8, 338),
(8, 339),
(8, 340),
(8, 341),
(9, 342),
(9, 343),
(10, 344),
(10, 345),
(11, 346),
(11, 347),
(12, 348);

-- --------------------------------------------------------

--
-- Structure de la table `demandeastreinte`
--

CREATE TABLE `demandeastreinte` (
  `id` bigint(20) NOT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `statusdemande` int(11) DEFAULT NULL,
  `typedemande` int(11) DEFAULT NULL,
  `astreinte_id` bigint(20) DEFAULT NULL,
  `collaborateur_id` bigint(20) DEFAULT NULL,
  `historique_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

CREATE TABLE `departement` (
  `id` bigint(20) NOT NULL,
  `departement_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `departement`
--

INSERT INTO `departement` (`id`, `departement_name`) VALUES
(1, 'Support'),
(2, 'BEST'),
(3, 'FinLab'),
(4, 'Digix');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(360);

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

CREATE TABLE `historique` (
  `id` bigint(20) NOT NULL,
  `typeintervention` int(11) DEFAULT NULL,
  `demandeastreinte_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `historique`
--

INSERT INTO `historique` (`id`, `typeintervention`, `demandeastreinte_id`) VALUES
(2, 1, 55);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `description`, `role_name`) VALUES
(1, 'membre equipe', 'USER'),
(2, 'chef equipe', 'ADMIN');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `astreinte`
--
ALTER TABLE `astreinte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4jva53ij2p5ijwtsc6qoxhqki` (`collaborateur_id`);

--
-- Index pour la table `astreinte_demandeastreintes`
--
ALTER TABLE `astreinte_demandeastreintes`
  ADD UNIQUE KEY `UK_jgp9csq6ft65agtoif57ttobk` (`demandeastreintes_id`),
  ADD KEY `FKgt9ab9j87ry73j3ufury9biuh` (`astreinte_id`);

--
-- Index pour la table `collaborateur`
--
ALTER TABLE `collaborateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKggfcyeta07730uemp9hnyurfg` (`configastreinte_id`),
  ADD KEY `FKtlmgmul8myukw41fpqa8as1dv` (`department_id`);

--
-- Index pour la table `collaborateur_astreintes`
--
ALTER TABLE `collaborateur_astreintes`
  ADD UNIQUE KEY `UK_9m1st680d745674wd4g8yohw6` (`astreintes_id`),
  ADD KEY `FK556vvvpmykm8aawp2jppkv8im` (`collaborateur_id`);

--
-- Index pour la table `collaborateur_configastreintes`
--
ALTER TABLE `collaborateur_configastreintes`
  ADD UNIQUE KEY `UK_r00jaei2f6gc787gquw1y1w7e` (`configastreintes_id`),
  ADD KEY `FK8tkk28kewd36qqpgva78xoyob` (`collaborateur_id`);

--
-- Index pour la table `collaborateur_demandeastreintes`
--
ALTER TABLE `collaborateur_demandeastreintes`
  ADD UNIQUE KEY `UK_de3tyym8y3yv37xuotvcnae7o` (`demandeastreintes_id`),
  ADD KEY `FKhktdy0jtb193tf0um8qul7ero` (`collaborateur_id`);

--
-- Index pour la table `collaborateur_departments`
--
ALTER TABLE `collaborateur_departments`
  ADD UNIQUE KEY `UK_6b5erdv5kj3hqpbc6xowdln0o` (`departments_id`),
  ADD KEY `FKm6pv5puj8uhob9yam4d98qhk8` (`collaborateur_id`);

--
-- Index pour la table `collaborateur_roles`
--
ALTER TABLE `collaborateur_roles`
  ADD KEY `FKgcyw8xege3m5t9ngp4vvqybt9` (`roles_id`),
  ADD KEY `FK683ylnnrqvtn889iygtcuutrk` (`collaborateur_id`);

--
-- Index pour la table `configastreinte`
--
ALTER TABLE `configastreinte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjdmqsh9fr3t9wpyssbiywg3a8` (`collaborateur_id`);

--
-- Index pour la table `configastreinte_astreinte_list`
--
ALTER TABLE `configastreinte_astreinte_list`
  ADD UNIQUE KEY `UK_atupt8xnj5ud0w0uilyvmbxpf` (`astreinte_list_id`),
  ADD KEY `FK35t92y6a76mhq327edasa1vmh` (`configastreinte_id`);

--
-- Index pour la table `demandeastreinte`
--
ALTER TABLE `demandeastreinte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmbufx20g9wy6pkc15bjgwon2d` (`astreinte_id`),
  ADD KEY `FKome9t3sf7q0mwfc00v8wxb000` (`collaborateur_id`),
  ADD KEY `FKe3ek1k40m6momcm8lnnckdqnj` (`historique_id`);

--
-- Index pour la table `departement`
--
ALTER TABLE `departement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdm24kn3vqgxqii84hbc9amg7y` (`demandeastreinte_id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `configastreinte`
--
ALTER TABLE `configastreinte`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `demandeastreinte`
--
ALTER TABLE `demandeastreinte`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT pour la table `departement`
--
ALTER TABLE `departement`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `historique`
--
ALTER TABLE `historique`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
