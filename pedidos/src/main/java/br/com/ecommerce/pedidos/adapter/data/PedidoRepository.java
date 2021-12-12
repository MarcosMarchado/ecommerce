package br.com.ecommerce.pedidos.adapter.data;

import br.com.ecommerce.pedidos.adapter.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
