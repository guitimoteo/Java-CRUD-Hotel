/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class Hospedagem {
 
    //Criação dos atributos
    private int codHospedagem;
    private String dataEntrada;
    private String dataSaida;
    private Time hora;
    private Hospede hospede;
    private Quarto quarto;
    
    //Construtor
    public Hospedagem(){
        
    }
    public Hospedagem(String dataEntrada, String dataSaida, Time hora, Hospede hospede, Quarto quarto){
        setDataEntrada (dataEntrada);
        setDataSaida (dataSaida);
        setHora (hora);
        setHospede (hospede);
        setQuarto (quarto);    
        
    }
        
      //Construtor da Classe Associativa
        public Hospedagem (int codHospede, int numero){
           hospede = new Hospede ();
           quarto = new Quarto ();
           quarto.setNumero(numero);
           hospede.setCodHospede(codHospede);
            
        }
        
         //String[] auxData = data1.split("/");
        //String auxData2 = "";

        //auxData2 = auxData[2] + "/" + auxData[1] + "/" + auxData[0];
        //return auxData2;
   // }
    
    
    public Hospedagem (int codHospedagem, String dataEntrada, String dataSaida, Time hora, Hospede hospede, Quarto quarto){
        this(dataEntrada, dataSaida, hora, hospede, quarto);
        setCodHospedagem (codHospedagem);
    }
    /**
     * Calcula diferença de datas. Retorna 0 caso haja um erro.
     * @param dataInicial Data no formato dd/mm/aaaa
     * @param dataFinal Data no formato dd/mm/aaaa
     * @return Diferença entre datas
     */
    public int getDiferencaData(String dataInicial, String dataFinal){
		//lendo as datas:
		Scanner ent=new Scanner(System.in);

		String data1= dataInicial;

		String data2=dataFinal;
		
		//utilizando o mÈtodo valida:
		if(!valida(data1)||!valida(data2))
		{
			System.out.println("Data invalida!");
			System.exit(1);
		}
		
		//atribuindo o dia, mÍs e ano as vari·veis:
		int dia1=Integer.parseInt(data1.substring(0,2));
		int mes1=Integer.parseInt(data1.substring(3,5));
		int ano1=Integer.parseInt(data1.substring(6,10));
		
		int dia2=Integer.parseInt(data2.substring(0,2));
		int mes2=Integer.parseInt(data2.substring(3,5));
		int ano2=Integer.parseInt(data2.substring(6,10));
		/**
		//utilizando o mÈtodo bissexto e se o dia e o mÍs e o ano s„o v·lidos:
		if(!bissexto(dia1,mes1,ano1)||!bissexto(dia2,mes2,ano2))
		{
			//System.out.println("Data invalida!");
			//System.exit(1);
		}
		*/
		//verificando se uma data È maior que a outra:
		if(ano2<ano1)
		{
                    
			System.out.println("A data inicial digitada deve ser menor que a final!");
			return 0;
		}
		else
		if((ano2==ano1)&&(mes2<mes1))
		{
			System.out.println("A data inicial digitada deve ser menor que a final!");
			return 0;
		}
		else
		if(dia2<dia1)
		{
			System.out.println("A data inicial digitada deve ser menor que a final!");
			return 0;
		}
		
		//calculando a diferenÁa de dias entre as datas:
		GregorianCalendar d1= new GregorianCalendar();
		d1.set(GregorianCalendar.DATE, dia1);
		d1.set(GregorianCalendar.MONTH, mes1);
		d1.set(GregorianCalendar.YEAR, ano1);
		d1.getTime();
		
		GregorianCalendar d2= new GregorianCalendar();
		d2.set(GregorianCalendar.DATE, dia2);
		d2.set(GregorianCalendar.MONTH, mes2);
		d2.set(GregorianCalendar.YEAR, ano2);
		d2.getTime();
		return diferencaEmDias(d1,d2);
	}
		
	//criando o mÈtodo valida:
	private static boolean valida(String str)
	{
		//verificando se a data possui somente os caracteres 0123456789/
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);//verificando se nos Ìndices data[5] e data[2] est„o as barras "/"
			if((i==2)||(i==5))
			{
				if("/".indexOf(ch)==-1)
				{
					return(false);
				}
			}
			else
			if("0123456789".indexOf(ch)==-1)//verificando se nos outros Ìndices est„o os n˙meros "0123456789"
			{
				return(false);
			}
		}
		return(true);		
	}
	
        //
	/**
         * Método q verifica se o ano é bissexto:
         * @param dia
         * @param mes
         * @param ano
         * @return 
         */
        private static boolean bissexto(int dia, int mes, int ano)
	{
		//verificando se o dia e o mÍs e o ano s„o v·lidos:
		if((dia<1)||(dia>31)||(mes<1)||(mes>12)||(ano<1000))
		{
			return(false);
		}
		if(ano%400==0 || (ano%100!=0 && ano%4==0))
		{
			if((mes==2)&&(dia>29))
			{
				return(false);
			}
		}
		else
		if((mes==2)&&(dia>28))
		{
				return(false);
		}
		return(true);
	}
	
	private static int diferencaEmDias(Calendar c1, Calendar c2)
	{
		long m1 = c1.getTimeInMillis();
		long m2 = c2.getTimeInMillis();
		return (int) ((m2 - m1) / (24*60*60*1000));
	}
    
    
    
    
    //Metodos
    public void controlarHospedagem(){
        
    }
    public void calcularDiaria(){
        
    }
    
    //Geter e seter
    /**
     * @return the codHospedagem
     */
    public int getCodHospedagem() {
        return codHospedagem;
    }

    /**
     * @param codHospedagem the codHospedagem to set
     */
    public void setCodHospedagem(int codHospedagem) {
        this.codHospedagem = codHospedagem;
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
     * @return the hora
     */
    public Time getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * @return the hospede
     */
    public Hospede getHospede() {
        return hospede;
    }

    /**
     * @param hospede the hospede to set
     */
    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    /**
     * @return the quarto
     */
    public Quarto getQuarto() {
        return quarto;
    }

    /**
     * @param quarto the quarto to set
     */
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    
}
