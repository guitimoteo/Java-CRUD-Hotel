/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import banco.Banco;
import VO.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Line
 */
public class ProdutoDAO implements DAO{

    private Banco banco = new Banco ("root", "", "localhost", "hotel", 3306);
    private Produto produtoVO;
    
    public ProdutoDAO(Banco banco) {
        this.banco = banco;
    }

    public ProdutoDAO() {
        
    }


    
    public boolean cadastrar(Object obj) {
        
        //Verifica se o objeto passado é do tipo Produto
        if (obj instanceof Produto) {
            produtoVO = (Produto) obj; //converte de Object para Produto
        } else {
            return false;
        }

        String sql = "INSERT INTO produto (codProduto, nomeProduto, quantidade,"
                + " estoque, valorUnitario,valorProdConsumido)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        try {
            //Abre a conexao com o banco
            getBanco().abrir();
            PreparedStatement stm = getBanco().getConexao().prepareStatement(sql);
            
            //Concatenação de Strings.
            stm.setInt(1, produtoVO.getCodProduto());
            stm.setString(2, produtoVO.getNomeProduto());
            stm.setInt(3, produtoVO.getQuantidade());
            stm.setInt(4, produtoVO.getEstoque());
            stm.setDouble(5, produtoVO.getValorUnitario());
            stm.setDouble(6, produtoVO.getValorProdConsumido());
            
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
        
     Produto produtoVO;
        //Verifica se o objeto passado é do tipo Produto
        if (obj instanceof Produto) {
            produtoVO = (Produto) obj; //converte de Object para Produto
        } else {
            return false;
        }

        String sql = "UPDATE produto SET nomeProduto = '" + produtoVO.getNomeProduto()
                + "', quantidade = '" + produtoVO.getQuantidade()
                + "', estoque = '" + produtoVO.getEstoque()
                + "', valorUnitario = '" + produtoVO.getValorUnitario()
                + "', valorProdConsumido = '" + produtoVO.getValorProdConsumido()
                + "' WHERE codProduto = '" + produtoVO.getCodProduto() + "'";
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
        
    Produto produtoVO;
        //Verifica se o objeto passado é do tipo Produto
        if (obj instanceof Produto) {
            produtoVO = (Produto) obj; //converte de Object para Produto
        } else {
            return false;
        }

        String sql = "DELETE FROM produto WHERE codProduto = " + produtoVO.getCodProduto();
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
        Produto produtoVO = null;
        String sql = "SELECT * FROM produto WHERE codProduto = " + pk;

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                System.out.println("Produto Encontrado!!!");
                produtoVO = new Produto();
                produtoVO.setCodProduto(pk);
                produtoVO.setNomeProduto(rs.getString("nomeProduto"));
                produtoVO.setQuantidade(rs.getInt("quantidade"));
                produtoVO.setEstoque(rs.getInt("estoque"));
                produtoVO.setValorUnitario(rs.getDouble("valorUnitario"));
                produtoVO.setValorProdConsumido(rs.getDouble("valorProdConsumido"));
            }
            else
                System.out.println("Produto Não Encontrado!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produtoVO;
    }
    
    public Object pesquisar(String criterio) {
        //Objeto de Retorno
        Produto produtoVO = null;
        String sql = "SELECT * FROM produto WHERE " + criterio;

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                produtoVO.setCodProduto(rs.getInt("codProduto"));
                produtoVO.setNomeProduto(rs.getString("nomeProduto"));
                produtoVO.setQuantidade(rs.getInt("quantidade"));
                produtoVO.setEstoque(rs.getInt("estoque"));
                produtoVO.setValorUnitario(rs.getDouble("valorUnitario"));
                produtoVO.setValorProdConsumido(rs.getDouble("valorProdConsumido"));
               
                           
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produtoVO;
    
        
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
