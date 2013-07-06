/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Conta;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author chris
 */
public class ContaDAO implements DAO{
    
    private Banco banco = new Banco ("root", "", "localhost", "hotel", 3306);
    private Conta contaVO;
    
    public ContaDAO(Banco banco) {
        this.banco = banco;
    }

    public ContaDAO() {
        
    }


   
    public boolean cadastrar(Object obj) {
        
        //Verifica se o objeto passado é do tipo Conta
        if (obj instanceof Conta) {
            contaVO = (Conta) obj; //converte de Object para Conta
        } else {
            return false;
        }

        String sql = "INSERT INTO conta (codConta, prodConsumo, servConsumo, qtdProduto, qtdServico,"
                + "dataEntrada, dataSaida,  valorHospedagem, valorConsumo, valorTotal)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        try {
            //Abre a conexao com o banco
            getBanco().abrir();
            PreparedStatement stm = getBanco().getConexao().prepareStatement(sql);
            
        //Concatenação de Strings.
            stm.setInt(1, contaVO.getCodConta());
            stm.setString(2, contaVO.getProdConsumo());
            stm.setString(3, contaVO.getServConsumo());
            stm.setInt(4, contaVO.getQtdProduto());
            stm.setInt(5, contaVO.getQtdServico());
            stm.setString(6, contaVO.getDataEntrada());
            stm.setString(7, contaVO.getDataSaida());
            stm.setDouble(8, contaVO.getValorHospedagem());
            stm.setDouble(9, contaVO.getValorConsumo());
            stm.setDouble(10, contaVO.getValorTotal());
            

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
        
     Conta contaVO;
        //Verifica se o objeto passado �� do tipo Conta
        if (obj instanceof Conta) {
            contaVO = (Conta) obj; //converte de Object para Conta
        } else {
            return false;
        }

        String sql = "UPDATE conta SET prodConsumo = '" + contaVO.getProdConsumo()
                + "', servConsumo = '" + contaVO.getServConsumo()
                + "', qtdProduto = '" + contaVO.getQtdProduto()
                + "', qtdServico = '" + contaVO.getQtdServico()
                + "', dataEntrada = '" + contaVO.getDataEntrada()
                + "', dataSaida = '" + contaVO.getDataSaida()
                + "', valorHospedagem = '" + contaVO.getValorHospedagem()
                + "', valorConsumo = '" + contaVO.getValorConsumo()
                + "', valorTotal = '" + contaVO.getValorTotal()
                + "' WHERE codConta = '" + contaVO.getCodConta () + "'";
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
        Conta contaVO;
        //Verifica se o objeto passado �� do tipo Conta
        if (obj instanceof Conta) {
            contaVO = (Conta) obj; //converte de Object para Conta
        } else {
            return false;
        }

        String sql = "DELETE FROM conta WHERE codConta = " + contaVO.getCodConta();
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
        Conta contaVO = null;
        String sql = "SELECT * FROM conta WHERE codConta = " + pk;

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                System.out.println("Conta Encontrada!!!");
                contaVO = new Conta();
                contaVO.setCodConta(pk);
                contaVO.setProdConsumo(rs.getString("prodConsumo"));
                contaVO.setServConsumo(rs.getString("servConsumo"));
                contaVO.setQtdProduto(rs.getInt("qtdProduto"));
                contaVO.setQtdServico(rs.getInt("qtdServico"));
                contaVO.setDataEntrada(rs.getString("dataEntrada"));
                contaVO.setValorHospedagem(rs.getDouble("valorHospedagem"));
                contaVO.setValorConsumo(rs.getDouble("valorConsumo"));
                contaVO.setValorTotal(rs.getDouble("valorTotal"));
            }
            else 
                System.out.println("Conta N��o Encontrada!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return contaVO;
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
    
    

