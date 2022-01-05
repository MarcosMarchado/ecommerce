package br.com.ecommerce.pedidos.core.ports.persistence;

import br.com.ecommerce.pedidos.core.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryPort {
   Produto findById(Long id);
   Page<Produto> findAll(Pageable pageable);

   Page<Produto> findAll(Pageable pageable, Double menorPreco, Long idCategoria, String nome);
}
