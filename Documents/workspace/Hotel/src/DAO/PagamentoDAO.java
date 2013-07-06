/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Pagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author chris
 */
public class PagamentoDAO implements DAO {
    
    private Banco banco = new Banco ("root", "", "localhost", "hotel", 3306);
    private Pagamento pagamentoVO;
    
    public PagamentoDAO(Banco banco) {
        this.banco = banco;
    }

    public PagamentoDAO() {
        
    }


 
    public boolean cadastrar(Object obj) {
        
        //Verifica se o objeto passado é do tipo Pagamento
        if (obj instanceof Pagamento) {
            pagamentoVO = (Pagamento) obj; //converte de Object para Pagamento
        } else {
            return false;
        }

        String sql = "INSERT INTO pagamento (codPagamento, formaPagamento, qtdParcela, valorParcelado, valorTotal)"
                + " VALUES (?, ?, ?, ?, ? )";

        try {
            //Abre a conexao com o banco
            getBanco().abrir();
            PreparedStatement stm = getBanco().getConexao().prepareStatement(sql);
            
        //Concatenação de Strings.
            stm.setInt(1, pagamentoVO.getCodPagamento());
            stm.setString(2, pagamentoVO.getFormaPagamento());
            stm.setInt(3, pagamentoVO.getQtdParcela());
            stm.setDouble(4, pagamentoVO.getValorParcelado());
            stm.setDouble(5, pagamentoVO.getValorTotal());
            

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
       Pagamento pagamentoVO;
        //Verifica se o objeto passado é do tipo Pagamento
        if (obj instanceof Pagamento) {
            pagamentoVO = (Pagamento) obj; //converte de Object para Pagamento
        } else {
            return false;
        }

        String sql = "UPDATE hospede SET formaPagamento = '" + pagamentoVO.getFormaPagamento()
                + "', formaPagamento = '" + pagamentoVO.getFormaPagamento()
                + "', qtdParcela = '" + pagamentoVO.getQtdParcela()
                + "', valorParcelado = '" + pagamentoVO.getValorParcelado()
                + "', valorTotal = '" + pagamentoVO.getValorTotal()
                + "' WHERE codPagamento = '" + pagamentoVO.getCodPagamento() + "'";
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
        Pagamento pagamentoVO;
        //Verifica se o objeto passado é do tipo Pagamento
        if (obj instanceof Pagamento) {
            pagamentoVO = (Pagamento) obj; //converte de Object para Pagamento
        } else {
            return false;
        }

        String sql = "DELETE FROM hospede WHERE codPagamento = " + pagamentoVO.getCodPagamento();
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


    public Object buscar(int pk ) {

        //Objeto de Retorno
        Pagamento pagamentoVO = null;
        String sql = "SELECT * FROM pagamento WHERE codPagamento = " + pk;
        
        

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                System.out.println("Pagamento Encontrado!!!");
                pagamentoVO = new Pagamento();
                pagamentoVO.setCodPagamento(pk);
                pagamentoVO.setFormaPagamento(rs.getString("formaPagamento"));
                pagamentoVO.setQtdParcela(rs.getInt("qtdParcela"));
                pagamentoVO.setValorParcelado(rs.getDouble("valorParcelado"));
                pagamentoVO.setValorTotal(rs.getDouble("valorTotal"));
            }
            else
                System.out.println("Pagamento Não Encontrado!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pagamentoVO;
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

