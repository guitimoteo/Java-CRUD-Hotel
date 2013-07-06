/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Quarto;
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
public class QuartoDAO {
    
    private Banco banco = new Banco ("root", "", "localhost", "hotel", 3306);
    private Quarto quartoVO = null;

    public QuartoDAO(Banco banco) {
        this.banco = banco;
    }

    public QuartoDAO() {
        
    }

    
    public boolean cadastrar(Object obj) {
       //Verifica se o objeto passado é do tipo Quarto
        if (obj instanceof Quarto) {
            quartoVO = (Quarto) obj; //converte de Object para Quarto
        } else {
            return false;
        }

        String sql = "INSERT INTO quarto (numero, tipo, localizacao, caracteristica, "
                + "qtdOcupado, qtdReservado, qtdVago, qtdTotal, preco)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            //Abre a conexao com o banco
            getBanco().abrir();
            PreparedStatement stm = getBanco().getConexao().prepareStatement(sql);
            
        //Concatenação de Strings.
            stm.setInt(1, quartoVO.getNumero());
            stm.setString(2, quartoVO.getTipo());
            stm.setString(3, quartoVO.getLocalizacao());
            stm.setString(4, quartoVO.getCaracteristica());
            stm.setInt(5, quartoVO.getQtdOcupado());
            stm.setInt(6, quartoVO.getQtdReservado());
            stm.setInt(7, quartoVO.getQtdVago());
            stm.setInt(8, quartoVO.getQtdTotal());
            stm.setDouble(9, quartoVO.getPreco());
            
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
        Quarto quartoVO;
        //Verifica se o objeto passado é do tipo Quarto
        if (obj instanceof Quarto) {
            quartoVO = (Quarto) obj; //converte de Object para Quarto
        } else {
            return false;
        }

        String sql = "UPDATE quarto SET tipo = '" + quartoVO.getTipo()
                + "', localizacao = '" + quartoVO.getLocalizacao()
                + "', caracteristica = '" + quartoVO.getCaracteristica()
                + "', qtdOcupado = '" + quartoVO.getQtdOcupado()
                + "', qtdReservado = '" + quartoVO.getQtdReservado()
                + "', qtdVago = '" + quartoVO.getQtdVago()
                + "', qtdTotal = '" + quartoVO.getQtdTotal()
                + "', preco = '" + quartoVO.getPreco()
                + "' WHERE Numero = '" + quartoVO.getNumero() + "'";
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
        Quarto quartoVO;
        //Verifica se o objeto passado é do tipo Quarto
        if (obj instanceof Quarto) {
            quartoVO = (Quarto) obj; //converte de Object para Quarto
        } else {
            return false;
        }

        String sql = "DELETE FROM quarto WHERE numero = " + quartoVO.getNumero();
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
        Quarto quartoVO = null;
        String sql = "SELECT * FROM quarto WHERE Numero = " + pk;

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                System.out.println("Quarto Encontrado!!!");
                quartoVO = new Quarto();
                quartoVO.setNumero(pk);
                quartoVO.setTipo(rs.getString("tipo"));
                quartoVO.setLocalizacao(rs.getString("localizacao"));
                quartoVO.setCaracteristica(rs.getString("caracteristica"));
                quartoVO.setQtdOcupado(rs.getInt("qtdOcupado"));
                quartoVO.setQtdReservado(rs.getInt("qtdReservado"));
                quartoVO.setQtdVago(rs.getInt("qtdVago"));
                quartoVO.setQtdTotal(rs.getInt("qtdTotal"));
                quartoVO.setPreco(rs.getDouble("preco"));
            }
            else
                System.out.println("Quarto Não Encontrado!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return quartoVO;
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
       
    

    


