<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="/WEB-INF/comum/cabecalho.jsp" />

	<form action="home" class="form-signin" method="post">
		<h2 class="form-signin-heading"><fmt:message key="mensagem.login.bemvindo"/> Nerd Store!</h2>
		<label for="inputEmail" class="sr-only">Email</label> <input
			type="email" id="email" name="email" class="form-control"
			placeholder="Email" required autofocus> <label
			for="inputPassword" class="sr-only"><fmt:message key="mensagem.login.senha"/></label> <input
			type="password" id="senha" name="senha" class="form-control"
			placeholder="Senha" required> 
		<button class="btn btn-lg btn-primary btn-block" type="submit">Acessar</button>
	</form>

<c:import url="/WEB-INF/comum/rodape.jsp"  />