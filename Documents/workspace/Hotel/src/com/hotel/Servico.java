package com.hotel;

public class Servico extends Consumo {
private int codServico, quantidade;
private float valorTotal, valorUnitario;
private String servico, setor, descricao;
	public Servico() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	 * @return the valorTotal
	 */
	public float getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return the valorUnitario
	 */
	public float getValorUnitario() {
		return valorUnitario;
	}
	/**
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	/**
	 * @return the servico
	 */
	public String getServico() {
		return servico;
	}
	/**
	 * @param servico the servico to set
	 */
	public void setServico(String servico) {
		this.servico = servico;
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

}
