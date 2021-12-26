package br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa;

import br.com.ecommerce.pedidos.adapter.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {
}
