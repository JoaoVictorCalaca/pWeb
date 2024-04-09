<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<title>Mensageria</title>
</head>

<body>
	<c:if test="${falha}">
		<div class="alert alert-danger" role="alert">Preencha
			corretamente todos os dados</div>
	</c:if>
	
	<header>
		<h1>Serviço de Mensageria</h1>
		<div class="line"></div>
		<p>Formulário para envio de emails</p>
	</header>

	<form action="sendMsg" method="post">
		<div class="selects">
			<label for="mailSelect">E-mail:</label> <select id="mailSelect"
				name="dest">
				<c:forEach items="${email}" var="email">
					<option value="${email}">${email}</option>
				</c:forEach>
			</select>
		</div>

		<div class="radios">
			<div class="left">
				<input type="radio" name="mailType" id="check1" value="f"> <label
					for="check1">Cumprimento formal</label>
			</div>
			<div class="right">
				<input type="radio" name="mailType" id="check2" value="h"> <label
					for="check2">Cumprimento conforme horário</label>
			</div>
		</div>

		<div class="checkBoxes">
			<input type="checkbox" id="checkBox" name="auto" value="t"> <label
				for="checkBox">Incluir aviso de "E-mail automatico"</label>
		</div>

		<div class="title">
			<label for="title">Título:</label> <input id="title" name="title"
				type="text">
		</div>

		<div class="msg">
			<label for="msg">Texto:</label>
			<textarea id="msg" name="msg" style="resize: none;"></textarea>
		</div>

		<div class="btns">
			<input type="submit" value="Enviar" /> <a href="#">Voltar</a>
		</div>
	</form>
</body>
</html>