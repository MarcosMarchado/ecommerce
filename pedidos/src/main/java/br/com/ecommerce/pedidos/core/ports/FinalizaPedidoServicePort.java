package br.com.ecommerce.pedidos.core.ports;

import br.com.ecommerce.pedidos.core.web.dto.PedidoRequest;

public interface FinalizaPedidoServicePort {
   void efetuaPedido(PedidoRequest request);
}
