/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Produto;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Line
 */
public class ProdutoDAO implements DAO{

    private Banco banco;
    private Produto produtoVO;
    
    public ProdutoDAO(Banco banco) {
        this.banco = banco;
    }


    @Override
    public boolean cadastrar(Object obj) {
        
         if (obj instanceof Produto) {
            produtoVO = (Produto) obj;
        } else {
            return false;
        }
try {
            banco.abrir();
            //Incluindo um registro no produto
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "INSERT INTO produto (codProduto, nomeProduto, quantidade, "
                    + "qtdestoque, valorUnitario) VALUES ("
                    + produtoVO.getCodProduto() + ", '"
                    + produtoVO.getNomeProduto() + "', "
                    + produtoVO.getQuantidade() + ", "
                    + produtoVO.getEstoque() + ", "
                    + produtoVO.getValorUnitario() + ")";

            //Faz a atualizacao na tabela Eixo
 //           EixoDAO eixoDAO = new EixoDAO(banco);;;
 //           Eixo eixoVO;
 //           for(int x=0; x < chassiVO.getEixos().size(); x++) {
 //               eixoVO = (Eixo)chassiVOo.getEixos().get(x);
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
            System.out.println("Nao foi possivel cadastrar o produto: " + ex.getMessage());
            return false;
        }

    }

    public boolean atualizar(Object obj) {
        if (obj instanceof Produto) {
            produtoVO = (Produto) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //atualizando registro do produto
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "UPDATE produto SET nomeProduto = " + produtoVO.getNomeProduto()
                    + ", quantidade = " + produtoVO.getQuantidade()
                    + ", estoque = " + produtoVO.getEstoque()
                    + ", valorUnitario = " + produtoVO.getValorUnitario()
                    + " WHERE codProduto = " + produtoVO.getCodProduto();

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
            System.out.println("Nao foi possivel atualizar registro do produto " + ex.getMessage());
            return false;
        }
    }

    public boolean deletar(Object obj) {
        if (obj instanceof Produto) {
            produtoVO = (Produto) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //deletando um registro do produto
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "DELETE FROM produto WHERE codProduto = "
                    + produtoVO.getCodProduto();

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
            System.out.println("Nao foi possivel deletar regsitro do produto: " + ex.getMessage());
            return false;
        }
    }

    public Object buscar(int pk) {

        Vector produtos = new Vector(1);

        try {
            banco.abrir();
            //buscando registro do produto
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql = "SELECT * FROM produto WHERE codProduto = "
                    + pk;

            //Lendo os dados
            rs = stm.executeQuery(sql);
            if (rs.next() == true) {
                //informar registro de produto
    
    produtos = (Vector) new ProdutoDAO(banco).listar("codProduto = " +
                        rs.getInt("codProduto"));
    
                produtoVO = new Produto();
                produtoVO.setCodProduto(rs.getInt("codProduto"));
                produtoVO.setNomeProduto(rs.getString("nomeProduto"));
                produtoVO.setQuantidade(rs.getInt("quantidade"));
                produtoVO.setEstoque(rs.getInt("estoque"));
                produtoVO.setValorUnitario(rs.getDouble("valorUnitario"));
                
                return produtoVO;
            } else
                return null; //não achou produto

        } catch (Exception ex) {
            System.out.println("Nao foi possviel realizar a busca pelo produto: " + ex.getMessage());
            return null;
        } finally {
            banco.fechar();
        }
    
    }
    
    public List listar(String criterio) {
       
        try{
            banco.abrir();
            
            //Listando os registros de produto
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql;
            
            if (criterio.length() == 0){
                sql = "SELECT * FROM produto ";                
            }else {
                sql = "SELECT * FROM produto WHERE" + criterio;
            }
            //Lendo os dados
            rs = stm.executeQuery(sql);
            Vector lista = new Vector();
            
            while(rs.next() == true){
                Vector produtos = (Vector) new ProdutoDAO(banco).listar("codProduto = "
                        + rs.getInt("codProduto")); 
                produtoVO.setCodProduto(rs.getInt("codProduto"));
                produtoVO.setNomeProduto(rs.getString("nomeProduto"));
                produtoVO.setQuantidade(rs.getInt("quantidade"));
                produtoVO.setEstoque(rs.getInt("estoque"));
                produtoVO.setValorUnitario(rs.getDouble("valorUnitario"));
                
                
                lista.addElement(produtoVO);   //adiciona o produto na Lista       
            }
            return lista;          
    }catch(Exception ex){
            System.out.println("Não foi possível completar a listagem de registro de produto: " + ex.getMessage());
            return null;
    }finally{
            banco.fechar();
        }
    }

}
