package br.edu.ifsc.nerdstore.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

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
	
	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}
	
	public void adicionaProduto(Produto produto, Integer quantidade){
		ItemComercializado novoItem = new ItemComercializado(produto,quantidade);
		precoTotal.add(novoItem.getTotalDoItem());
	}
	
	
	public void removeProduto(ItemComercializado itemDoCarrinho){
		this.removeItemDoCarrinho(itemDoCarrinho);
		precoTotal.min(itemDoCarrinho.getTotalDoItem());
		
	}
	
	private void removeItemDoCarrinho(ItemComercializado itemDoCarrinho) {
		for (Iterator<ItemComercializado> iterator = itemsCarrinho.iterator(); iterator.hasNext();) {
			ItemComercializado itemComercializado = (ItemComercializado) iterator.next();
			if(itemComercializado.getId().equals(itemDoCarrinho.getId())){
				this.itemsCarrinho.remove(itemComercializado);
			}
		}
	}
	
	

	
}
