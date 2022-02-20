package br.com.ecommerce.pedidos.adapter.web.dto.entrada;

import br.com.ecommerce.pedidos.adapter.anotations.Pedido;
import lombok.Getter;

import java.util.List;

@Getter
@Pedido
public class PedidoRequest {
   private Long idCliente;
   private Long idEnderecoEntrega;
   private PagamentoRequest pagamento;
   private List<ItemPedidoRequest> itens;
}
