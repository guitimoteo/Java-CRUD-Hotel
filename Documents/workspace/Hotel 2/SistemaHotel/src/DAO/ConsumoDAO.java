/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Consumo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Line
 */
public class ConsumoDAO {
    private Banco banco;
    private Consumo consumoVO;
    
    public ConsumoDAO(Banco banco) {
        this.banco = banco;
    }

   


  
    public boolean cadastrar(Object obj) {
        
         if (obj instanceof Consumo) {
            consumoVO = (Consumo) obj;
        } else {
            return false;
        }
try {
            banco.abrir();
            //Incluindo um registro de produto ou servico no consumo
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "INSERT INTO consumo (codConsumo) VALUES ("
                    + consumoVO.getCodConsumo() + ", ";
            
            /**
             * String sql = "INSERT INTO secretaria (nome, cpf, usuario, senha, salario)"
                + " VALUES (?, ?, ?, ?, ?)";

        try {
            //Abre a conexao com o banco
            banco.abrir();
            PreparedStatement stm = banco.getConexao().prepareStatement(sql);
            
//Concatenação de Strings.
            stm.setString(1, secretariaVO.getNome());
            stm.setString(2, secretariaVO.getCpf());
            stm.setString(3, secretariaVO.getUsuario());
            stm.setString(4, secretariaVO.getSenha());
            stm.setFloat(5, secretariaVO.getSalario());
             */
                   

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
            System.out.println("Nao foi possivel cadastrar o consumo realizado pelo hospede: " + ex.getMessage());
            return false;
        }

    }

    public boolean atualizar(Object obj) {
        if (obj instanceof Consumo) {
            consumoVO = (Consumo) obj;
        } else {
            return false;
        }
/**
 * //Concatenação de String
        String sql = "UPDATE secretaria SET nome = '" + secretariaVO.getNome()
                + "', cpf = '" + secretariaVO.getCpf()
                + "', usuario = '" + secretariaVO.getUsuario()
                + "', senha = '" + secretariaVO.getSenha()
                + "', salario = '" + secretariaVO.getSalario()
                + "' WHERE cpf = '" + secretariaVO.getCpf() + "'";
 */
        try {
            banco.abrir();
            //atualizando registro do produto
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "UPDATE consumo SET codConsumo = " + consumoVO.getCodConsumo();

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel atualizar registro dos produtos, servicos consumidos: " + ex.getMessage());
            return false;
        }
    }

    public boolean deletar(Object obj) {
        if (obj instanceof Consumo) {
            consumoVO = (Consumo) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //deletando um registro do produto
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "DELETE FROM conta WHERE codConsumo = "
                    + consumoVO.getCodConsumo();

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel deletar registro de produto, servicos consumidos: " + ex.getMessage());
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
            String sql = "SELECT * FROM consumo WHERE codConsumo = "
                    + pk;
            
            /**
             * //Abre conexao com o banco
        banco.abrir();
        try {
            Statement stm = banco.getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                secretariaVO = new SecretariaVO();
                secretariaVO.setCodigo(pk);
                secretariaVO.setNome(rs.getString("nome"));
                secretariaVO.setCpf(rs.getString("cpf"));
                secretariaVO.setUsuario(rs.getString("usuario"));
                secretariaVO.setSenha(rs.getString("senha"));
                secretariaVO.setSalario(rs.getFloat("salario"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return secretariaVO;
    }
             */

            //Lendo os dados
            rs = stm.executeQuery(sql);
            if (rs.next() == true) {
                //informar registro de produto
                
    
    produtos = (Vector) new ProdutoDAO(banco).listar("codConsumo = " +
                        rs.getInt("codConsumo"));
    
                consumoVO = new Consumo();
                consumoVO.setCodConsumo(rs.getInt("codConsumo"));
                
                
                return consumoVO;
            } else
                return null; //não achou registro de consumo

        } catch (Exception ex) {
            System.out.println("Nao foi possviel realizar a busca pelo consumo: " + ex.getMessage());
            return null;
        } finally {
            banco.fechar();
        }
    
    }
}
