/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Servico;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Line
 */
public class ServicoDAO {
     private Banco banco;
    private Servico servicoVO;
    
    public ServicoDAO(Banco banco) {
        this.banco = banco;
    }


  
    public boolean cadastrar(Object obj) {
        
         if (obj instanceof Servico) {
            servicoVO = (Servico) obj;
        } else {
            return false;
        }
try {
            banco.abrir();
            //Incluindo um registro no servico
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "INSERT INTO servico (codServico, nomeServico, descricao, "
                    + "setor, valorUnitario, quantidade) VALUES ("
                    + servicoVO.getCodServico() + ", '"
                    + servicoVO.getNomeServico() + "', '"
                    + servicoVO.getDescricao() + "', '"
                    + servicoVO.getSetor() + "', "
                    + servicoVO.getValorUnitario() + ", "
                    + servicoVO.getQuantidade() + ") ";

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel cadastrar o servico: " + ex.getMessage());
            
            return false;
            
        }finally{
        banco.fechar();
        }

    }

    public boolean atualizar(Object obj) {
        if (obj instanceof Servico) {
            servicoVO = (Servico) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //atualizando registro da servico
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "UPDATE servico SET nomeServico = " + servicoVO.getNomeServico()
                    + ", descricao = " + servicoVO.getDescricao()
                    + ", setor = " + servicoVO.getSetor()
                    + ", valorUnitario = " + servicoVO.getValorUnitario()
                    + ", quantidade = " + servicoVO.getQuantidade()
                    + " WHERE codProduto = " + servicoVO.getCodServico();

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
            System.out.println("Nao foi possivel atualizar o registro do servico " + ex.getMessage());
            return false;
        }
    }

    public boolean deletar(Object obj) {
        if (obj instanceof Servico) {
            servicoVO = (Servico) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //deletando um registro do servico
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "DELETE FROM servico WHERE codServico = "
                    + servicoVO.getCodServico();


            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel deletar o registro do servico: " + ex.getMessage());
            return false;
        }finally{
            banco.fechar();
        }
    }
/**
 * Pesquisa o serviço no banco de dados e retorno um único serviço. Caso não encontre o serviço, ele retornará null.
 * @param pk
 * @return 
 */
    public Object buscar(int pk) {

        Vector servicos = new Vector(1);

        try {
            banco.abrir();
            //buscando registro do servico
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql = "SELECT * FROM servico WHERE codServico = "
                    + pk;

            //Lendo os dados
            rs = stm.executeQuery(sql);
            if (rs.next() == true) {
                //informar registro de servico
    
                servicos = (Vector) new ServicoDAO(banco).listar("codServico = " +
                        rs.getInt("codServico"));
    
                servicoVO = new Servico();
                servicoVO.setCodServico(rs.getInt("codServico"));
                servicoVO.setNomeServico(rs.getString("nomeServico"));
                servicoVO.setDescricao(rs.getString("descricao"));
                servicoVO.setSetor(rs.getString("setor"));
                servicoVO.setValorUnitario(rs.getDouble("valorUnitario"));
                servicoVO.setQuantidade(rs.getInt("quantidade"));
                
                return servicoVO;
            } else
                return null; //não achou o servico
        } catch (Exception ex) {
            System.out.println("Nao foi possviel realizar a busca pelo registro do servico: " + ex.getMessage());
            return null;
        } finally {
            banco.fechar();
        }
    
    }
    
    public List listar(String criterio) {
       
        try{
            banco.abrir();
            
            //Listando os registros de servico
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql;
            
            if (criterio.length() == 0){
                sql = "SELECT * FROM servico ";                
            }else {
                sql = "SELECT * FROM servico WHERE" + criterio;
            }
            //Lendo os dados
            rs = stm.executeQuery(sql);
            Vector lista = new Vector();
            
            while(rs.next() == true){
                Vector servicos = (Vector) new ServicoDAO(banco).listar("codServico = "
                        + rs.getInt("codServico")); 
                servicoVO.setCodServico (rs.getInt("codServico"));
                servicoVO.setNomeServico(rs.getString("nomeServico"));
                servicoVO.setDescricao(rs.getString ("descricao"));
                servicoVO.setSetor(rs.getString ("setor"));
                servicoVO.setValorUnitario(rs.getDouble("valorUnitario"));
                servicoVO.setQuantidade(rs.getInt("quantidade"));
                
                
                lista.addElement(servicoVO);   //Adiciona o servico na lista            
            }
            return lista;          
    }catch(Exception ex){
            System.out.println("Não foi possível completar a listagem de registro de servico: " + ex.getMessage());
            return null;
    }finally{
            banco.fechar();
        }
    }

    
}
