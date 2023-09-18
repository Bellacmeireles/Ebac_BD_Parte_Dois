package Modulo30.ExemploVendasMod30.main.domain;

import java.math.BigDecimal;

import Modulo30.ExemploVendasMod30.main.anotacao.ColunaTabela;
import Modulo30.ExemploVendasMod30.main.anotacao.Tabela;
import Modulo30.ExemploVendasMod30.main.anotacao.TipoChave;
import Modulo30.ExemploVendasMod30.main.dao.Persistente;

@Tabela("TB_PRODUTO")
public class Produto implements Persistente {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
	private Long id;

	@TipoChave("getCodigo")
	@ColunaTabela(dbName = "codigo", setJavaName = "setCodigo")
	private String codigo;

    /* tarefa mod30 */
    @ColunaTabela(dbName = "fabricadoPais", setJavaName = "setFabricadoPais")
    private String fabricadoPais;
	
	@ColunaTabela(dbName = "nome", setJavaName = "setNome")
	private String nome;
	
	@ColunaTabela(dbName = "descricao", setJavaName = "setDescricao")
	private String descricao;
	
	@ColunaTabela(dbName = "valor", setJavaName = "setValor")
	private BigDecimal valor;

    @ColunaTabela(dbName = "pacote", setJavaName = "setPacote")
    private String pacote;

    @ColunaTabela(dbName = "estoque", setJavaName = "setEstoque")
    private Integer estoque;

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
    
    public String getPacote() {
		return pacote;
	}

	public void setPacote(String pacote) {
		this.pacote = pacote;
	}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    /* tarefa mod30 */
    public String getFabricadoPais() {
        return fabricadoPais;
    }

    public void setFabricadoPais(String fabricadoPais) {
        this.fabricadoPais = fabricadoPais;
    }

}
