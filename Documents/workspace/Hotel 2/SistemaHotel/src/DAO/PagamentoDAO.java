/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Pagamento;
import java.util.Vector;

/**
 *
 * @author chris
 */
public class PagamentoDAO implements DAO {
    
    private Banco banco;
    private Pagamento pagamentoVO;
    
    public PagamentoDAO(Banco banco) {
        this.banco = banco;
    }


 
    public boolean cadastrar(Object obj) {
        
         if (obj instanceof Pagamento) {
           pagamentoVO = (Pagamento) obj;
        } else {
            return false;
        }
try {
            banco.abrir();
            //Incluindo um registro de pagamento
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "INSERT INTO Pagamento (codPagamento, formaPagamento, qtdParcela, valorParcelado "
                    + "valorTotal ) VALUES ("
                    
                    + pagamentoVO.getCodPagamento() + ", "
                    + pagamentoVO.getFormaPagamento() + ", "
                    + pagamentoVO.getQtdParcela() + ", "
                    + pagamentoVO.getValorParcelado() + ", "
                    + pagamentoVO.getValorTotal() + ")";

            

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel cadastrar o pagamento: " + ex.getMessage());
            return false;
        }

    }

    public boolean atualizar(Object obj) {
        if (obj instanceof Pagamento) {
            pagamentoVO = (Pagamento) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //atualizando um registro de pagamento 
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "UPDATE Pagamento SET formaPagamento = " + pagamentoVO.getFormaPagamento()
                    + ", qtdParcela = " + pagamentoVO.getQtdParcela()
                    + ", valorParcelado = " + pagamentoVO.getValorParcelado()
                    + ", valorTotal = " + pagamentoVO.getValorTotal()
                    + " WHERE codPagamento = " + pagamentoVO.getCodPagamento();

           
            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel atualizar o registro de pagamento: " + ex.getMessage());
            return false;
        }
    }

    public boolean deletar(Object obj) {
        if (obj instanceof Pagamento) {
            pagamentoVO = (Pagamento) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //deletando um registro de pagamento
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "DELETE FROM pagamento WHERE codPagamento = "
                    + pagamentoVO.getCodPagamento();

           
            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel deletar registro de pagamento: " + ex.getMessage());
            return false;
        }
    }

    public Object buscar(int pk) {

        Vector contas = new Vector(1);

        try {
            banco.abrir();
            //buscando registro no pagamento
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql = "SELECT * FROM pagamento WHERE codPagamento = "
                    + pk;

            //Lendo os dados
            rs = stm.executeQuery(sql);
            if (rs.next() == true) {
                
               
                pagamentoVO = new Pagamento();
                pagamentoVO.setCodPagamento(rs.getInt("codPagamento"));
                pagamentoVO.setFormaPagamento(rs.getString("formaPagamento"));
                pagamentoVO.setQtdParcela(rs.getInt("qtdParcela"));
                pagamentoVO.setValorParcelado(rs.getDouble("valorParcelado"));
                pagamentoVO.setValorTotal(rs.getDouble("valorTotal"));
                                
                return pagamentoVO;
            } else
                return null; //não achou pagamento

        } catch (Exception ex) {
            System.out.println("Nao foi possviel realizar a busca pelo pagamento: " + ex.getMessage());
            return null;
        } finally {
            banco.fechar();
        }
    }
}
