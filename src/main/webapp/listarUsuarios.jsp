<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<body>

    <div class="row media-object">

        <c:forEach items="${usuarios}" var="user">
            <div class="col-sm-3 modal-header">
                <img src="${user.foto}" alt="${user.apelido}" class="img-circle img-responsive" width="80" height="60">
                <legend> ${user.apelido}</legend>
            </div>

        </c:forEach>       
    </div>
