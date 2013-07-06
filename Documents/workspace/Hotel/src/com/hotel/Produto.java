package com.hotel;

public class Produto extends Consumo {
private int estoque,
			quantidade, 
			codProduto, 
			valorUnitario;
private String produto;
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void controlarEstoque(){
		// TODO calculo de controle de estoque
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
	 * @return the valorUnitario
	 */
	public int getValorUnitario() {
		return valorUnitario;
	}
	/**
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	/**
	 * @return the produto
	 */
	public String getProduto() {
		return produto;
	}
	/**
	 * @param produto the produto to set
	 */
	public void setProduto(String produto) {
		this.produto = produto;
	}

}
