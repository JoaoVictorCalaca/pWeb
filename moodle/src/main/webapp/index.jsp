<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Serviço de Mensagens</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f3f4f6;
            padding: 1px
        }
        .container {
            margin-top: 2rem;
        }
        .card {
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .alert-danger {
            border-radius: 4px;
            margin-bottom: 1rem;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="card">
        <header class="card-header bg-primary text-white text-center">
            <h1 class="mb-3">Serviço de Mensagens</h1>
            <div class="line"></div>
            <p class="card-text">Formulário para envio de e-mails</p>
        </header>

        <div class="card-body">
            <form id="emailForm" action="enviarMensagem" method="post">
                <c:if test="${failure}">
                    <div class="alert alert-danger" role="alert">
                        Por favor, verifique se todos os campos estão preenchidos corretamente.
                    </div>
                </c:if>

                <div class="form-group">
                    <label for="mailSelect">Destinatário:</label>
                    <select id="mailSelect" class="form-control" name="destinatario">
                        <c:forEach items="${emailList}" var="email">
                            <option value="${email}">${email}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label>Tipo de E-mail:</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="tipoEmail" id="check1" value="f">
                        <label class="form-check-label" for="check1">Saudação Formal</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="tipoEmail" id="check2" value="h">
                        <label class="form-check-label" for="check2">Saudação por Hora do Dia</label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkBox" name="auto" value="t">
                        <label class="form-check-label" for="checkBox">Incluir aviso de "E-mail automático"</label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="title">Assunto:</label>
                    <input id="title" class="form-control" name="assunto" type="text">
                </div>

                <div class="form-group">
                    <label for="msg">Mensagem:</label>
                    <textarea id="msg" class="form-control" name="corpoMensagem" rows="6"></textarea>
                </div>

                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
