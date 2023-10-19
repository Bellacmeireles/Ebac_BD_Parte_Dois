<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <style>
        th, td {
            text-align: center;
        }

        h3 {
            margin-top: 0;
            text-align: center;
        }

        input[type="text"] {
            width: 100%;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
        }
    </style>
</head>
<body>
    <div>
        <h3>Clientes cadastrados</h3>
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <c:forEach items="${clienteController.clientes}" var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.nome}</td>
                    <td>${customer.tel}</td>
                    <td>${customer.email}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/editCustomer" method="post">
                            <input type="hidden" name="customerId" value="${customer.id}">
                            <input type="submit" value="Editar">
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/deleteCustomer" method="post">
                            <input type="hidden" name="customerId" value="${customer.id}">
                            <input type="submit" value="Excluir">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <h3>Criar novo cliente</h3>
        <form action="${pageContext.request.contextPath}/addCustomer" method="post">
            <label for="Nome">Nome</label>
            <input type="text" id="Nome" name="customerName" required>
            <br>
            <label for="cpf">CPF</label>
            <input type="text" id="cpf" name="customerCPF" required>
            <br>
            <label for="tel">Telefone</label>
            <input type="text" id="tel" name="customerPhone" required>
            <br>
            <label for="email">E-Mail</label>
            <input type="text" id="email" name="customerEmail" required>
            <br>
            <label for="end">Endereço</label>
            <input type="text" id="end" name="customerAddress" required>
            <br>
            <label for="numero">Numero</label>
            <input type="text" id="numero" name="customerNumber" required>
            <br>
            <label for="cidade">Cidade</label>
            <input type="text" id="cidade" name="customerCity" required>
            <br>
            <label for="estado">Estado</label>
            <input type="text" id="estado" name="customerState" required>
            <br>
            <input type="submit" value="Cadastrar">
        </form>
    </div>
</body>
</html>
