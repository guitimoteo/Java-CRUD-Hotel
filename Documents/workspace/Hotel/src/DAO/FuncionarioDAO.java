/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Funcionario;
import banco.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Line
 */
public class FuncionarioDAO implements DAO {
    
    //Criação dos Atributos 
  
    private Banco banco = new Banco ("root", "", "localhost", "hotel", 3306);
    private Funcionario funcionarioVO;
    
     
    
    public FuncionarioDAO(Banco banco) {
        this.banco = banco;
    }

    public FuncionarioDAO() {
        
    }

   
    public boolean cadastrar(Object obj) {
        //Verifica se o objeto passado é do tipo Funcionário
        if (obj instanceof Funcionario) {
            funcionarioVO = (Funcionario) obj; //converte de Object para Funcionário
        } else {
            return false;
        }

        String sql = "INSERT INTO funcionario (codFuncionario, nome, cpf, dataNascimento, idade, sexo,"
                + "endereco, numero, complemento, cep, bairro, cidade, estado, uf, telefone, "
                + " cargo, setor, dataAdmissao, dataDemissao, salario, login, senha)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        try {
            //Abre a conexao com o banco
            getBanco().abrir();
            PreparedStatement stm = getBanco().getConexao().prepareStatement(sql);
            
        //Concatenação de Strings.
            stm.setInt(1, funcionarioVO.getCodFuncionario());
            stm.setString(2, funcionarioVO.getNome());
            stm.setString(3, funcionarioVO.getCpf());
            stm.setString(4, funcionarioVO.getDataNascimento());
            stm.setInt(5, funcionarioVO.getIdade());
            stm.setString(6, funcionarioVO.getSexo());
            stm.setString(7, funcionarioVO.getEndereco());
            stm.setInt(8, funcionarioVO.getNumero());
            stm.setString(9, funcionarioVO.getComplemento());
            stm.setString(10, funcionarioVO.getCep());
            stm.setString(11, funcionarioVO.getBairro());
            stm.setString(12, funcionarioVO.getCidade());
            stm.setString(13, funcionarioVO.getEstado());
            stm.setString(14, funcionarioVO.getUf());
            stm.setString(15, funcionarioVO.getTelefone());
            stm.setString(16, funcionarioVO.getCargo());
            stm.setString(17, funcionarioVO.getSetor());
            stm.setString(18, funcionarioVO.getDataAdmissao());
            stm.setString(19, funcionarioVO.getDataDemissao());
            stm.setDouble(20, funcionarioVO.getSalario());
            stm.setString(21, funcionarioVO.getLogin());
            stm.setString(22, funcionarioVO.getSenha());

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
        Funcionario funcionarioVO;
        //Verifica se o objeto passado é do tipo Funcionário
        if (obj instanceof Funcionario) {
            funcionarioVO = (Funcionario) obj; //converte de Object para Funcionário
        } else {
            return false;
        }

        String sql = "UPDATE funcionario SET nome = '" + funcionarioVO.getNome()
                + "', cpf = '" + funcionarioVO.getCpf()
                + "', dataNascimento = '" + funcionarioVO.getDataNascimento()
                + "', idade = '" + funcionarioVO.getIdade()
                + "', sexo = '" + funcionarioVO.getSexo()
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
                + "', Salario = '" + funcionarioVO.getSalario()
                + "', login = '" + funcionarioVO.getLogin()
                + "', senha = '" + funcionarioVO.getSenha()
                + "' WHERE codFuncionario = '" + funcionarioVO.getCodFuncionario() + "'";
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
        Funcionario funcionarioVO;
        //Verifica se o objeto passado é do tipo Funcionário
        if (obj instanceof Funcionario) {
            funcionarioVO = (Funcionario) obj; //converte de Object para Funcionário
        } else {
            return false;
        }

        String sql = "DELETE FROM funcionario WHERE codFuncionario = " + funcionarioVO.getCodFuncionario();
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
        Funcionario funcionarioVO = null;
        String sql = "SELECT * FROM funcionario WHERE codFuncionario = " + pk;

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou
                System.out.println("Funcionário Encontrado!!!");
                funcionarioVO = new Funcionario();
                funcionarioVO.setCodFuncionario(pk);
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
            }
            else
                System.out.println("Funcionário Não Encontrado!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return funcionarioVO;
        
    }
    
    public Object pesquisarCriterio(String criterio) {
        //Objeto de Retorno
        Funcionario funcionarioVO = null;
        String sql = "SELECT * FROM funcionario WHERE " + criterio;

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();
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
    
    //Metodo que autentifica o Login e senha para o sistema!!
     public boolean logar(String login, String senha) {
        boolean autenticado = false;
        Funcionario funcionarioVO = new Funcionario();
        funcionarioVO.setLogin(login);
        funcionarioVO.setSenha(senha);
        String sql = "select * from funcionario where login = '" + funcionarioVO.getLogin()
                + "' AND senha = '" + funcionarioVO.getSenha() + "'";

        //Abre conexao com o banco
        getBanco().abrir();
        try {
            Statement stm = getBanco().getConexao().createStatement();

            //Faz a leitura no banco
            ResultSet rs = stm.executeQuery(sql);
            //Verifica se achou
            if (rs.next() == true) { //Achou

                funcionarioVO = new Funcionario();
                funcionarioVO.setLogin(rs.getString("login"));
                funcionarioVO.setSenha(rs.getString("senha"));
                autenticado = true;

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return autenticado;
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
