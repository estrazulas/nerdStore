<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/comum/cabecalho.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<hr />
<div class="container crud">
	<h2 style="margin-left:10px">-<fmt:message key="usuario.novousuario"/></h2>
	<form method="post" action="executa">
	  <div class="form-group">
	    <label for="email"><fmt:message key="usuario.email"/></label>
	    <input type="email" class="form-control" required="required" id="email" name="email">
	  </div>
	  <div class="form-group">
	    <label for="pwd"><fmt:message key="usuario.senha"/></label>
	    <input type="password" required="required" class="form-control" id="pwd" name="senha">
	  </div>
	  <input type="hidden" name="tarefa" value="salvaUsuario"/>
	  <button type="submit" class="btn btn-default"><fmt:message key="sistema.gravar"/></button>
	</form>
</div>
<c:import url="/WEB-INF/comum/rodape.jsp" />