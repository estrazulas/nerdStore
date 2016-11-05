<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/comum/cabecalho.jsp" />
<h2>Produtos Geeks</h2>
<hr />

<div class="container" id="produtoslista">

 	<c:forEach var="produto" items="${produtos}" varStatus="i">
 		<c:set var="div2" value="${((i.index % 2) == 0)}"/>
	 		<c:if test="div2">
		    	<div class="row">
		    </c:if>
			 <div class="col-md-6">
			     <div class="media">
			       <div class="media-left">
			         <a href="#">
			           <img class="media-object" src="${produto.urlImagem}" alt="${produto.nome}">
			         </a>
			       </div>
			       <div class="media-body">
			         <h4 class="media-heading">${produto.nome}</h4>
			         Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
			       </div>
			     </div>
			 </div>		    
			<c:if test="div2">
		    	</div>
		    </c:if>
    </c:forEach>
</div>

<c:import url="/WEB-INF/comum/rodape.jsp" />