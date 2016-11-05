package br.edu.ifsc.nerdstore.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsc.nerdstore.controllers.LoginController;

@WebServlet(urlPatterns = "/executa")
public class Dispatcher extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String tarefa = req.getParameter("tarefa");
		String paginaDestino = "";
		
		if (tarefa == null) {
			throw new IllegalArgumentException(
					"Você esqueceu de passar a tarefa no form!");
		}
		
		switch (tarefa) {
			case "efetuaLogin":
				paginaDestino = new LoginController().efetuaLogin(req,resp);
			break;
		default:
				paginaDestino ="store.jsp";
			break;
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(paginaDestino);
		dispatcher.forward(req, resp);
	}
}