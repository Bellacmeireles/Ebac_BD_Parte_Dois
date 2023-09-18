package Modulo30.ExemploVendasMod30.main.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modulo30.ExemploVendasMod30.main.dao.generics.GenericDAO;
import Modulo30.ExemploVendasMod30.main.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDao {

    public ProdutoDAO() {
        super();
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setDescricao(entity.getDescricao());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setValor(entity.getValor());
        entityCadastrado.setFabricadoPais(entity.getFabricadoPais());
        entityCadastrado.setPacote(entity.getPacote());
		entityCadastrado.setEstoque(entity.getEstoque());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_PRODUTO ");
        sb.append("(ID, CODIGO, NOME, DESCRICAO, VALOR, FABRICADOPAIS, PACOTE, ESTOQUE)");
        sb.append("VALUES (nextval('sq_produto'),?,?,?,?,?,?,?)");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {
        stmInsert.setString(1, entity.getCodigo());
        stmInsert.setString(2, entity.getNome());
        stmInsert.setString(3, entity.getDescricao());
        stmInsert.setBigDecimal(4, entity.getValor());
        stmInsert.setString(5, entity.getFabricadoPais());
        stmInsert.setString(6, entity.getPacote());
		stmInsert.setInt(7, entity.getEstoque());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_PRODUTO ");
        sb.append("SET NOME = ?,");
        sb.append("DESCRICAO = ?,");
        sb.append("VALOR = ?,");
        sb.append("FABRICADOPAIS = ?,");
        sb.append("PACOTE = ?,");
		sb.append("ESTOQUE = ?");
        sb.append(" WHERE CODIGO = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
        stmUpdate.setString(1, entity.getNome());
        stmUpdate.setString(2, entity.getDescricao());
        stmUpdate.setBigDecimal(3, entity.getValor());
        stmUpdate.setString(4, entity.getFabricadoPais());
        stmUpdate.setString(5, entity.getPacote());
		stmUpdate.setInt(6, entity.getEstoque());
        stmUpdate.setString(7, entity.getCodigo());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }

}
