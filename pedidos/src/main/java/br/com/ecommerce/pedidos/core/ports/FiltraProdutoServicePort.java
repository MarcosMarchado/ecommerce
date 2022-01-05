package br.com.ecommerce.pedidos.core.ports;

import br.com.ecommerce.pedidos.core.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FiltraProdutoServicePort {
    Produto produtoPorId(Long id);
    Page<Produto> todosProdutos(Pageable pageable);
    Page<Produto> filtraProdutosPorCategoriaEPreco(Pageable pageable, Double menorPreco, Long idCategoria, String nome);
}
