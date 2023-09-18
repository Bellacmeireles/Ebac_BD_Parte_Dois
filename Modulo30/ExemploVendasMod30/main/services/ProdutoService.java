package ExemploVendasMod30.main.services;

import ExemploVendasMod30.main.dao.IProdutoDao;
import ExemploVendasMod30.main.domain.Produto;
import ExemploVendasMod30.main.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDao dao) {
		super(dao);
	}
    
}
