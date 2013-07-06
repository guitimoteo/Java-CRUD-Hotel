/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Hospedagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Line
 */
public class HospedagemDAO implements DAO{
    
     private Banco banco = new Banco ("root", "", "localhost", "hotel", 3306);
     private Hospedagem hospedagemVO;
    
    public HospedagemDAO(Banco banco) {
        this.banco = banco;
    }

    public HospedagemDAO() {
        
    }


 
    public boolean cadastrar(Object obj) {
        
        //Verifica se o objeto passado é do tipo Hospedagem
        if (obj instanceof Hospedagem) {
            hospedagemVO = (Hospedagem) obj; //converte de Object para Hospedagem
        } else {
            return false;
        }

        String sql = "INSERT INTO hospedagem (codHospedagem, nomeHospede, dataEntrada, dataSaida, hora )"
                + " VALUES (?, ?, ?, ?, ? )";

        try {
            //Abre a conexao com o banco
            getBanco().abrir();
            PreparedStatement stm = getBanco().getConexao().prepareStatement(sql);
            
        //Concatenação de Strings.
            stm.setInt(1, hospedagemVO.getCodHospedagem());
            stm.setString (2, hospedagemVO.getNomeHospede());
            stm.setString(3, hospedagemVO.getDataEntrada());
            stm.setString(4, hospedagemVO.getDataSaida());
            stm.setString(5, hospedagemVO.getHora());
            

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
         Hospedagem hospedagemVO;
        //Verifica se o objeto passado é do tipo Hospedagem
        if (obj instanceof Hospedagem) {
            hospedagemVO = (Hospedagem) obj; //converte de Object para Hospedagem
        } else {
            return false;
        }

        String sql = "UPDATE hospedagem SET dataEntrada = '" + hospedagemVO.getDataEntrada()
                + "', dataSaida = '" + hospedagemVO.getDataSaida()
                + "', hora = '" + hospedagemVO.getHora()
                + "' WHERE codHospedagem = '" + hospedagemVO.getCodHospedagem () + "'";
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
        Hospedagem hospedagemVO;
        //Verifica se o objeto passado é do tipo Hospedagem
        if (obj instanceof Hospedagem) {
            hospedagemVO = (Hospedagem) obj; //converte de Object para Hospedagem
        } else {
            return false;
        }

        String sql = "DELETE FROM hospedagem WHERE codHospedagem = " + hospedagemVO.getCodHospedagem();
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

       //Objeto de Retorno
        Hospedagem hospedagemVO = null;
        String sql = "SELECT * FROM hospedagem WHERE codHospedagem = " + pk;

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                System.out.println("Hóspedagem Encontrada!!!");
                hospedagemVO = new Hospedagem();
                hospedagemVO.setCodHospedagem(pk);
                hospedagemVO.setDataEntrada(rs.getString("dataEntrada"));
                hospedagemVO.setDataSaida(rs.getString("dataSaida"));
                hospedagemVO.setHora(rs.getString("hora"));
            }
            else
                System.out.println("Hospedagem Não Encontrada!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hospedagemVO;
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
