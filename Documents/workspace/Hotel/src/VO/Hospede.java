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
public class Hospede extends Pessoa {
    
    //Criação dos Atributos
    private int codHospede;
    private String email;

   public Hospede() {
        
    }
   
   public Hospede (String nome, String cpf, String dataNascimento, int idade, String sexo,
                  String endereco, int numero, String complemento, String cep, String bairro,
                  String cidade, String estado, String uf, String telefone, String email){
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
       setEmail (email); 
   
   }
   
   
   public Hospede (int codHospede, String nome, String cpf, String dataNascimento, int idade, String sexo,
                  String endereco, int numero, String complemento, String cep, String bairro,
                  String cidade, String estado, String uf, String telefone, String email){
         this (nome, cpf, dataNascimento, idade, sexo, endereco, numero, complemento, cep, bairro, cidade, estado, uf, telefone, email);
         setCodHospede (codHospede);
   }
   
   
   //Getters e Setters
   
   
    /**
     * @return the codHospede
     */
    public int getCodHospede() {
        return codHospede;
    }

    /**
     * @param codHospede the codHospede to set
     */
    public void setCodHospede(int codHospede) {
        this.codHospede = codHospede;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
