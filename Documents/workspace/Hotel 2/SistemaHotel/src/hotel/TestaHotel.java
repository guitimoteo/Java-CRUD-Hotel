
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import DAO.FuncionarioDAO;
import DAO.HospedeDAO;
import VO.Funcionario;
import VO.Hospedagem;
import VO.Hospede;
import banco.Banco;
import java.sql.Connection;






/**
 *
 * @author Line
 */
public class TestaHotel {
    private static Hospedagem hospedagem;
    //Criação de atributos 
    private Connection connection;
  
   
    
    public static void main(String[] args) {
        Banco banco = new Banco ("root", "", "localhost", "hotel", 3306);
        banco.abrir();
        
       




        
     //Para rodar o sistema pelo formulario ao inves do Testa.
      // new ControlerConsumo().setVisible(true);
        
        
       HospedeDAO hospedeDAO = new HospedeDAO(banco);
       Hospede hospede1 = new Hospede();
       Funcionario funcionario = new Funcionario();
       FuncionarioDAO funcionarioDAO = new FuncionarioDAO(banco);
       
        hospede1.setCodHospede(10);
        hospede1.setNome("Aline Soares");
        hospede1.setCpf("045.178.567.55");
        hospede1.setDataNascimento("25/02/1987");
        hospede1.setIdade(26);
        hospede1.setSexo("fem");
        hospede1.setEndereco("Rua: India");
        hospede1.setNumero(22);
        hospede1.setComplemento("A");
        hospede1.setCep("09280-210");
        hospede1.setBairro("Pq Oratório");
        hospede1.setCidade("Sto André");
        hospede1.setEstado("São Paulo");
        hospede1.setUf("SP");
        hospede1.setTelefone("4475-9807");
        hospede1.setEmail("alinepassoares@yahoo.com.br");
        
        
        funcionario.setCodFuncionario(11);
        funcionario.setNome("Aline Soares");
        funcionario.setCpf("045.178.567.55");
        funcionario.setDataNascimento("25/02/1987");
        funcionario.setIdade(26);
        funcionario.setSexo("fem");
        funcionario.setEndereco("Rua: India");
        funcionario.setNumero(22);
        funcionario.setComplemento("A");
        funcionario.setCep("09280-210");
        funcionario.setBairro("Pq Oratório");
        funcionario.setCidade("Sto André");
        funcionario.setEstado("São Paulo");
        funcionario.setUf("SP");
        funcionario.setTelefone("4475-9807");
        funcionario.setDataAdmissao("23/03/99");
        funcionario.setDataDemissao("23/03/99");
        funcionario.setCargo("Programadora");
        funcionario.setLogin("root");
        funcionario.setSenha("admin");
        funcionario.setSetor("TI");
        funcionario.setSalario(10000000000.00);
        
        //Cadastro com DAO
        hospedeDAO.cadastrar(hospede1);
        hospedeDAO.buscar(10);
        hospedagem = new Hospedagem();
        System.out.println(hospedagem.getDiferencaData("17/10/2009", "20/11/2009"));
        //funcionarioDAO.cadastrar(funcionario);
        funcionario.setNome("Aline Testa atualizar Soares");
        funcionarioDAO.atualizar(funcionario);
        System.out.println("Funcionário " + ((Funcionario)funcionarioDAO.buscar(11)).getNome());
        
        
        
    }
}
            
        
        
    
                

