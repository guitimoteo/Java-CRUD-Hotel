/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.sql.Time;
import java.util.Vector;

/**
 *
 * @author chris
 */
public class Reserva {
 //Criacao dos atributos
    private int codReserva;
    private int qtdAcompanhante;
    private String dataEntrada;
    private String dataSaida;
    private String tipoQuarto;
    private Time horaReserva;
    private String situacao;
    private double taxaReserva;
    //Aqui mostra a composicao
    private Vector quartos = new Vector(1);
    
    
     
    //Construtores
    public Reserva(){
        
    }
    
    public Reserva(String situacao,String dataEntrada,String dataSaida,
            Time horaReserva, double taxaReserva, String tipoQuarto,
            int qtdAcompanhante){
        
        setSituacao (situacao);
        setDataEntrada (dataEntrada);
        setDataSaida (dataSaida);
        setHoraReserva (horaReserva);
        setTaxaReserva (taxaReserva);
        setTipoQuarto (tipoQuarto);
        setQtdAcompanhante (qtdAcompanhante);
               
    }
    
   public Reserva (int codReserva, String situacao, String dataEntrada,String dataSaida,
            Time horaReserva, double taxaReserva, String tipoQuarto, int qtdAcompanhante){
        this(situacao, dataEntrada, dataSaida, horaReserva, taxaReserva, tipoQuarto, qtdAcompanhante);
        setCodReserva (codReserva);
        
    }
   
   public Reserva (int codReserva, String situacao, String dataEntrada, String dataSaida,
           Time horaReserva, double taxaReserva, String tipoQuarto, int qtdAcompanhante, Quarto quarto){
       this.codReserva = codReserva;
       this.situacao = situacao;
       this.dataEntrada = dataEntrada;
       this.dataSaida = dataSaida;
       this.horaReserva = horaReserva;
       this.taxaReserva = taxaReserva;
       this.tipoQuarto = tipoQuarto;
       quarto.add(quarto);
   }
   
   //Só pode fazer a reserva se passar um quarto.
    public Reserva(Quarto quarto){
        addQuarto(quarto);
     }
    
    //pode-se reservar 1 ou muitos quartos de uma vez
    public Reserva (Vector quartos) {
        for(int x=0; x< quartos.size(); x++) {
            addQuarto((Quarto)quartos.get(x));
        }
    }
    
    public void addQuarto(Quarto quarto) {
        quarto.setReserva(this);
        quartos.addElement(quarto);
    }
   
     
    //Metodos
    public void verificarDisponibilidade(){
        
    }
    public void calcularCusto(){
        
    }
    public void avisarLiberacao(){
        
    }
    public String validarReserva (String situacao){
        situacao = "em aberto";
        if (situacao == "em aberto"){
            System.out.println("A reserva continua em aberto!!");
            return situacao;
           
        }
        else
            situacao = "reserva confirmada";
            System.out.println("A reserva foi confirmada");
            return situacao;
    }
    
    //Geter e seter
    /**
     * @return the codReserva
     */
    public int getCodReserva() {
        return codReserva;
    }

    /**
     * @param codReserva the codReserva to set
     */
    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the dataEntrada
     */
    public String getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the dataSaida
     */
    public String getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the horaReserva
     */
    public Time getHoraReserva() {
        return horaReserva;
    }

    /**
     * @param horaReserva the horaReserva to set
     */
    public void setHoraReserva(Time horaReserva) {
        this.horaReserva = horaReserva;
    }

    /**
     * @return the taxaReserva
     */
    public double getTaxaReserva() {
        return taxaReserva;
    }

    /**
     * @param taxaReserva the taxaReserva to set
     */
    public void setTaxaReserva(double taxaReserva) {
        this.taxaReserva = taxaReserva;
    }

    /**
     * @return the tipoQuarto
     */
    public String getTipoQuarto() {
        return tipoQuarto;
    }

    /**
     * @param tipoQuarto the tipoQuarto to set
     */
    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    /**
     * @return the qtdAcompanhante
     */
    public int getQtdAcompanhante() {
        return qtdAcompanhante;
    }

    /**
     * @param qtdAcompanhante the qtdAcompanhante to set
     */
    public void setQtdAcompanhante(int qtdAcompanhante) {
        this.qtdAcompanhante = qtdAcompanhante;
    }

}
