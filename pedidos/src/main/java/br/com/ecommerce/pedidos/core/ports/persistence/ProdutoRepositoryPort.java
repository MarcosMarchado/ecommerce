package br.com.ecommerce.pedidos.core.ports.persistence;

import br.com.ecommerce.pedidos.core.model.PageInfo;
import br.com.ecommerce.pedidos.core.model.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {
   Produto findById(Long id);
   List<Produto> findAll(PageInfo pageInfo);

   List<Produto> findAll(PageInfo pageInfo, Double menorPreco, Long idCategoria, String nome);
}
