-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04-Dez-2021 às 21:51
-- Versão do servidor: 10.4.20-MariaDB
-- versão do PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projeto_unificado_grupo_2`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `complexidade`
--

CREATE TABLE `complexidade` (
  `id_complexidade` int(11) NOT NULL,
  `nome_complexidade` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `complexidade`
--

INSERT INTO `complexidade` (`id_complexidade`, `nome_complexidade`) VALUES
(1, 'Fácil'),
(2, 'Moderado'),
(3, 'Difícil/Complexo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `prioridade`
--

CREATE TABLE `prioridade` (
  `id_prioridade` int(11) NOT NULL,
  `nome_prioridade` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `prioridade`
--

INSERT INTO `prioridade` (`id_prioridade`, `nome_prioridade`) VALUES
(1, 'Desejável'),
(2, 'Importante'),
(3, 'Essencial');

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto`
--

CREATE TABLE `projeto` (
  `id_projeto` int(11) NOT NULL,
  `nome_projeto` varchar(100) NOT NULL,
  `descricao_projeto` text NOT NULL,
  `usuario_proprietario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `projeto`
--

INSERT INTO `projeto` (`id_projeto`, `nome_projeto`, `descricao_projeto`, `usuario_proprietario`) VALUES
(1, 'Projeto Teste 2', 'Sistema de controle de aluguel', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `requisito`
--

CREATE TABLE `requisito` (
  `id_requisito` int(11) NOT NULL,
  `nome_requisito` varchar(100) NOT NULL,
  `descricao_requisito` text NOT NULL,
  `datacriacao_requisito` date NOT NULL,
  `autor_requisito` int(11) NOT NULL,
  `usuario_ultimamodificacao_requisito` int(11) NOT NULL,
  `data_ultimamodificacao_requisito` date NOT NULL,
  `id_prioridade_requisito` int(11) NOT NULL,
  `esforco_horas_requisito` int(11) NOT NULL,
  `complexidade_requisito` int(11) NOT NULL,
  `id_projeto_requisito` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `requisito`
--

INSERT INTO `requisito` (`id_requisito`, `nome_requisito`, `descricao_requisito`, `datacriacao_requisito`, `autor_requisito`, `usuario_ultimamodificacao_requisito`, `data_ultimamodificacao_requisito`, `id_prioridade_requisito`, `esforco_horas_requisito`, `complexidade_requisito`, `id_projeto_requisito`) VALUES
(1, 'Biometria', 'O sistema deve permitir estrutura para\r\nler e armazenar a biometria.', '2021-11-27', 1, 1, '2021-11-27', 3, 20, 3, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nomecompleto_usuario` varchar(150) NOT NULL,
  `nick_usuario` varchar(50) NOT NULL,
  `email_usuario` varchar(150) NOT NULL,
  `senha_usuario` varchar(200) NOT NULL,
  `telefone_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nomecompleto_usuario`, `nick_usuario`, `email_usuario`, `senha_usuario`, `telefone_usuario`) VALUES
(1, 'Gabriel de Almeida Alves Pinto', 'Gabr13l', 'gabriel.almeida.p@outlook.com', 'e7d80ffeefa212b7c5c55700e4f7193e', 0);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `complexidade`
--
ALTER TABLE `complexidade`
  ADD PRIMARY KEY (`id_complexidade`);

--
-- Índices para tabela `prioridade`
--
ALTER TABLE `prioridade`
  ADD PRIMARY KEY (`id_prioridade`);

--
-- Índices para tabela `projeto`
--
ALTER TABLE `projeto`
  ADD PRIMARY KEY (`id_projeto`),
  ADD KEY `projeto_ibfk_1` (`usuario_proprietario`);

--
-- Índices para tabela `requisito`
--
ALTER TABLE `requisito`
  ADD PRIMARY KEY (`id_requisito`),
  ADD KEY `requisito_ibfk_6` (`usuario_ultimamodificacao_requisito`),
  ADD KEY `requisito_ibfk_2` (`complexidade_requisito`),
  ADD KEY `requisito_ibfk_3` (`id_prioridade_requisito`),
  ADD KEY `requisito_ibfk_4` (`autor_requisito`),
  ADD KEY `requisito_ibfk_5` (`id_projeto_requisito`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `complexidade`
--
ALTER TABLE `complexidade`
  MODIFY `id_complexidade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `prioridade`
--
ALTER TABLE `prioridade`
  MODIFY `id_prioridade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `projeto`
--
ALTER TABLE `projeto`
  MODIFY `id_projeto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `requisito`
--
ALTER TABLE `requisito`
  MODIFY `id_requisito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `projeto`
--
ALTER TABLE `projeto`
  ADD CONSTRAINT `projeto_ibfk_1` FOREIGN KEY (`usuario_proprietario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `requisito`
--
ALTER TABLE `requisito`
  ADD CONSTRAINT `requisito_ibfk_2` FOREIGN KEY (`complexidade_requisito`) REFERENCES `complexidade` (`id_complexidade`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `requisito_ibfk_3` FOREIGN KEY (`id_prioridade_requisito`) REFERENCES `prioridade` (`id_prioridade`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `requisito_ibfk_4` FOREIGN KEY (`autor_requisito`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `requisito_ibfk_5` FOREIGN KEY (`id_projeto_requisito`) REFERENCES `projeto` (`id_projeto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `requisito_ibfk_6` FOREIGN KEY (`usuario_ultimamodificacao_requisito`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
