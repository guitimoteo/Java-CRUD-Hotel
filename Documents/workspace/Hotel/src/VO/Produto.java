/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author chris
 */
public class Produto {
  //Criacao dos atributos
    private int codProduto;
    private String nomeProduto;
    private  int quantidade;
    private int estoque;
    private double valorUnitario;
    private double ValorProdConsumido;
    
    

    //Construtores
    
    
    
    public Produto() {
       
    }
    
    public Produto(String nomeProduto, int quantidade, int estoque, double valorUnitario){
        setNomeProduto (nomeProduto);
        setQuantidade (quantidade);
        setEstoque (estoque);
        setValorUnitario (valorUnitario);
    }
    
    public Produto (int CodProduto, String nomeProduto, int quantidade, int estoque, double valorUnitario){
        this(nomeProduto, quantidade, estoque, valorUnitario);
        setCodProduto (codProduto);
       
    }
    
    //Criação dos Métodos
    public void ControlarEstoque(){
        
        
    }
    
   
    //Geter e Seter

    
    /**
     * @return the codProduto
     */
    public int getCodProduto() {
        return codProduto;
    }

    /**
     * @param codProduto the codProduto to set
     */
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }
    
    

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the ValorProdConsumido
     */
    public double getValorProdConsumido() {
        return ValorProdConsumido;
    }

    /**
     * @param ValorProdConsumido the ValorProdConsumido to set
     */
    public void setValorProdConsumido(double ValorProdConsumido) {
        this.ValorProdConsumido = ValorProdConsumido;
    }

    
    
}
