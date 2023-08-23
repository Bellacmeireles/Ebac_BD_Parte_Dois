package Modulo30.ExemploVendasMod30.main.services;

import Modulo30.ExemploVendasMod30.main.dao.IProdutoDao;
import Modulo30.ExemploVendasMod30.main.domain.Produto;
import Modulo30.ExemploVendasMod30.main.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDao dao) {
		super(dao);
	}
    
}
