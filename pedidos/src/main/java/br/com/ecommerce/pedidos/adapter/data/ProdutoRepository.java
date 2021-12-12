package br.com.ecommerce.pedidos.adapter.data;

import br.com.ecommerce.pedidos.adapter.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
   Page<Produto> findByNomeContaining(String nome, Pageable pageable);
}
