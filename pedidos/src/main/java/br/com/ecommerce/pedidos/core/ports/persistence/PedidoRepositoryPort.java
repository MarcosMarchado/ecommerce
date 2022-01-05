package br.com.ecommerce.pedidos.core.ports.persistence;

import br.com.ecommerce.pedidos.core.model.Pedido;

public interface PedidoRepositoryPort {
   Pedido save(Pedido pedido);
}
