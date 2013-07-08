-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Jun 16, 2013 as 10:05 PM
-- Versão do Servidor: 5.1.44
-- Versão do PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `hotel`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `consumo`
--

CREATE TABLE IF NOT EXISTS `consumo` (
  `codConsumo` int(5) NOT NULL,
  `itensConsumidos` varchar(255) NOT NULL,
  `qtdItens` int(3) NOT NULL,
  `qtdConsumida` int(5) NOT NULL,
  PRIMARY KEY (`codConsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `consumo`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `conta`
--

CREATE TABLE IF NOT EXISTS `conta` (
  `codConta` int(10) NOT NULL,
  `itensConsumidos` varchar(15) NOT NULL,
  `periodoHospedagem` datetime NOT NULL,
  `valorConsumo` double NOT NULL,
  `valorHospedagem` double NOT NULL,
  `valorTotal` double NOT NULL,
  PRIMARY KEY (`codConta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `conta`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `codFuncionario` int(11) NOT NULL,
  `cargo` varchar(25) NOT NULL,
  `setor` varchar(30) NOT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(8) NOT NULL,
  `dataAdmissao` date NOT NULL,
  `dataDemissao` date NOT NULL,
  `salario` float NOT NULL,
  PRIMARY KEY (`codFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `hospedagem`
--

CREATE TABLE IF NOT EXISTS `hospedagem` (
  `codHospedagem` int(5) NOT NULL,
  `dataEntrada` date NOT NULL,
  `dataSaida` date NOT NULL,
  `hora` time NOT NULL,
  PRIMARY KEY (`codHospedagem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hospedagem`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `hospede`
--

CREATE TABLE IF NOT EXISTS `hospede` (
  `codHospede` int(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`codHospede`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hospede`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE IF NOT EXISTS `pagamento` (
  `codPagamento` int(5) NOT NULL,
  `formaPagamento` varchar(15) NOT NULL,
  `qtdParcelas` int(3) NOT NULL,
  `valorParcelado` float NOT NULL,
  `valorTotal` float NOT NULL,
  PRIMARY KEY (`codPagamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pagamento`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
  `codPessoa` int(5) NOT NULL,
  `cpf` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `dataNasc` date NOT NULL,
  `idade` int(3) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `sexo` char(1) NOT NULL,
  PRIMARY KEY (`codPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `codProduto` int(5) NOT NULL,
  `produto` varchar(20) NOT NULL,
  `quantidade` int(2) NOT NULL,
  `estoque` int(5) NOT NULL,
  `valorUnitario` double NOT NULL,
  `Consumo_codConsumo` int(5) NOT NULL,
  PRIMARY KEY (`codProduto`),
  KEY `Consumo_codConsumo` (`Consumo_codConsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `quarto`
--

CREATE TABLE IF NOT EXISTS `quarto` (
  `numero` int(5) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `localizacao` varchar(15) NOT NULL,
  `caracteristica` varchar(30) NOT NULL,
  `qtdeOcupado` int(4) NOT NULL,
  `qtdeVago` int(4) NOT NULL,
  `qtdeReservado` int(4) NOT NULL,
  `qtdeTotal` int(5) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `quarto`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `codReserva` int(5) NOT NULL,
  `qtdePessoas` int(3) NOT NULL,
  `dataEntrada` date NOT NULL,
  `dataSaida` date NOT NULL,
  `tipoQuarto` varchar(20) NOT NULL,
  `horaReserva` time NOT NULL,
  `situacao` varchar(10) NOT NULL,
  `taxaReserva` float NOT NULL,
  PRIMARY KEY (`codReserva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `reserva`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `servico`
--

CREATE TABLE IF NOT EXISTS `servico` (
  `codServico` int(5) NOT NULL,
  `Servico` varchar(45) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `quantidade` int(3) NOT NULL,
  `setor` varchar(20) NOT NULL,
  `valorUnitario` double NOT NULL,
  `valorTotal` double NOT NULL,
  `Consumo_codConsumo` int(5) DEFAULT NULL,
  PRIMARY KEY (`codServico`),
  KEY `Consumo_codConsumo` (`Consumo_codConsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `servico`
--


--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`Consumo_codConsumo`) REFERENCES `consumo` (`codConsumo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para a tabela `servico`
--
ALTER TABLE `servico`
  ADD CONSTRAINT `servico_ibfk_1` FOREIGN KEY (`Consumo_codConsumo`) REFERENCES `consumo` (`codConsumo`) ON DELETE CASCADE ON UPDATE CASCADE;
