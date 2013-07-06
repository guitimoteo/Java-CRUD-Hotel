/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Hospede;
import banco.Banco;
import VO.Reserva;
import java.sql.PreparedStatement;
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
    
    private Banco banco = new Banco ("root", "", "localhost", "hotel", 3306);
    private Reserva reservaVO;
    
    public ReservaDAO(Banco banco) {
        this.banco = banco;
    }

    public ReservaDAO() {
        
    }


    
    public boolean cadastrar(Object obj) {
        
        //Verifica se o objeto passado é do tipo Reserva
        if (obj instanceof Reserva) {
            reservaVO = (Reserva) obj; //converte de Object para Reserva
        } else {
            return false;
        }

        String sql = "INSERT INTO reserva (codReserva, nomeFuncionario, nomeHospede, situacao, qtdAcompanhante, "
                + "dataEntrada, dataSaida, tipoQuarto, horaReserva, taxaReserva)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        try {
            //Abre a conexao com o banco
            getBanco().abrir();
            PreparedStatement stm = getBanco().getConexao().prepareStatement(sql);
            
        //Concatenação de Strings.
            stm.setInt(1, reservaVO.getCodReserva());
            stm.setString (2, reservaVO.getNomeFuncionario());
            stm.setString(3, reservaVO.getNomeHospede());
            stm.setString(4, reservaVO.getSituacao());
            stm.setInt(5, reservaVO.getQtdAcompanhante());
            stm.setString(6, reservaVO.getDataEntrada());
            stm.setString(7, reservaVO.getDataSaida());
            stm.setString(8, reservaVO.getTipoQuarto());
            stm.setString(9, reservaVO.getHoraReserva());
            stm.setDouble(10, reservaVO.getTaxaReserva());
            
            if (stm.executeUpdate() > 0) {
                getBanco().fechar();
                return true;
            } else {
                getBanco().fechar();
                return false;
            }
        } catch (SQLException ex) {
            getBanco().fechar();
            ex.printStackTrace();
            return false;
        }
    
    }
    

    public boolean atualizar(Object obj) {
        Reserva reservaVO;
        //Verifica se o objeto passado é do tipo Reserva
        if (obj instanceof Reserva) {
            reservaVO = (Reserva) obj; //converte de Object para Reserva
        } else {
            return false;
        }

        String sql = "UPDATE hospede SET qtdAcompanhante = '" + reservaVO.getQtdAcompanhante()
                + "', dataEntrada = '" + reservaVO.getDataEntrada()
                + "', dataSaida = '" + reservaVO.getDataSaida()
                + "', tipoQuarto = '" + reservaVO.getTipoQuarto()
                + "', horaReserva = '" + reservaVO.getHoraReserva()
                + "', situacao = '" + reservaVO.getSituacao()
                + "', taxaReserva = '" + reservaVO.getTaxaReserva()
                + "' WHERE codReserva = '" + reservaVO.getCodReserva() + "'";
        try {
            //Abre a conexao com o banco
            getBanco().abrir();
            Statement stm = getBanco().getConexao().createStatement();
            if (stm.executeUpdate(sql) > 0) {
                getBanco().fechar();
                return true;
            } else {
                getBanco().fechar();
                return false;
            }
        } catch (SQLException ex) {
            getBanco().fechar();
            ex.printStackTrace();
            return false;
        }

    }
   

    public boolean deletar(Object obj) {
         Reserva reservaVO;
        //Verifica se o objeto passado é do tipo Reserva
        if (obj instanceof Reserva) {
            reservaVO = (Reserva) obj; //converte de Object para Reserva
        } else {
            return false;
        }

        String sql = "DELETE FROM reserva WHERE codReserva = " + reservaVO.getCodReserva();
        try {
            //Abre a conexao com o banco
            getBanco().abrir();
            Statement stm = getBanco().getConexao().createStatement();
            if (stm.executeUpdate(sql) > 0) {
                getBanco().fechar();
                return true;
            } else {
                getBanco().fechar();
                return false;
            }
        } catch (SQLException ex) {
            getBanco().fechar();
            ex.printStackTrace();
            return false;
        }      
        
    }


    public Object buscar(int pk) {

        Vector quartos = new Vector(1);

        //Objeto de Retorno
        Reserva reservaVO = null;
        String sql = "SELECT * FROM reserva WHERE codReserva = " + pk;

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                System.out.println("Reserva Encontrada!!!");
                reservaVO = new Reserva();
                reservaVO.setCodReserva(pk);
                reservaVO.setQtdAcompanhante(rs.getInt("qtdAcompanhante"));
                reservaVO.setDataEntrada(rs.getString("dataEntrada"));
                reservaVO.setDataSaida(rs.getString("dataSaida"));
                reservaVO.setTipoQuarto(rs.getString("tipoQuarto"));
                reservaVO.setHoraReserva(rs.getString("horaReserva"));
                reservaVO.setSituacao(rs.getString("situacao"));
                reservaVO.setTaxaReserva(rs.getDouble("taxaReserva"));
            }
            else
                System.out.println("Reserva Não Encontrada!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reservaVO;
    }

    /**
     * @return the banco
     */
    public Banco getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
   
    }



    



    
   
