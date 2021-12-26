package br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa;

import br.com.ecommerce.pedidos.adapter.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {
}
