<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:f="http://xmlns.jcp.org/jsf/core"
	xmlns:p="http://primefaces.org/ui">
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
    <h3>Clientes cadastrados</h3>
    <div class="ui-g">
        <div class="ui-g-2"></div>
        <div class="ui-g-8">
            <form id="customers">
                <!-- dataTable -->
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Telefone</th>
                        <th>Email</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </tr>
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.nome}</td>
                        <td>${customer.tel}</td>
                        <td>${customer.email}</td>
                    </tr>
                    <tr>
                        <td>
                            <form action="${pageContext.request.contextPath}/editCustomer" method="post">
                                <input type="hidden" name="customerId" value="${customer.id}">
                                <input type="submit" value="Editar">
                            </form>
                            <form action="${pageContext.request.contextPath}/deleteCustomer" method="post">
                                <input type="hidden" name="customerId" value="${customer.id}">
                                <input type="submit" value="Excluir">
                            </form>
                        </td>
                        <%-- <td>
                            <form action="${pageContext.request.contextPath}/deleteCustomer" method="post">
                                <input type="hidden" name="customerId" value="${customer.id}">
                                <input type="submit" value="Excluir">
                            </form>
                        </td> --%>
                    </tr>
                </table>
            </form>
        </div>
        <div class="ui-g-2"></div>
    </div>

    <h3>Criar novo cliente</h3>
    <div class="ui-g">
        <div class="ui-g-2"></div>
        <div class="ui-g-8">
            <form id="add">
                <table>
                    <tr>
                        <td>
                            <label for="Nome">Nome</label>
                        </td>
                        <td>
                            <input type="text" id="Nome" name="customerName" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="cpf">CPF</label>
                        </td>
                        <td>
                            <input type="text" id="cpf" name="customerCPF" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="tel">Telefone</label>
                        </td>
                        <td>
                            <input type="text" id="tel" name="customerPhone" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="email">E-Mail</label>
                        </td>
                        <td>
                            <input type="text" id="email" name="customerEmail" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="end">Endereço</label>
                        </td>
                        <td>
                            <input type="text" id="end" name="customerAddress" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="numero">Numero</label>
                        </td>
                        <td>
                            <input type="text" id="numero" name="customerNumber" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="cidade">Cidade</label>
                        </td>
                        <td>
                            <input type="text" id="cidade" name="customerCity" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="estado">Estado</label>
                        </td>
                        <td>
                            <input type="text" id="estado" name="customerState" required>
                        </td>
                    </tr>
                </table>
                <form  action="${clienteController.add}" method="post">
                    <input type="submit" value="Cadastrar">
				</form>
            </form>
        </div>
        <div class="ui-g-2"></div>
    </div>
</body>
</html>