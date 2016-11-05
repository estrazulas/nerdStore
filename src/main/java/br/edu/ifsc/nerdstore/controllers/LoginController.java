package br.edu.ifsc.nerdstore.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsc.nerdstore.beans.Usuario;
import br.edu.ifsc.nerdstore.dao.UsuarioDAO;

public class LoginController  {

	
	public String efetuaLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario =  UsuarioDAO.getInstance().buscaPorEmailESenha(email, senha);
		
		String destino="";
		
		if (usuario == null) {
			req.setAttribute("mensagem", "Usuário inválido!");
			destino = "index.jsp";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			destino = "/WEB-INF/paginas/store.jsp";
		}
		
		return destino;
	}
}