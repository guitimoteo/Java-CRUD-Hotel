/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Hospede;
import banco.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Line
 */
public class HospedeDAO implements DAO {
    
    //Criação dos Atributos 
    private Banco banco;
    private Hospede hospedeVO;
    
    public HospedeDAO(Banco banco) {
        this.banco = banco;
    }

    
    public boolean cadastrar(Object obj) {
        
        //Verifica se o objeto passado é do tipo SecretariaVO
        if (obj instanceof Hospede) {
            hospedeVO = (Hospede) obj; //converte de Object para SecretariaVO
        } else {
            return false;
        }

        String sql = "INSERT INTO hospede (codHospede, nome, cpf, dataNascimento, idade, sexo,"
                + "endereco, numero, complemento, cep, bairro, cidade, estado, uf, telefone, email)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        try {
            //Abre a conexao com o banco
            banco.abrir();
            PreparedStatement stm = banco.getConexao().prepareStatement(sql);
            
//Concatenação de Strings.
            stm.setInt(1, hospedeVO.getCodHospede());
            stm.setString(2, hospedeVO.getNome());
            stm.setString(3, hospedeVO.getCpf());
            stm.setString(4, hospedeVO.getDataNascimento());
            stm.setInt(5, hospedeVO.getIdade());
            stm.setString(6, hospedeVO.getSexo());
            stm.setString(7, hospedeVO.getEndereco());
            stm.setInt(8, hospedeVO.getNumero());
            stm.setString(9, hospedeVO.getComplemento());
            stm.setString(10, hospedeVO.getCep());
            stm.setString(11, hospedeVO.getBairro());
            stm.setString(12, hospedeVO.getCidade());
            stm.setString(13, hospedeVO.getEstado());
            stm.setString(14, hospedeVO.getUf());
            stm.setString(15, hospedeVO.getTelefone());
            stm.setString(16, hospedeVO.getEmail());

            if (stm.executeUpdate() > 0) {
                banco.fechar();
                return true;
            } else {
                banco.fechar();
                return false;
            }
        } catch (SQLException ex) {
            banco.fechar();
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public boolean atualizar(Object obj) {
        
     Hospede hospedeVO;
        //Verifica se o objeto passado é do tipo SecretariaVO
        if (obj instanceof Hospede) {
            hospedeVO = (Hospede) obj; //converte de Object para SecretariaVO
        } else {
            return false;
        }

        String sql = "UPDATE hospede SET nome = '" + hospedeVO.getNome()
                + "', cpf = '" + hospedeVO.getCpf()
                + "', dataNascimento = '" + hospedeVO.getDataNascimento()
                + "', idade = '" + hospedeVO.getIdade()
                + "', sexo = '" + hospedeVO.getSexo()
                + "', endereco = '" + hospedeVO.getEndereco()
                + "', numero = '" + hospedeVO.getNumero()
                + "', complemento = '" + hospedeVO.getComplemento()
                + "', cep = '" + hospedeVO.getCep()
                + "', bairro = '" + hospedeVO.getBairro()
                + "', cidade = '" + hospedeVO.getCidade()
                + "', estado = '" + hospedeVO.getEstado()
                + "', uf = '" + hospedeVO.getUf()
                + "', telefone = '" + hospedeVO.getTelefone()
                + "', email = '" + hospedeVO.getEmail()
                + "' WHERE codHospede = '" + hospedeVO.getCodHospede() + "'";
        try {
            //Abre a conexao com o banco
            banco.abrir();
            Statement stm = banco.getConexao().createStatement();
            if (stm.executeUpdate(sql) > 0) {
                banco.fechar();
                return true;
            } else {
                banco.fechar();
                return false;
            }
        } catch (SQLException ex) {
            banco.fechar();
            ex.printStackTrace();
            return false;
        }

    }
   
         
    public boolean deletar(Object obj) {
        
    Hospede hospedeVO;
        //Verifica se o objeto passado é do tipo SecretariaVO
        if (obj instanceof Hospede) {
            hospedeVO = (Hospede) obj; //converte de Object para SecretariaVO
        } else {
            return false;
        }

        String sql = "DELETE FROM hospede WHERE codHospede = " + hospedeVO.getCodHospede();
        try {
            //Abre a conexao com o banco
            banco.abrir();
            Statement stm = banco.getConexao().createStatement();
            if (stm.executeUpdate(sql) > 0) {
                banco.fechar();
                return true;
            } else {
                banco.fechar();
                return false;
            }
        } catch (SQLException ex) {
            banco.fechar();
            ex.printStackTrace();
            return false;
        }      
        
    }

    
    public Object buscar(int pk) {
      
        //Objeto de Retorno
        Hospede hospedeVO = null;
        String sql = "SELECT * FROM hospede WHERE codHospede = " + pk;

        //Abre conexao com o banco
        banco.abrir();
        try {
            Statement stm = banco.getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                System.out.println("Hóspede Encontrado!!!");
                hospedeVO = new Hospede();
                hospedeVO.setCodHospede(pk);
                hospedeVO.setNome(rs.getString("nome"));
                hospedeVO.setCpf(rs.getString("cpf"));
                hospedeVO.setDataNascimento(rs.getString("dataNascimento"));
                hospedeVO.setIdade(rs.getInt("idade"));
                hospedeVO.setSexo(rs.getString("sexo"));
                hospedeVO.setEndereco(rs.getString("endereco"));
                hospedeVO.setNumero(rs.getInt("numero"));
                hospedeVO.setComplemento(rs.getString("complemento"));
                hospedeVO.setCep(rs.getString("cep"));
                hospedeVO.setBairro(rs.getString("bairro"));
                hospedeVO.setCidade(rs.getString("cidade"));
                hospedeVO.setEstado(rs.getString("estado"));
                hospedeVO.setUf(rs.getString("uf"));
                hospedeVO.setTelefone(rs.getString("telefone"));
                hospedeVO.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hospedeVO;
    }
    
    public Object pesquisarCpf(String criterio) {
        //Objeto de Retorno
        Hospede hospedeVO = null;
        String sql = "SELECT * FROM hospede WHERE " + criterio;

        //Abre conexao com o banco
        banco.abrir();
        try {
            Statement stm = banco.getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                hospedeVO = new Hospede();
                hospedeVO.setCodHospede(rs.getInt("codHospede"));
                hospedeVO.setNome(rs.getString("nome"));
                hospedeVO.setCpf(rs.getString("cpf"));
                hospedeVO.setDataNascimento(rs.getString("dataNascimento"));
                hospedeVO.setIdade(rs.getInt("idade"));
                hospedeVO.setSexo(rs.getString("sexo"));
                hospedeVO.setEndereco(rs.getString("endereco"));
                hospedeVO.setNumero(rs.getInt("numero"));
                hospedeVO.setComplemento(rs.getString("complemento"));
                hospedeVO.setCep(rs.getString("cep"));
                hospedeVO.setBairro(rs.getString("bairro"));
                hospedeVO.setCidade(rs.getString("cidade"));
                hospedeVO.setEstado(rs.getString("estado"));
                hospedeVO.setUf(rs.getString("uf"));
                hospedeVO.setTelefone(rs.getString("telefone"));
                hospedeVO.setEmail(rs.getString("email"));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hospedeVO;
    
        
    }   
}
    

