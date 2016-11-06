<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/comum/cabecalho.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h2 style="margin-left:10px">-<fmt:message key="loja.titulo"/></h2>
<hr />

<script type="text/javascript">
	var urlCompra = '<c:url value="/executa?tarefa=comprar"/>';
	function comprar(idProduto){
		var quantidade = $('#quantidade-'+idProduto).val();
		var redir = urlCompra+"&quantidade="+quantidade+"&idProduto="+idProduto;
		window.location = redir;
	}
	
</script>
<div class="container" id="produtoslista">

 	<c:forEach var="produto" items="${produtos}" varStatus="i">
 		<c:set var="div2" value="${(((i.index+1) % 2) == 0)}"/>
	 		<c:if test="${div2}">
		    	<div class="row">
		    </c:if>
		    
		    <!-- caixa do produto -->
			 <div class="col-md-6 text-center" style="padding:20px" >
			     <div class="media">
			       <div class="media-left" style="margin:auto;width:300px">
			         <a href="#">
			           <img class="media-object" src="${produto.urlImagem}" alt="${produto.nome}">
			         </a>
			       </div>
			       <div class="media-body">
			         <h4 class="media-heading">${fn:toUpperCase(produto.nome)}</h4>
			         <select id="quantidade-${produto.id}">
			         	<c:forEach begin="1" end="10" varStatus="i">
			         		<option value="${i.index}">${i.index}</option>
			         	</c:forEach>
			         </select>
			         <h2><span class="label label-default"><m:moeda valor="${produto.preco}" /></span></h2>
			         <h2><a href="javascript:comprar('${produto.id}')"><span class="label label-success"><fmt:message key="loja.comprar"/></span></a></h2>
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