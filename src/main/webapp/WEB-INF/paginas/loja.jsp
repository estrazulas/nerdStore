<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/comum/cabecalho.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>
<h2 style="margin-left:10px">-<fmt:message key="loja.titulo"/></h2>
<hr />

<div class="container" id="produtoslista">

 	<c:forEach var="produto" items="${produtos}" varStatus="i">
 		<c:set var="div2" value="${(((i.index+1) % 2) == 0)}"/>
	 		<c:if test="${div2}">
		    	<div class="row">
		    </c:if>
		    
		    <!-- caixa do produto -->
			 <div class="col-md-6" style="padding:20px" >
			     <div class="media">
			       <div class="media-left">
			         <a href="#">
			           <img class="media-object" src="${produto.urlImagem}" alt="${produto.nome}">
			         </a>
			       </div>
			       <div class="media-body">
			         <h4 class="media-heading">${produto.nome}</h4>
			         <h2><span class="label label-default"><m:moeda valor="${produto.preco}" simbolo="R$"/></span></h2>
			         <h2><span class="label label-success"><fmt:message key="loja.comprar"/></span></h2>
			       </div>
			     </div>
			 </div>
			 <!-- caixa do produto -->
			 		    
			<c:if test="${div2}">
		    	</div>
		    </c:if>
    </c:forEach>
</div>

<c:import url="/WEB-INF/comum/rodape.jsp" />