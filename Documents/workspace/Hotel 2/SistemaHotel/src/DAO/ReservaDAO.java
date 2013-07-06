/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Hospede;
import banco.Banco;
import VO.Reserva;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author chris
 */
public class ReservaDAO implements DAO {
    
    private Banco banco;
    private Reserva reservaVO;
    
    public ReservaDAO(Banco banco) {
        this.banco = banco;
    }


    @Override
    public boolean cadastrar(Object obj) {
        
         if (obj instanceof Reserva) {
            reservaVO = (Reserva) obj;
        } else {
            return false;
        }
try {
            banco.abrir();
            //Incluindo um registro de reserva
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "INSERT INTO reserva (codReserva, situacao,dataEntrada, dataSaida "
                    + "horaReserva, taxaReserva, tipoQuarto, qtdAcompanhante) VALUES ("
                    + reservaVO.getCodReserva() + ", "
                    + reservaVO.getSituacao() + ", "
                    + reservaVO.getDataEntrada() + ", "
                    + reservaVO.getDataSaida() + ", "
                    + reservaVO.getHoraReserva() + ", "
                    + reservaVO.getTaxaReserva() + ", "
                    + reservaVO.getTipoQuarto() + ", "
                    + reservaVO.getQtdAcompanhante() + ")";

            //Faz a atualizacao na tabela Eixo
 //           EixoDAO eixoDAO = new EixoDAO(banco);;;
 //           Eixo eixoVO;
 //           for(int x=0; x < chassiVO.getEixos().size(); x++) {
 //               eixoVO = (Eixo)chassiVO.getEixos().get(x);
 //               eixoDAO.alterar(eixoVO);
 //           }

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel cadastrar a reserva: " + ex.getMessage());
            return false;
        }

    }

    public boolean atualizar(Object obj) {
        if (obj instanceof Reserva) {
            reservaVO = (Reserva) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //atualizando um registro de reserva
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "UPDATE reserva SET situacao = " + reservaVO.getSituacao()
                    + ", dataEntrada = " + reservaVO.getDataEntrada()
                    + ", dataSaida = " + reservaVO.getDataSaida()
                    + ", horaReserva = " + reservaVO.getHoraReserva()
                    + ", taxaReserva = " + reservaVO.getTaxaReserva()
                    + ", tipoQuarto = " + reservaVO.getTipoQuarto()
                    + ", qtdAcompanhante = " + reservaVO.getQtdAcompanhante()
                    + " WHERE codReserva = " + reservaVO.getCodReserva();

            //Faz a atualizacao na tabela Eixo
//            EixoDAO eixoDAO = new EixoDAO(banco);
//            Eixo eixoVO;
//            for(int x=0; x < chassiVO.getEixos().size(); x++) {
//                eixoVO = (Eixo)chassiVO.getEixos().get(x);
//                eixoDAO.alterar(eixoVO);
//            }

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel atualizar o registro da reserva: " + ex.getMessage());
            return false;
        }
    }

    public boolean deletar(Object obj) {
        if (obj instanceof Reserva) {
            reservaVO = (Reserva) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //deletando um registro da reserva
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "DELETE FROM reserva WHERE codReserva = "
                    + reservaVO.getCodReserva();

            //Faz a atualizacao na tabela Eixo
//            EixoDAO eixoDAO = new EixoDAO(banco);
//            Eixo eixoVO;
//            for(int x=0; x < chassiVO.getEixos().size(); x++) {
//            eixoVO = (Eixo)chassiVO.getEixos().get(x);
//             eixoVO.setChassi(null);
//             eixoDAO.alterar(eixoVO);
//            }
            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel deletar o registro da reserva: " + ex.getMessage());
            return false;
        }
    }

    public Object buscar(int pk) {

        Vector quartos = new Vector(1);

        try {
            banco.abrir();
            //buscando registro na reserva
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql = "SELECT * FROM reserva WHERE codReserva = "
                    + pk;

            //Lendo os dados
            rs = stm.executeQuery(sql);
            if (rs.next() == true) {
                //informar quarto dessa reserva
                quartos = (Vector) new QuartoDAO(banco).listar("codReserva = " +
                        rs.getInt("codReserva"));
                reservaVO = new Reserva();
                reservaVO.setCodReserva(rs.getInt("codReserva"));
                reservaVO.setSituacao(rs.getString("situacao"));
                reservaVO.setDataEntrada(rs.getString("dataEntrada"));
                reservaVO.setDataSaida(rs.getString("dataSaida"));
                reservaVO.setHoraReserva(rs.getTime("horaReserva"));
                reservaVO.setTaxaReserva(rs.getDouble("taxaReserva"));
                reservaVO.setTipoQuarto(rs.getString("tipoQuarto"));
                reservaVO.setQtdAcompanhante(rs.getInt("qtdAcompanhante"));
                
                return reservaVO;
            } else
                return null; //não achou reserva

        } catch (Exception ex) {
            System.out.println("Nao foi possivel realizar a busca pelo registro da reserva: " + ex.getMessage());
            return null;
        } finally {
            banco.fechar();
        }
    }

    /**
     * public List listar(String criterio) {
       
     List dados = new LinkedList();

        //abrir a conexao
        banco.abrir();
        try {
            Statement stm = banco.getConexao().createStatement();
            ResultSet rs;
            String sql;
            //Testa se existe ou nao algum criterio
            if (criterio.isEmpty()) {
                sql = "SELECT * FROM hospede";
            } else {
                sql = "SELECT * FROM hospede WHERE " + criterio;
            }

            rs = stm.executeQuery(sql);
            //transfere os dados da tabela para a LISTA
            while (rs.next()) {
                dados.add(new Reserva(rs.getInt("codReserva"),
                        rs.getInt("qtdAcompanhante"), rs.getString("dataEntrada"),
                        rs.getString("dataSaida"), rs.getString("tipoQuarto"), 
                        rs.getTime("horaReserva"), rs.getString("situacao"), 
                        rs.getDouble("taxaReserva")));
            }
            rs.close(); //fecha o resultset
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //Fecha a conexao
        banco.fechar();
        return dados; //retorna a lista de dados
    }

     */
   
    }



    



    
   
