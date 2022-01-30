package br.com.ecommerce.pedidos.adapter.web.dto.entrada;

import lombok.Getter;

import java.util.List;

@Getter
public class PedidoRequest {
   private Long idCliente;
   private Long idEnderecoEntrega;
   private PagamentoRequest pagamento;
   private List<ItemPedidoRequest> itens;
}
