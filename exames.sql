-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Tempo de geração: 10-Maio-2023 às 02:53
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `exames`
--

CREATE DATABASE exames;
USE exames;
-- --------------------------------------------------------

--
-- Estrutura da tabela `exames`
--

CREATE TABLE `exames` (
  `cod_exame` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `valor` decimal(5,2) NOT NULL,
  `especialidade` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `exames`
--

INSERT INTO `exames` (`cod_exame`, `nome`, `valor`, `especialidade`) VALUES
(1, 'Endoscopia Pulmonar', '185.25', NULL),
(2, 'Exame de fezes', '30.50', NULL),
(3, 'Triglicerídeos', '45.99', NULL),
(4, 'Exame de toque (próstata)', '489.60', NULL),
(5, 'Exame do exame', '145.30', NULL),
(6, 'Exame de prÃ³stata', '199.99', 'Neuro'),
(7, 'Exame da cabeÃ§a', '259.60', 'Dentista');

-- --------------------------------------------------------

--
-- Estrutura da tabela `exames_pacientes`
--

CREATE TABLE `exames_pacientes` (
  `cod_exames_pacientes` int(11) NOT NULL,
  `cod_exame` int(11) DEFAULT NULL,
  `cod_paciente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pacientes`
--

CREATE TABLE `pacientes` (
  `cod_paciente` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `cep` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `pacientes`
--

INSERT INTO `pacientes` (`cod_paciente`, `nome`, `cpf`, `cep`) VALUES
(1, 'Eu te amo! SQN', '111.111.111-11', '99999-999'),
(2, 'Eu te amo! SQN', '123.123.123-12', '88888-888'),
(3, 'Arlindo Cruz', '333.333.333-333', '77777-777'),
(4, 'Eu te amo! SQN', '444.444.444-44', '99999-999');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

CREATE TABLE `telefone` (
  `cod_telefone` int(11) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `cod_paciente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `exames`
--
ALTER TABLE `exames`
  ADD PRIMARY KEY (`cod_exame`);

--
-- Índices para tabela `exames_pacientes`
--
ALTER TABLE `exames_pacientes`
  ADD PRIMARY KEY (`cod_exames_pacientes`),
  ADD KEY `cod_exame` (`cod_exame`),
  ADD KEY `cod_paciente` (`cod_paciente`);

--
-- Índices para tabela `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`cod_paciente`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices para tabela `telefone`
--
ALTER TABLE `telefone`
  ADD PRIMARY KEY (`cod_telefone`),
  ADD KEY `cod_paciente` (`cod_paciente`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `exames`
--
ALTER TABLE `exames`
  MODIFY `cod_exame` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `exames_pacientes`
--
ALTER TABLE `exames_pacientes`
  MODIFY `cod_exames_pacientes` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `cod_paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `telefone`
--
ALTER TABLE `telefone`
  MODIFY `cod_telefone` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `exames_pacientes`
--
ALTER TABLE `exames_pacientes`
  ADD CONSTRAINT `exames_pacientes_ibfk_1` FOREIGN KEY (`cod_exame`) REFERENCES `exames` (`cod_exame`),
  ADD CONSTRAINT `exames_pacientes_ibfk_2` FOREIGN KEY (`cod_paciente`) REFERENCES `pacientes` (`cod_paciente`);

--
-- Limitadores para a tabela `telefone`
--
ALTER TABLE `telefone`
  ADD CONSTRAINT `telefone_ibfk_1` FOREIGN KEY (`cod_paciente`) REFERENCES `pacientes` (`cod_paciente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;