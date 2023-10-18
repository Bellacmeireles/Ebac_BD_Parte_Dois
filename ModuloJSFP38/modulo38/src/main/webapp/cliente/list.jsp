<html xmlns="http://www.w3.org/1999/xhtml">
    xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:f="http://xmlns.jcp.org/jsf/core"
	xmlns:p="http://primefaces.org/ui">
<f:view>
	<h:head>
		<h:outputStylesheet>
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
                -webkit-box-sizing:border-box;
                -moz-box-sizing: border-box;
            }

        </h:outputStylesheet>
	</h:head>
	<h:body>
		<h:form id="menu">
			<p:menubar>
				<p:submenu label="Cadastro" icon="pi pi-fw pi-user">
					<p:menuitem value="Cliente" icon="pi pi-fw pi-user-plus" action="#{indexController.redirectCliente()}"/>
					<p:menuitem value="Produto" icon="pi pi-fw pi-inbox" action="#{indexController.redirectProduto()}"/>
				</p:submenu>
				<p:submenu label="Venda" icon="pi pi-fw pi-shopping-cart">
					<p:menuitem value="Venda" icon="pi pi-fw pi-shopping-cart" action="#{indexController.redirectVenda()}"/>
				</p:submenu>
			</p:menubar>
		</h:form>
		<p:outputPanel>
			<h3>Clientes cadastrados</h3>
			<div class="ui-g">
				<div class="ui-g-2" />
				<div class="ui-g-12">
					<h:form id="customers">
						<p:growl id="growl" sticky="true" />

						<p:dataTable id="customerList" var="customer"
							value="#{clienteController.clientes}">
							<p:column headerText="Id">
								<h:outputText value="#{customer.id}" />
							</p:column>

							<p:column headerText="Nome">
								<h:outputText id="nomeInput" value="#{customer.nome}" />
							</p:column>

							<p:column headerText="Telefone">
								<h:outputText id="telInput" value="#{customer.tel}" />
							</p:column>

							<p:column headerText="Email">
								<h:outputText id="emailInput" value="#{customer.email}" />
							</p:column>

							<p:column>
								<p:commandButton update="customerList add" value="Editar"
									icon="ui-icon-closethick"
									action="#{clienteController.edit(customer)}"
									styleClass="ui-icon-pencil">
								</p:commandButton>
							</p:column>
							<p:column>
								<p:commandButton update="customerList" value="Delete"
									icon="ui-icon-closethick"
									action="#{clienteController.delete(customer)}"
									styleClass="ui-priority-primary">
									<p:confirm header="Atenção" message="Tem certeza que deseja excluir este cliente?" icon="pi pi-exclamation-triangle"/>
								</p:commandButton>
							</p:column>
						</p:dataTable>
						<br />
						<p:confirmDialog global="true" showEffect="fade" hideEffect="fade" responsive="true" width="350">
				            <p:commandButton value="Não" type="button" styleClass="ui-confirmdialog-no ui-button-flat"/>
				            <p:commandButton value="Sim" type="button" styleClass="ui-confirmdialog-yes" />
				        </p:confirmDialog>
					</h:form>
				</div>
				<div class="ui-g-2"></div>
			</div>
			<h3>Criar novo cliente</h3>
			<div class="ui-g">
				<div class="ui-g-2"></div>
				<div class="ui-g-8">
					<h:form id="add">
						<h:panelGrid columns="3" cellpadding="5" style="margin: 0 auto;">
							<p:outputLabel for="Nome" value="Nome" />
							<p:inputText id="Nome"
								value="#{clienteController.cliente.nome}" required="true" />
							<p:message for="Nome" />
							
							<p:outputLabel for="cpf" value="CPF" />
							<p:inputMask id="cpf" value="#{clienteController.cpfMask}"
								size="11" maxlength="14" required="true"
								mask="999.999.999-99" validateMask="true" />
							<p:message for="cpf" />
	
							<p:outputLabel for="tel" value="Telefone" />
							<p:inputMask id="tel"
								value="#{clienteController.telMask}" required="true"
								mask="(99) 99999-9999" validateMask="true">
							</p:inputMask>
							<p:message for="tel" />

							<p:outputLabel for="email" value="E-Mail" />
							<p:inputText id="email"
								value="#{clienteController.cliente.email}" required="true"
								validatorMessage="#{clienteController.cliente.email} não é válido">
								<f:validateRegex pattern="[\w\.-]*[a-zA-Z0-9_]@[\w\.-]*[a-zA-Z0-9]\.[a-zA-Z][a-zA-Z\.]*[a-zA-Z]" />
							</p:inputText>
							<p:message for="email" />
							
							<p:outputLabel for="end" value="Endereço" />
							<p:inputText id="end"
								value="#{clienteController.cliente.end}" required="true">
							</p:inputText>
							<p:message for="end" />
							
							<p:outputLabel for="numero" value="Numero" />
							<p:inputText id="numero"
								value="#{clienteController.cliente.numero}" required="true">
								<p:keyFilter mask="num" />
							</p:inputText>
							<p:message for="numero" />
							
							<p:outputLabel for="cidade" value="Cidade" />
							<p:inputText id="cidade"
								value="#{clienteController.cliente.cidade}" required="true" size="50">
							</p:inputText>
							<p:message for="cidade" />
							
							<p:outputLabel for="estado" value="Estado" />
							<p:inputText id="estado"
								value="#{clienteController.cliente.estado}" required="true" size="50">
							</p:inputText>
							<p:message for="estado" />

							<p:commandLink id="ajax" action="#{clienteController.voltarTelaInicial()}" style="margin-right:20px;" ajax="false" immediate="true">
					            <h:outputText value="Voltar"/>
					        </p:commandLink>
							<p:commandButton update="@form :customers:customerList"
								value="Cadastrar" action="#{clienteController.add}"
								rendered="#{!clienteController.isUpdate}">
							</p:commandButton>
							<p:commandButton update="@form :customers:customerList"
								value="Atualizar" action="#{clienteController.update}"
								rendered="#{clienteController.isUpdate}">
							</p:commandButton>
							<p:commandButton update="add"
								value="Cancelar" action="#{clienteController.cancel}"
								immediate="true">
								<f:ajax render="add" resetValues="true"/>
							</p:commandButton>
						</h:panelGrid>
						<!-- <h:messages errorStyle="color:red;margin:8px;"></h:messages> -->
					</h:form>
				</div>
				<div class="ui-g-2"></div>
			</div>
		</p:outputPanel>
	</h:body>
</f:view>
</html>