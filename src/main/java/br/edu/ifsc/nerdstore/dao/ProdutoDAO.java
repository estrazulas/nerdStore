package br.edu.ifsc.nerdstore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifsc.nerdstore.beans.Produto;

public class ProdutoDAO {
	
	public static synchronized ProdutoDAO getInstance() {
		if (instancia == null) {
			instancia = new ProdutoDAO();
		}
		return instancia;
	}
	
	private ProdutoDAO() {}
	
	private static ProdutoDAO instancia;

	private final static Map<String, Produto> PRODUTOS = new HashMap<>();
	static {
		PRODUTOS.put("R2D2", new Produto("R2-D2","Porta café R2-D2","https://www.thinkgeek.com/images/products/frontsquare/itns_r2-d2_coffee_press.jpg",39.99D));
		PRODUTOS.put("Hulk", new Produto("HULK","Chaveiro HULK","https://www.thinkgeek.com/images/products/frontsquare/jgvo_marvel_hulk_ornament.jpg",55.99D));
		PRODUTOS.put("DALEK", new Produto("DALEK","Chaveiro DALEK","https://www.thinkgeek.com/images/products/frontsquare/jhkg_doctor_who_dalek_ornament.jpg",7.88D));
		PRODUTOS.put("CANECAYODA", new Produto("YODA","Caneca Yoda", "http://www.thinkgeek.com/images/products/frontsquare/ilgs_sw_yoda_heat_change_mug.gif",80D));
		PRODUTOS.put("DBZ", new Produto("DBZ","Caderno Dragon Ball", "http://www.thinkgeek.com/images/products/frontsquare/jltp_dragon_ball_z_journal.jpg",30.50D));
		PRODUTOS.put("FALLOUT", new Produto("FALLOUT","Fallout BoobleHead", "http://www.thinkgeek.com/images/products/frontsquare/1af2_fallout_bobbleheads.jpg",9.50D));
	}
	
	public Collection<Produto> buscaPorSimilaridade(String nome) {
		if (nome == null)
			return PRODUTOS.values();
		
		List<Produto> similares = new ArrayList<>();
		for (Produto produtos : PRODUTOS.values()) {
			if (produtos.getNome().toLowerCase().contains(nome.toLowerCase()))
				similares.add(produtos);
		}
		return similares;
	}


}
