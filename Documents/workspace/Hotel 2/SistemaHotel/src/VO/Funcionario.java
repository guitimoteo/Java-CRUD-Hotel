/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import Abstrata.Pessoa;

/**
 *
 * @author Line
 */
public class Funcionario extends Pessoa{
    
    //Criação dos Atributos 
    private int codFuncionario;
    private String cargo;
    private String setor;
    private String dataAdmissao;
    private String dataDemissao;
    private Double salario;
    private String login;
    private String senha;
    
    
    public Funcionario (){
        
    }
    
    public Funcionario (String nome, String cpf, String dataNascimento, int idade, String sexo,
                  String endereco, int numero, String complemento, String cep, String bairro,
                  String cidade, String estado, String uf, String telefone, String cargo,
                  String setor, String dataAdmissao, String dataDemissao, Double salario, String login, String senha){
       setNome (nome);
       setCpf (cpf);
       setDataNascimento (dataNascimento);
       setIdade (idade);
       setSexo (sexo);
       setEndereco (endereco);
       setNumero (numero);
       setComplemento (complemento);
       setCep (cep);
       setBairro (bairro);
       setCidade (cidade);
       setEstado (estado);
       setUf (uf);
       setTelefone (telefone);
       setCargo (cargo);
       setSetor (setor);
       setDataAdmissao (dataAdmissao);
       setDataDemissao (dataDemissao);
       setSalario (salario);
       setLogin (login);
       setSenha (senha);
    }
    
    public Funcionario (int codFuncionario, String nome, String cpf, String dataNascimento, int idade, String sexo,
                  String endereco, int numero, String complemento, String cep, String bairro,
                  String cidade, String estado, String uf, String telefone, String cargo,
                  String setor, String dataAdmissao, String dataDemissao, Double salario, String login, String senha ){
         this (nome, cpf, dataNascimento, idade, sexo, endereco, numero, complemento, cep, bairro, cidade, estado, uf, telefone, 
                 cargo, setor, dataAdmissao, dataDemissao, salario, login, senha);
         setCodFuncionario (codFuncionario);
   }
    
    
    //Getters e Setters

    /**
     * @return the codFuncionario
     */
    public int getCodFuncionario() {
        return codFuncionario;
    }

    /**
     * @param codFuncionario the codFuncionario to set
     */
    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * @return the dataAdmissao
     */
    public String getDataAdmissao() {
        return dataAdmissao;
    }

    /**
     * @param dataAdmissao the dataAdmissao to set
     */
    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    /**
     * @return the dataDemissao
     */
    public String getDataDemissao() {
        return dataDemissao;
    }

    /**
     * @param dataDemissao the dataDemissao to set
     */
    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    /**
     * @return the salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
