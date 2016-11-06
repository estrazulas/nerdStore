<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<link href="<c:url value="resources/css/loja.css"/>" rel="stylesheet"/>
</head>
<body>

<c:if test="${not empty usuarioLogado}">
	<div class="container">
		<c:import url="/WEB-INF/comum/nav.jsp"/>
	</div>
</c:if>

<!-- Container principal da página -->
<div class="container">

<!-- Para retornar mensagens -->
<c:if test="${not empty mensagem}">
	<div class="alert alert-danger" role="alert">
  		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  		<span class="sr-only"><fmt:message key="sistema.erro"/>Erro:</span>
 		 ${mensagem}
	</div>
</c:if>

