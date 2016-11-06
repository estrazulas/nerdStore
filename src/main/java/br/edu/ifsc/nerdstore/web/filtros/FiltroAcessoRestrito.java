package br.edu.ifsc.nerdstore.web.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.edu.ifsc.nerdstore.beans.Usuario;

@WebFilter(urlPatterns = "/executa")
public class FiltroAcessoRestrito implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String tarefa = req.getParameter("tarefa");
		String usuario = getUsuario(req);
		
		if(usuario.equals("<deslogado>") && ehTarefaRestrita(tarefa))
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
			req.setAttribute("mensagem", "Você precisa estar logado para esta ação!");
			dispatcher.forward(req, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * Não informou a tarefa no executa ou é acesso restrito, então redireciona para index
	 * @param tarefa
	 * @return
	 */
	private boolean ehTarefaRestrita(String tarefa) {
		return tarefa == null || tarefa.isEmpty() || tarefa.equals("loja") || tarefa.equals("logoff") || tarefa.equals("carrinho");
	}

	private String getUsuario(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario==null) return "<deslogado>";
		return usuario.getEmail();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
