/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author chris
 */
public class Quarto {
    //Criacao dos atributos
    private int numero;
    private String tipo;
    private String localizacao;
    private String caracteristica;
    private int qtdOcupado;
    private int qtdReservado;
    private int qtdVago;
    private int qtdTotal;
    private double preco;
    private Reserva reserva;
   
    
    
    
    
    //Construtores
    public Quarto (){
        
    }
    
    public Quarto (String tipo, String localizacao, String caracteristica, int qtdReservado,
            int qtdOcupado, int qtdVago, int qtdTotal, double preco){
        setTipo (tipo);
        setLocalizacao (localizacao);
        setCaracteristica (caracteristica);
        setQtdReservado (qtdReservado);
        setQtdOcupado (qtdOcupado);
        setQtdVago (qtdVago);
        setQtdTotal (qtdTotal);
        setPreco (preco);
    }

    
   public Quarto (int numero, String tipo, String localizacao, String caracteristica,
            int qtdReservado, int qtdOcupado, int qtdVago, int qtdTotal, double preco){
        this(tipo, localizacao, caracteristica, qtdReservado, qtdOcupado, qtdVago, qtdTotal, preco);
        setNumero (numero);
               
            
    }
   
   
   
    //Geter e Seter

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @return the caracteristica
     */
    public String getCaracteristica() {
        return caracteristica;
    }

    /**
     * @param caracteristica the caracteristica to set
     */
    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    /**
     * @return the qtdReservado
     */
    public int getQtdReservado() {
        return qtdReservado;
    }

    /**
     * @param qtdReservado the qtdReservado to set
     */
    public void setQtdReservado(int qtdReservado) {
        this.qtdReservado = qtdReservado;
    }

    /**
     * @return the qtdOcupado
     */
    public int getQtdOcupado() {
        return qtdOcupado;
    }

    /**
     * @param qtdOcupado the qtdOcupado to set
     */
    public void setQtdOcupado(int qtdOcupado) {
        this.qtdOcupado = qtdOcupado;
    }

    /**
     * @return the qtdVago
     */
    public int getQtdVago() {
        return qtdVago;
    }

    /**
     * @param qtdVago the qtdVago to set
     */
    public void setQtdVago(int qtdVago) {
        this.qtdVago = qtdVago;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the qtdTotal
     */
    public int getQtdTotal() {
        return qtdTotal;
    }

    /**
     * @param qtdTotal the qtdTotal to set
     */
    public void setQtdTotal(int qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    /**
     * @return the reserva
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void addElement(Quarto quarto) {
        
    }

    void add(Quarto quarto) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
}
