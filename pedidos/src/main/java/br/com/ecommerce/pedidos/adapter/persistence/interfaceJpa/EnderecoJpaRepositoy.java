package br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa;

import br.com.ecommerce.pedidos.adapter.model.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoJpaRepositoy extends JpaRepository<EnderecoEntity, Long> {
}
