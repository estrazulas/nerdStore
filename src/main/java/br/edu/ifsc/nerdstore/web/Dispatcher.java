package br.edu.ifsc.nerdstore.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsc.nerdstore.controllers.LoginController;
import br.edu.ifsc.nerdstore.controllers.StoreController;
import br.edu.ifsc.nerdstore.controllers.UsuarioController;

@WebServlet(urlPatterns = "/executa")
public class Dispatcher extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String tarefa = req.getParameter("tarefa");
		
		String paginaDestino = "";
		
		if (tarefa == null) {
			tarefa = (String) req.getAttribute("tarefa");
			if(tarefa == null ){
				throw new IllegalArgumentException(
						"Voc� esqueceu de passar a tarefa no request!");
			}
		}
		
		switch (tarefa) {
			case "loja":
				paginaDestino = new StoreController().listaProdutos(req,resp);
				break;
			case "logoff":
				paginaDestino = new LoginController().logoff(req,resp);
				break;
			case "novoUsuario": 
				paginaDestino = "/WEB-INF/publicas/usuario.jsp";
				break;
			case "listaUsuarios": 
				paginaDestino = new UsuarioController().listarUsuarios(req, resp);
				break;
			case "salvaUsuario":
				paginaDestino = new UsuarioController().salvaUsuario(req, resp);
				break;
		default:
				req.setAttribute("mensagem", "Este endere�o n�o pode ser acessado!");
				paginaDestino ="index.jsp";
			break;
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(paginaDestino);
		dispatcher.forward(req, resp);
	}
}