package br.edu.ifsc.nerdstore.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsc.nerdstore.beans.Usuario;
import br.edu.ifsc.nerdstore.dao.UsuarioDAO;

public class UsuarioController {


	public String salvaUsuario(HttpServletRequest req, HttpServletResponse resp) {
		String retorno = "/executa?tarefa=listaUsuarios";
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		if(UsuarioDAO.getInstance().usuarioExiste(email)){
			req.setAttribute("mensagem", "Esse usuário já existe, escolha outro e-mail.");
			retorno = "executa?tarefa=novoUsuario";
		}else{
			Usuario novoUsuario = new Usuario(email, senha);
			UsuarioDAO.getInstance().adiciona(novoUsuario);
			req.setAttribute("mensagem", "Usuario cadastrado com sucesso!");
		}
		
		
		return retorno;
	}

	public String listarUsuarios(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("usuarios",UsuarioDAO.getInstance().listarTodos());
		return "/WEB-INF/publicas/usuarios_listagem.jsp";
	}

}
