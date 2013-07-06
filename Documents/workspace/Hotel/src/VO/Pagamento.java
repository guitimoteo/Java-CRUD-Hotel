/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author chris
 */
public class Pagamento {
 //Criacao de atributos
    private int codPagamento;
    private String formaPagamento;
    private int qtdParcela;
    private double valorParcelado;
    private double valorTotal;
    
    //Construtor
    public Pagamento(){
        
    }
    
    public Pagamento(String formaPagamento, int qtdParcela, double valorParcelado, double valorTotal){
        setFormaPagamento (formaPagamento);
        setQtdParcela (qtdParcela);
        setValorParcelado (valorParcelado);
        setValorTotal (valorTotal);
        
    }
    
    public Pagamento(int codPagamento, String formaPagamento, int qtdParcela, double valorParcelado, double valorTotal){
        this(formaPagamento, qtdParcela, valorParcelado, valorTotal);
        setCodPagamento (codPagamento);
        
    }
    //Geter e Seter
    /**
     * @return the codPagamento
     */
    public int getCodPagamento() {
        return codPagamento;
    }

    /**
     * @param codPagamento the codPagamento to set
     */
    public void setCodPagamento(int codPagamento) {
        this.codPagamento = codPagamento;
    }

    /**
     * @return the formaPagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the qtdParcela
     */
    public int getQtdParcela() {
        return qtdParcela;
    }

    /**
     * @param qtdParcela the qtdParcela to set
     */
    public void setQtdParcela(int qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    /**
     * @return the valorParcelado
     */
    public double getValorParcelado() {
        return valorParcelado;
    }

    /**
     * @param valorParcelado the valorParcelado to set
     */
    public void setValorParcelado(double valorParcelado) {
        this.valorParcelado = valorParcelado;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    

}