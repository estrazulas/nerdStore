package br.edu.ifsc.nerdstore.beans;

import java.math.BigDecimal;

public class ItemComercializado {

	private String id;
	private String  idProduto;
	private Integer quantidade;
	private BigDecimal totalDoItem;
	
	public ItemComercializado(){
		this("", "", new Integer(0), new BigDecimal(0));
	}
	
	public ItemComercializado(String id, String idProduto, Integer quantidade, BigDecimal totalDoItem) {
		this.id = id;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.totalDoItem = totalDoItem;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getTotalDoItem() {
		return totalDoItem;
	}
	public void setTotalDoItem(BigDecimal totalDoItem) {
		this.totalDoItem = totalDoItem;
	}

	
}
