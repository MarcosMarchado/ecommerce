package br.com.ecommerce.pedidos.core.ports;

import br.com.ecommerce.pedidos.adapter.web.dto.entrada.PedidoRequest;

public interface FinalizaPedidoServicePort {
   void efetuaPedido(PedidoRequest request);
}
