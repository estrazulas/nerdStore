package br.edu.ifsc.nerdstore.controllers;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsc.nerdstore.beans.Produto;
import br.edu.ifsc.nerdstore.dao.ProdutoDAO;

public class StoreController {

	public String listaProdutos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection<Produto> produtos = ProdutoDAO.getInstance().buscaPorSimilaridade(null);
		req.setAttribute("produtos", produtos);
		
		return "/WEB-INF/paginas/loja.jsp";
	}

}
