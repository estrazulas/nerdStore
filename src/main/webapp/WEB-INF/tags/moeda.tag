<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ attribute name="simbolo" required="true" %>
<%@ attribute name="valor" required="true" %>
<fmt:formatNumber value="${valor}" type="currency" currencySymbol="${simbolo}"/>