
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import DAO.FuncionarioDAO;
import DAO.HospedagemDAO;
import DAO.HospedeDAO;
import DAO.ProdutoDAO;
import DAO.QuartoDAO;
import DAO.ServicoDAO;
import GUI.ControlerConta;
import GUI.ControlerFuncionario;
import GUI.ControlerHospedagem;
import GUI.ControlerHospede;
import GUI.ControlerPagamento;
import GUI.ControlerProduto;
import GUI.ControlerQuarto;
import GUI.ControlerReserva;
import GUI.ControlerServico;
import GUI.PrimeiraTela;
import VO.Funcionario;
import VO.Hospedagem;
import VO.Hospede;
import VO.Produto;
import VO.Quarto;
import VO.Servico;
import banco.Banco;
import java.sql.Connection;






/**
 *
 * @author Line
 */
public class TestaHotel {
    //Criação de atributos 
    private Connection connection;
  
   
    
    public static void main(String[] args) {
        Banco banco = new Banco ("root", "", "localhost", "hotel", 3306);
        banco.abrir();
        
    
      //Para rodar o sistema pelo formulario ao inves do Testa.
    new ControlerFuncionario().setVisible(true);
      //new PrimeiraTela().setVisible(true);  
     /**   
       HospedeDAO hospedeDAO = new HospedeDAO(banco);
       Hospede hospede1 = new Hospede();
       
       
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
             
        hospede1.setCodHospede(11);
        hospede1.setNome("Edvaldo Gravena");
        hospede1.setCpf("024.196.865.45");
        hospede1.setDataNascimento("19/02/1980");
        hospede1.setIdade(33);
        hospede1.setSexo("mas");
        hospede1.setEndereco("Rua: Bela Vista");
        hospede1.setNumero(123);
        hospede1.setComplemento("D");
        hospede1.setCep("05680-710");
        hospede1.setBairro("Pq Pequeno Céu");
        hospede1.setCidade("Interlagos");
        hospede1.setEstado("São Paulo");
        hospede1.setUf("SP");
        hospede1.setTelefone("4657-7894");
        hospede1.setEmail("edgravena@gmail.com");
        
        hospedeDAO.cadastrar(hospede1);
         
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(banco);
        Funcionario funcionario1 = new Funcionario();
       
        funcionario1.setCodFuncionario(1);
        funcionario1.setNome("Carlos Eduardo Souza");
        funcionario1.setCpf("918.873.808.98");
        funcionario1.setDataNascimento("02/11/1983");
        funcionario1.setIdade(30);
        funcionario1.setSexo("masc");
        funcionario1.setEndereco("Avenida: Bell Aliance");
        funcionario1.setNumero(3460);
        funcionario1.setComplemento("apartamento 102");
        funcionario1.setCep("09581-420");
        funcionario1.setBairro("Jd. São Caetano");
        funcionario1.setCidade("São Caetano do Sul");
        funcionario1.setEstado("São Paulo");
        funcionario1.setUf("SP");
        funcionario1.setTelefone(" 4232-9558");
        funcionario1.setCargo("gerente");
        funcionario1.setSetor ("rh");
        funcionario1.setDataAdmissao("10/07/2009");
        funcionario1.setDataDemissao("null");
        funcionario1.setSalario(3.500);
        funcionario1.setLogin("CarlosEduSouza");
        funcionario1.setSenha("1234");
        
        funcionario1.setCodFuncionario(2);
        funcionario1.setNome("Renata Cristina Cruz");
        funcionario1.setCpf("789.843.758.83");
        funcionario1.setDataNascimento("22/07/1989");
        funcionario1.setIdade(24);
        funcionario1.setSexo("fem");
        funcionario1.setEndereco("Avenida: Pereira Barreto");
        funcionario1.setNumero(3460);
        funcionario1.setComplemento("B");
        funcionario1.setCep("9620-380");
        funcionario1.setBairro("Jardim");
        funcionario1.setCidade("São Bernardo do Campo");
        funcionario1.setEstado("São Paulo");
        funcionario1.setUf("SP");
        funcionario1.setTelefone("4476-2059");
       
        funcionario1.setCargo("recepcionista");
        funcionario1.setSetor ("recepção");
        funcionario1.setDataAdmissao("27/10/2011");
        funcionario1.setDataDemissao("null");
        funcionario1.setSalario(1.210);
        funcionario1.setLogin("RenataCruz");
        funcionario1.setSenha("abc2012");
        
       funcionarioDAO.buscar(2);
   
        ProdutoDAO produtoDAO = new ProdutoDAO(banco);
        Produto produto1 = new Produto();
        
        produto1.setCodProduto(1);
        produto1.setConsumo ();
        produto1.setNomeProduto("refrigerante Coca-cola lata 350 ml");
        produto1.setQuantidade(3);
        produto1.setEstoque(560);
        produto1.setValorUnitario(3.50);
        produto1.setValorProdConsumido(10.50);
        
        produtoDAO.cadastrar (produto1);
        
       
        ServicoDAO servicoDAO = new ServicoDAO(banco);
        Servico servico1 = new Servico();
        
        servico1.setCodServico(1);
        servico1.setNomeServico("lavar roupa");
        servico1.setDescricao("Lava e passa quaisquer peças e tipo de tecidos");
        servico1.setItem("camisa manga longa social");
        servico1.setSetor("lavanderia");
        servico1.setQuantidade(3);
        servico1.setValorUnitario(7.90);
        servico1.setValorServico(23.70);
        
        servicoDAO.cadastrar(servico1);
        
        * 
        HospedagemDAO hospedagemDAO = new HospedagemDAO(banco);
        HospedeDAO hospedeDAO = new HospedeDAO(banco);
        QuartoDAO quartoDAO = new QuartoDAO (banco);
         Hospedagem hospedagem1 = new Hospedagem();
        hospedagem1.setCodHospedagem(1);
        hospedagem1.setDataEntrada("15/06/2013");
        hospedagem1.setDataSaida("22/06/2013");
        hospedagem1.setHora("10:20");
        hospedagem1.setHospede();
        hospedagem1.setQuarto();
       
        
        hospedagemDAO.cadastrar(hospedagem1);
        * 
        * QuartoDAO quartoDAO = new QuartoDAO(banco);
        Quarto quarto1 = new Quarto();
        
        quarto1.setNumero(100);
        quarto1.setTipo("Stantard");
        quarto1.setLocalizacao("cobertura");
        quarto1.setCaracteristica("Possui frigobar, cama king size, tv led 42");
        quarto1.setQtdOcupado(20);
        quarto1.setQtdReservado(13);
        quarto1.setQtdVago(7);
        quarto1.setQtdTotal(50);
        quarto1.setPreco(120.00);
        
        quartoDAO.cadastrar(quarto1);
       
           
    
         */
 
    }  
         
}
            
        
        
    
                

