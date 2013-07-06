/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author chris
 */
public class Servico {
 //Criacao de atributos
    private int codServico;
    private String nomeServico;
    private String item;
    private String descricao;
    private String setor;
    private int quantidade;
    private double valorUnitario;
    private double valorServico;
    
    
   
    
    

    //Construtores
    
   
    
    public Servico() {
        
    }
    
    public Servico (String nomeServico, String descricao, String item, String setor, int quantidade, double valorUnitario, double valorServico ){
        setNomeServico (nomeServico);
        setDescricao (descricao);
        setItem (item);
        setSetor (setor);
        setQuantidade (quantidade);
        setValorUnitario (valorUnitario);
        setValorServico (valorServico);
        
        
    }
    
    public Servico (int CodServico, String nomeServico, String descricao, String item, String setor, int quantidade, double valorUnitario, double valorServico){
        this(nomeServico, descricao, item, setor, quantidade, valorUnitario, valorServico); 
        setCodServico (codServico);
    }
    
     
    //Geter e seter

    /**
     * @return the codServico
     */
    public int getCodServico() {
        return codServico;
    }

    /**
     * @param codServico the codServico to set
     */
    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }
    
    
    /**
     * @return the nomeServico
     */
    public String getNomeServico() {
        return nomeServico;
    }

    /**
     * @param nomeServico the nomeServico to set
     */
    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }
    
     /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param codServico the codServico to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
     * @return the valorServico
     */
    public double getValorServico() {
        return valorServico;
    }

    /**
     * @param valorServico the valorServico to set
     */
    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    
    

   
     
}
