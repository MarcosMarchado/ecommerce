package br.com.ecommerce.pedidos.core.ports;

import br.com.ecommerce.pedidos.core.model.Produto;

public interface ProdutoRepositoryPort {
   Produto findById(Long id);
}
