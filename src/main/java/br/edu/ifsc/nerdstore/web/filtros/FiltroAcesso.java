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

@WebFilter(urlPatterns = "/*")
public class FiltroAcesso implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		
		String usuario = getUsuario(req);
		
		if(!usuario.equals("<deslogado>") && (uri.equals("/nerdstore/") || uri.equals("/nerdstore/index.jsp") || uri.equals("/nerdstore/home") ) ){
			RequestDispatcher dispatcher = req.getRequestDispatcher("/executa");
			req.setAttribute("tarefa", "loja");
			dispatcher.forward(req, response);
		}else{
			chain.doFilter(request, response);
		}
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
