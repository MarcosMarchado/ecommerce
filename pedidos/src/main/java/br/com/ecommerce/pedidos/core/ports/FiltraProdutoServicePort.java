package br.com.ecommerce.pedidos.core.ports;

import br.com.ecommerce.pedidos.core.model.PageInfo;
import br.com.ecommerce.pedidos.core.model.Produto;

import java.util.List;

public interface FiltraProdutoServicePort {
    Produto produtoPorId(Long id);
    List<Produto> todosProdutos(PageInfo pageInfo);
    List<Produto> filtraProdutosPorCategoriaEPreco(PageInfo pageInfo, Double menorPreco, Long idCategoria, String nome);
}
