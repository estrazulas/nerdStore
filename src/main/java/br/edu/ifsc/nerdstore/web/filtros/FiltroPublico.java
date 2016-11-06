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
public class FiltroPublico implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		System.out.println(uri);
		String usuario = getUsuario(req);
		String tarefa = req.getParameter("tarefa");
		
		//pagina onde login não é necessário
		if(!usuario.equals("<deslogado>") &&  ( estaEmPaginaAberta(uri) || estaEmTarefaSemLogin(tarefa)) ){
			RequestDispatcher dispatcher = req.getRequestDispatcher("/executa?tarefa=loja");
			req.setAttribute("mensagem", "Seja bem vindo!");
			dispatcher.forward(req, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * Nestas tarefas o usuário se estiver logado não pode chegar na ágina
	 * @param tarefa
	 * @return
	 */
	private boolean estaEmTarefaSemLogin(String tarefa) {
		return tarefa!=null && !tarefa.isEmpty() && (tarefa.equals("novoUsuario") || tarefa.equals("salvaUsuario") );
	}

	private boolean estaEmPaginaAberta(String uri) {
		System.out.println(uri);
		boolean paginaAberta = 
				(uri.equals("/nerdstore/") || 
				uri.equals("/nerdstore/index.jsp") || 
				uri.equals("/nerdstore/home") 
				
					);
		
		return paginaAberta;
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
