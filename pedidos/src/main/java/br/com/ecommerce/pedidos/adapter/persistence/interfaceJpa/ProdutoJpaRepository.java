package br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa;

import br.com.ecommerce.pedidos.adapter.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long>, JpaSpecificationExecutor<ProdutoEntity> {
}
