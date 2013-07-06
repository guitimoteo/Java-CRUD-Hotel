/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Funcionario;
import banco.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Line
 */
public class FuncionarioDAO implements DAO {
    
    //Criação dos Atributos 
    private Banco banco;
    private Funcionario funcionarioVO;
    
    public FuncionarioDAO(Banco banco) {
        this.banco = banco;
    }

   
    public boolean cadastrar(Object obj) {
        if (obj instanceof Funcionario) {
           funcionarioVO = (Funcionario) obj;
        } else {
            return false;
        }
        try {
            banco.abrir();
            //Incluindo um cadastro de Funcionário
            /* `codHospede`, `nome`, `cpf`, `dataNascimento`, `idade`, `sexo`, `endereco`, `numero`, `complemento`, `cep`, `bairro`, `cidade`, `estado`, `uf`, `telefone`, `email`*/
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "INSERT INTO Funcionario (codFuncionario, nome, cpf, dataNascimento, idade, sexo, "
                    + " endereco, numero, complemento, cep, bairro, cidade, estado, uf, telefone, "
                    + "cargo, setor, dataAdmissao, dataDemissao, salario, login, senha ) VALUES ("
                    
                    + funcionarioVO.getCodFuncionario() + ", '"
                    + funcionarioVO.getNome() + "', '"
                    + funcionarioVO.getCpf() + "', '"
                    + funcionarioVO.getDataNascimento() + "', "
                    + funcionarioVO.getIdade() + ", '"
                    + funcionarioVO.getSexo() + "', '"
                    + funcionarioVO.getEndereco() + "', "
                    + funcionarioVO.getNumero() + ", '"
                    + funcionarioVO.getComplemento() + "', '"
                    + funcionarioVO.getCep() + "', '"
                    + funcionarioVO.getBairro() + "', '"
                    + funcionarioVO.getCidade() + "', '"
                    + funcionarioVO.getEstado() + "', '"
                    + funcionarioVO.getUf() + "', '"
                    + funcionarioVO.getTelefone() + "', '"
                    + funcionarioVO.getCargo() + "', '"
                    + funcionarioVO.getSetor() + "', '"
                    + funcionarioVO.getDataAdmissao() + "', '"
                    + funcionarioVO.getDataDemissao() + "', "
                    + funcionarioVO.getSalario() + ", '"
                    + funcionarioVO.getLogin() + "', '"
                    + funcionarioVO.getSenha() + "')";

            

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel cadastrar o funcionário: " + ex.getMessage());
            return false;
        }

    }
    

    
    public boolean atualizar(Object obj) {
        if (obj instanceof Funcionario) {
            funcionarioVO = (Funcionario) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //atualizando um cadastro de Funcionário
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "UPDATE Funcionario SET nome = '" + funcionarioVO.getNome()
                    + "', cpf = '" + funcionarioVO.getCpf()
                    + "', dataNascimento = '" + funcionarioVO.getDataNascimento()
                    + "', Idade = " + funcionarioVO.getIdade()
                    + ", sexo = '" + funcionarioVO.getSexo()
                    + "', endereco = '" + funcionarioVO.getEndereco()
                    + "', numero = '" + funcionarioVO.getNumero()
                    + "', complemento = '" + funcionarioVO.getComplemento()
                    + "', cep = '" + funcionarioVO.getCep()
                    + "', bairro = '" + funcionarioVO.getBairro()
                    + "', cidade = '" + funcionarioVO.getCidade()
                    + "', estado = '" + funcionarioVO.getEstado()
                    + "', uf = '" + funcionarioVO.getUf()
                    + "', telefone = '" + funcionarioVO.getTelefone()
                    + "', cargo = '" + funcionarioVO.getCargo()
                    + "', setor = '" + funcionarioVO.getSetor()
                    + "', dataAdmissao = '" + funcionarioVO.getDataAdmissao()
                    + "', dataDemissao = '" + funcionarioVO.getDataDemissao()
                    + "', salario = " + funcionarioVO.getSalario()
                    + ", login = '" + funcionarioVO.getLogin()
                    + "', senha = '" + funcionarioVO.getSenha()
                    + "' WHERE codFuncionario = " + funcionarioVO.getCodFuncionario();

           
            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel atualizar o cadastro do funcionário: " + ex.getMessage());
            return false;
        }
    }
    

    
    public boolean deletar(Object obj) {
        if (obj instanceof Funcionario) {
            funcionarioVO = (Funcionario) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //deletando um cadasro de funcionário
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "DELETE FROM funcionario WHERE codFuncionario = "
                    + funcionarioVO.getCodFuncionario();
             

           
            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel deletar cadastro de funcionário: " + ex.getMessage());
            return false;
        }
    }
    

    
    public Object buscar(int pk) {
        try {
            banco.abrir();
            //buscando cadastro no funcionario
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql = "SELECT * FROM funcionario WHERE codFuncionario = "
                    + pk;

            //Lendo os dados
            rs = stm.executeQuery(sql);
            if (rs.next() == true) {
                
               
                funcionarioVO = new Funcionario();
                funcionarioVO.setCodFuncionario(rs.getInt("codFuncionario"));
                funcionarioVO.setNome(rs.getString("nome"));
                funcionarioVO.setCpf(rs.getString("cpf"));
                funcionarioVO.setDataNascimento(rs.getString("dataNascimento"));
                funcionarioVO.setIdade(rs.getInt("idade"));
                funcionarioVO.setSexo(rs.getString("sexo"));
                funcionarioVO.setEndereco(rs.getString("endereco"));
                funcionarioVO.setNumero(rs.getInt("numero"));
                funcionarioVO.setComplemento(rs.getString("complemento"));
                funcionarioVO.setCep(rs.getString("cep"));
                funcionarioVO.setBairro(rs.getString("bairro"));
                funcionarioVO.setCidade(rs.getString("cidade"));
                funcionarioVO.setEstado(rs.getString("estado"));
                funcionarioVO.setUf(rs.getString("uf"));
                funcionarioVO.setTelefone(rs.getString("telefone"));
                funcionarioVO.setCargo(rs.getString("cargo"));
                funcionarioVO.setSetor(rs.getString("setor"));
                funcionarioVO.setDataAdmissao(rs.getString("dataAdmissao"));
                funcionarioVO.setDataDemissao(rs.getString("dataDemissao"));
                funcionarioVO.setSalario(rs.getDouble("salario"));
                funcionarioVO.setLogin(rs.getString("login"));
                funcionarioVO.setSenha(rs.getString("senha"));
                
                                
                return funcionarioVO;
            } else
                return null; //não achou funcionário

        } catch (Exception ex) {
            System.out.println("Não foi possível realizar a busca pelo funcionário: " + ex.getMessage());
            return null;
        } finally {
            banco.fechar();
        }
    
    }
    
public Object pesquisarCriterio(String criterio) {
        //Objeto de Retorno
        Funcionario funcionarioVO = null;
        String sql = "SELECT * FROM funcionario WHERE " + criterio;

        //Abre conexao com o banco
        banco.abrir();
        try {
            Statement stm = banco.getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                funcionarioVO = new Funcionario();
                funcionarioVO.setCodFuncionario(rs.getInt("codFuncionario"));
                funcionarioVO.setNome(rs.getString("nome"));
                funcionarioVO.setCpf(rs.getString("cpf"));
                funcionarioVO.setDataNascimento(rs.getString("dataNascimento"));
                funcionarioVO.setIdade(rs.getInt("idade"));
                funcionarioVO.setSexo(rs.getString("sexo"));
                funcionarioVO.setEndereco(rs.getString("endereco"));
                funcionarioVO.setNumero(rs.getInt("numero"));
                funcionarioVO.setComplemento(rs.getString("complemento"));
                funcionarioVO.setCep(rs.getString("cep"));
                funcionarioVO.setBairro(rs.getString("bairro"));
                funcionarioVO.setCidade(rs.getString("cidade"));
                funcionarioVO.setEstado(rs.getString("estado"));
                funcionarioVO.setUf(rs.getString("uf"));
                funcionarioVO.setTelefone(rs.getString("telefone"));
                funcionarioVO.setCargo(rs.getString("cargo"));
                funcionarioVO.setSetor(rs.getString("setor"));
                funcionarioVO.setDataAdmissao(rs.getString("dataAdmissao"));
                funcionarioVO.setDataDemissao(rs.getString("dataDemissao"));
                funcionarioVO.setSalario(rs.getDouble("salario"));
                funcionarioVO.setLogin (rs.getString("login"));
                funcionarioVO.setSenha(rs.getString("senha"));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return funcionarioVO;
    }
}
