
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="campo" required="true" type="Entidades.Usuario"  rtexprvalue="true"%>
<%@taglib prefix="f" uri="/WEB-INF/bibliotecas.tld" %>

<form action="salvar-informacao" method="post">
    <b>E-mail: </b>
    <br>
    <input type="email" value="${campo.email}" id="email" required placeholder="Digite seu E-mail" class="campo-texto" name="email">
    <br>
    <b>Nome: </b>
    <br>
    <input type="text" pattern="[A-ZÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ].*" required value="${campo.nome}" id="nome" class="campo-texto" name="nome" placeholder="Digite seu Nome">
    <br>
    <b>Apelido: </b>
    <br>
    <input type="text" value="${campo.apelido}" pattern="[A-ZÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ].*" id="apelido" class="campo-texto" name="apelido" placeholder="Digite seu Apelido">
    <br>
    <b>Senha: </b>
    <br>
    <input type="password" value="${campo.senha}" id="senha" required placeholder="Digite sua senha" class="campo-texto" name="senha"/>
    <br>
    <b>Cidade: </b>
    <br>
    <input type="text" value="${campo.cidade}" pattern="[A-ZÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ].*" id="cidade" placeholder="Digite sua Cidade" class="campo-texto" name="cidade">
    <br>
    <b>Estado: </b>
    <br>
    <input type="text" value="${campo.estado}" pattern="[A-ZÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ].*" id="estado" placeholder="Digite seu Estado" class="campo-texto" name="estado">
    <br>
    <b>Data de Nascimento: </b>
    <br>
    <input type="text" value="${campo.data_nascimento}"  id="data_nascimento" name="data_nascimento" placeholder="Digite sua data e nascimento" class="campo-texto">
    <br>
    <b>Tipo: </b>
    <br>
    <input type="text" value="${campo.tipo}" id="tipo" placeholder="Digite o tipo" class="campo-texto" name="tipo">
    <div class="botoes">
        <input type="submit" class="btn btn-success" value="Salvar Informações">
    </div>
</form>