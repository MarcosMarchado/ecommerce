package br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa;

import br.com.ecommerce.pedidos.adapter.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {
}
