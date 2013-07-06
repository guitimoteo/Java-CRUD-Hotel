/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import banco.Banco;
import VO.Servico;
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
public class ServicoDAO {
    private Banco banco = new Banco ("root", "", "localhost", "hotel", 3306);
    private Servico servicoVO;
    
    public ServicoDAO(Banco banco) {
        this.banco = banco;
    }

    public ServicoDAO() {
        
    }


  
    public boolean cadastrar(Object obj) {
        
         //Verifica se o objeto passado é do tipo Servico
        if (obj instanceof Servico) {
            servicoVO = (Servico) obj; //converte de Object para Servico
        } else {
            return false;
        }

        String sql = "INSERT INTO servico (codServico, nomeServico, descricao, item, setor, quantidade,"
                + "valorUnitario, valorServico)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            //Abre a conexao com o banco
            getBanco().abrir();
            PreparedStatement stm = getBanco().getConexao().prepareStatement(sql);
            
            //Concatenação de Strings.
            stm.setInt(1, servicoVO.getCodServico());
            stm.setString(2, servicoVO.getNomeServico());
            stm.setString(3, servicoVO.getDescricao());
            stm.setString (4, servicoVO.getItem());
            stm.setString(5, servicoVO.getSetor());
            stm.setInt(6, servicoVO.getQuantidade());
            stm.setDouble(7, servicoVO.getValorUnitario());
            stm.setDouble(8, servicoVO.getValorServico());
           
            
           
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
        
     Servico servicoVO;
        //Verifica se o objeto passado é do tipo Servico
        if (obj instanceof Servico) {
            servicoVO = (Servico) obj; //converte de Object para Servico
        } else {
            return false;
        }

        String sql = "UPDATE servico SET nomeServico = '" + servicoVO.getNomeServico()
                + "', descricao = '" + servicoVO.getDescricao()
                + "', item = '" + servicoVO.getItem()                
                + "', setor = '" + servicoVO.getSetor()
                + "', quantidade = '" + servicoVO.getQuantidade()
                 + "', valorUnitario = '" + servicoVO.getValorUnitario()
                + "', valorServico = '" + servicoVO.getValorServico()
                + "' WHERE codServico = '" + servicoVO.getCodServico() + "'";
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
        
    Servico servicoVO;
        //Verifica se o objeto passado é do tipo Servico
        if (obj instanceof Servico) {
            servicoVO = (Servico) obj; //converte de Object para Servico
        } else {
            return false;
        }

        String sql = "DELETE FROM servico WHERE codServico = " + servicoVO.getCodServico();
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
        Servico servicoVO = null;
        String sql = "SELECT * FROM servico WHERE codServico = " + pk;

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                System.out.println("Servico Encontrado!!!");
                servicoVO = new Servico();
                servicoVO.setCodServico(pk);
                servicoVO.setNomeServico(rs.getString("nomeServico"));
                servicoVO.setDescricao(rs.getString("descricao"));
                servicoVO.setItem(rs.getString("item"));
                servicoVO.setSetor(rs.getString("setor"));
                servicoVO.setQuantidade(rs.getInt("quantidade"));
                servicoVO.setValorUnitario(rs.getDouble("valorUnitario"));
                servicoVO.setValorServico(rs.getDouble("valorServico"));            
            }
            else
                System.out.println("Serviço Não Encontrado!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return servicoVO;
    }
    
    public Object pesquisar(String criterio) {
        //Objeto de Retorno
        Servico servicoVO = null;
        String sql = "SELECT * FROM servico WHERE " + criterio;

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                servicoVO.setCodServico(rs.getInt("codServico"));
                servicoVO.setNomeServico(rs.getString("nomeServico"));
                servicoVO.setDescricao(rs.getString("descricao"));
                servicoVO.setItem(rs.getString("item"));
                servicoVO.setSetor(rs.getString("setor"));
                servicoVO.setQuantidade(rs.getInt("quantidade"));
                servicoVO.setValorUnitario(rs.getDouble("valorUnitario"));
                servicoVO.setValorServico(rs.getDouble("valorServico"));
                               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return servicoVO;
    
        
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