<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="<c:url value="/home"/>" style="font-size: 300%">NerdStore</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    
      <ul class="nav navbar-nav navbar-right">
		<li class="dropdown"> 
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="compra.total"/>:<fmt:formatNumber value="${carrinho.precoTotal}" type="currency" currencySymbol="R$"/><span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#"><fmt:message key="compra.vercarrinho"/></a></li>
            <li><a href="<c:url value="/executa?tarefa=listaUsuarios"/>"><fmt:message key="usuario.verusuarios"/></a></li>
            <li><a href="<c:url value="/executa?tarefa=logoff"/>"><fmt:message key="loja.sair"/></a></li>
          </ul>
          
        </li>    
        <li><a href="<c:url value="/executa?tarefa=logoff"/>">${usuarioLogado.email} - <fmt:message key="loja.clique.sair"/></a></li>
             
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>