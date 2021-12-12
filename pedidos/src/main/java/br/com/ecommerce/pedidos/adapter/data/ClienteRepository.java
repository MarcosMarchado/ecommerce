package br.com.ecommerce.pedidos.adapter.data;

import br.com.ecommerce.pedidos.adapter.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
