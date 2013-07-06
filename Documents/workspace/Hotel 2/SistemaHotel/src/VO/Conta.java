/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Line
 */
public class Conta {
  //Criacao dos atributos
    private int codConta;
    private String prodConsumo;
    private String servConsumo;
    private int qtdProduto;
    private int qtdServico;
    private String dataEntrada;
    private String dataSaida;
    private double valorHospedagem;
    private double valorConsumo;
    private double valorTotal;
    
    //Construtor
    public Conta (){
        
    }
    
    public Conta (String prodConsumo, String servConsumo, int qtdProduto, int qtdServico, String dataEtrada, String dataSaida, double valorTotal, double valorConsumo, double valorHospedagem){
        setProdConsumo (prodConsumo);
        setServConsumo (servConsumo);
        setQtdProduto (qtdProduto);
        setDataEntrada (dataEntrada);
        setDataSaida (dataSaida);        
        setValorTotal (valorTotal);
        setValorConsumo (valorConsumo);
        setValorHospedagem (valorHospedagem);        
    }
    
   
public Conta (int codConta, String prodConsumo, String servConsumo, int qtdProduto, int qtdServico, String dataEntrada, String dataSaida, double valorHospedagem,double valorConsumo, double valorTotal){
        this(prodConsumo, servConsumo, qtdProduto, qtdServico, dataEntrada, dataSaida, valorHospedagem, valorConsumo, valorTotal);
        setCodConta (codConta);
    }
     
    //Metodo
    public double fecharConta(double valorHospedagem, double valorConsumo){
        valorTotal= valorHospedagem + valorConsumo;
        
        return valorTotal;
        
    }
    //Geter e Seter

    /**
     * @return the codConta
     */
    public int getCodConta() {
        return codConta;
    }

    /**
     * @param codConta the codConta to set
     */
    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }

    
    /**
     * @return the dataEntrada
     */
    public String getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param periodoHospedagem the periodoHospedagem to set
     */
    public void setDataEntrada( String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
    /**
     * @return the periodoHospedagem
     */
    public String getDataSaida() {
        return dataSaida;
    }

    /**
     * @param periodoHospedagem the periodoHospedagem to set
     */
    public void setDataSaida( String dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the valorHospedagem
     */
    public double getValorHospedagem() {
        return valorHospedagem;
    }

    /**
     * @param valorHospedagem the valorHospedagem to set
     */
    public void setValorHospedagem(double valorHospedagem) {
        this.valorHospedagem = valorHospedagem;
    }

    /**
     * @return the valorConsumo
     */
    public double getValorConsumo() {
        return valorConsumo;
    }

    /**
     * @param valorConsumo the valorConsumo to set
     */
    public void setValorConsumo(double valorConsumo) {
        this.valorConsumo = valorConsumo;
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

    /**
     * @return the prodConsumo
     */
    public String getProdConsumo() {
        return prodConsumo;
    }

    /**
     * @param prodConsumo the prodConsumo to set
     */
    public void setProdConsumo(String prodConsumo) {
        this.prodConsumo = prodConsumo;
    }

    /**
     * @return the servConsumo
     */
    public String getServConsumo() {
        return servConsumo;
    }

    /**
     * @param servConsumo the servConsumo to set
     */
    public void setServConsumo(String servConsumo) {
        this.servConsumo = servConsumo;
    }

    /**
     * @return the qtdProduto
     */
    public int getQtdProduto() {
        return qtdProduto;
    }

    /**
     * @param qtdProduto the qtdProduto to set
     */
    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    /**
     * @return the qtdConsumo
     */
    public int getQtdServico() {
        return qtdServico;
    }

    /**
     * @param qtdConsumo the qtdConsumo to set
     */
    public void setQtdServico(int qtdServico) {
        this.qtdServico = qtdServico;
    }
   
}

    