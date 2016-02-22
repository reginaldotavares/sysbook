<%@tag body-content="empty" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${sessionScope.usuario != null}">
        Sr(a) ${sessionScope.usuario.apelido}.
    </c:when>
    <c:otherwise>
        A melhor rede social sobre livros
    </c:otherwise>

</c:choose>