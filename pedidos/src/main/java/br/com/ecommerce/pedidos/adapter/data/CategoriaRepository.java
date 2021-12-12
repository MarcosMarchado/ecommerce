package br.com.ecommerce.pedidos.adapter.data;

import br.com.ecommerce.pedidos.adapter.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
