<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/comum/cabecalho.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<hr />
<div class="container">
		<div class="panel-group">
		<div class="panel panel-primary">
	    	<div class="panel-heading"><h1><fmt:message key="usuario.listagem"/></h1></div>
	    	<div class="panel-body">
	<table class="table table-striped">
	   <thead>
	     <tr>
	       <th>Id</th>
	       <th><fmt:message key="usuario.email"/></th>
	       <th><fmt:message key="usuario.datacadastro"/></th>
	     </tr>
	   </thead>
	   <tbody>
	   	<c:forEach var="usuario" items="${usuarios}">
	     <tr>
	       <td>${usuario.id}</td>
	       <td>${usuario.email}</td>
	       <td><fmt:formatDate value="${usuario.dataCadastro.time}" pattern="dd/MM/YYYY"/> </td>
	     </tr>
	     </c:forEach>
	   </tbody>
	 </table>	
	 </div>
	 </div>
	 </div>
</div>
<c:if test="${empty usuarioLogado}">
<div class="container text-center" class="text-center" >
<a href="<c:url value="executa?tarefa=loja"/>" class="btn btn-success" role="button"><fmt:message key="loja.fazlogin"/> </a>
</div>
</c:if>
<c:if test="${not empty usuarioLogado}">
<div class="container text-center" class="text-center" >
<a href="<c:url value="/home"/>" class="btn btn-success" role="button"><fmt:message key="loja.voltar"/> </a>
</div>
</c:if>
  
<c:import url="/WEB-INF/comum/rodape.jsp" />