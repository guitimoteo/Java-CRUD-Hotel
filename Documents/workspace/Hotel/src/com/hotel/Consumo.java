package com.hotel;

public class Consumo {
private static int qtdItens, 
				   codConsumo;
private static String itensConsumo;
public int calcularConsumo(){
	// TODO Fazer o calculo do consumo
	return 0;
}
/**
 * @return the qtdItens
 */
public static int getQtdItens() {
	return qtdItens;
}
/**
 * @param qtdItens the qtdItens to set
 */
public static void setQtdItens(int qtdItens) {
	Consumo.qtdItens = qtdItens;
}
/**
 * @return the codConsumo
 */
public static int getCodConsumo() {
	return codConsumo;
}
/**
 * @param codConsumo the codConsumo to set
 */
public static void setCodConsumo(int codConsumo) {
	Consumo.codConsumo = codConsumo;
}
/**
 * @return the itensConsumo
 */
public static String getItensConsumo() {
	return itensConsumo;
}
/**
 * @param itensConsumo the itensConsumo to set
 */
public static void setItensConsumo(String itensConsumo) {
	Consumo.itensConsumo = itensConsumo;
}
}
