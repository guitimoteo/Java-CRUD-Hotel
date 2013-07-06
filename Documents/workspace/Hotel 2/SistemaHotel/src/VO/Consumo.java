/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author chris
 */
public class Consumo {
 //Criacao de atributos
    private int codConsumo;
    private double Valor;
    
    //Aqui ocorre a agregacao
    private Produto produto;
    private Servico servico;
    
    
    //Construtores
    public Consumo (){
        
    }
    
    
    //Pode ser consumido produtos e/ou servicos ou nenhum dos dois. (Aqui acontece a agregacao)
    public Consumo (int CodConsumo){
        setCodConsumo (codConsumo);
        setProduto (produto);
        setServico (servico);
    }
    
   
   
    
    //Metodos
    public void calcularConsumo(){
        
    }
    
    
    //Geter e Seter

    /**
     * @return the codConsumo
     */
    public int getCodConsumo() {
        return codConsumo;
    }

    /**
     * @param codConsumo the codConsumo to set
     */
    public void setCodConsumo(int codConsumo) {
        this.codConsumo = codConsumo;
    }
    
    /**
     * @return the Valor
     */
    public double getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    

   

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the servico
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    
    
    
}
