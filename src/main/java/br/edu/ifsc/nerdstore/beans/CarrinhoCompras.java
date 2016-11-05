package br.edu.ifsc.nerdstore.beans;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CarrinhoCompras {
	private ArrayList<ItemComercializado> itemsCarrinho;
	private BigDecimal precoTotal;
	

	public CarrinhoCompras(){
		this(new ArrayList<ItemComercializado>(),new BigDecimal(0));
	}
	public CarrinhoCompras(ArrayList<ItemComercializado> itemsCarrinho, BigDecimal precoTotal) {
		this.itemsCarrinho = itemsCarrinho;
		this.precoTotal = precoTotal;
	}
	
	public ArrayList<ItemComercializado> getItemsCarrinho() {
		return itemsCarrinho;
	}
	public void setItemsCarrinho(ArrayList<ItemComercializado> itemsCarrinho) {
		this.itemsCarrinho = itemsCarrinho;
	}
	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	
}
