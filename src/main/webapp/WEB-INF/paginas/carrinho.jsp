<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/comum/cabecalho.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h2 style="margin-left:10px">-<fmt:message key="carrinho.titulo"/></h2>
<hr />
<div class="container carrinho">
	<div class="panel-group">
		<div class="panel panel-primary">
	    	<div class="panel-heading">Produtos na cesta</div>
	    	<div class="panel-body">
		    	<table class="table">
				    <thead>
				      <tr>
				        <th><fmt:message key="itemcarrinho.produto"/></th>
				        <th><fmt:message key="itemcarrinho.quantidade"/></th>
				        <th><fmt:message key="itemcarrinho.total"/></th>
				        <th></th>
				      </tr>
				    </thead>
				   	<tbody>
				   		<c:forEach var="itemComercio" items="${carrinhoCompras.itemsCarrinho}">
				   			<tr>
				   				<td>
				   				${itemComercio.getProduto().nome}
				   				</td>
				   				<td>
				   				${itemComercio.quantidade}
				   				</td>
				   				<td>
				   				<m:moeda valor="${itemComercio.totalDoItem}"/>
				   				</td>
				   				<td>
				   				<a href="<c:url value="/executa?tarefa=removerItem&idItem=${itemComercio.id}"/>">
							       	<button type="button" class="btn btn-default btn-sm">
							          <span class="glyphicon glyphicon-minus"></span>
							        </button>
						        </a>			   				
				   				</td>
				   			</tr>
				   		</c:forEach>
				 	</tbody>
			  	</table>
	   	   </div>
	  </div>
	  <div class="panel panel-success">
	  <div class="panel-heading"><fmt:message key="carrinho.total"/> <m:moeda valor="${carrinhoCompras.precoTotal}" /></div>
	  </div>
	</div>
</div>

<c:if test="${not empty usuarioLogado}">
	<div class="container" class="text-center" >
	<a href="<c:url value="/home"/>" class="btn btn-success" role="button"><fmt:message key="loja.voltar"/> </a>
	</div>
</c:if>

<c:import url="/WEB-INF/comum/rodape.jsp" />