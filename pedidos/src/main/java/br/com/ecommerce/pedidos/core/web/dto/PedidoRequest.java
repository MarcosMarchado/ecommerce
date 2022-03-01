package br.com.ecommerce.pedidos.core.web.dto;

import br.com.ecommerce.pedidos.adapter.anotations.Pedido;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Pedido
public class PedidoRequest {
   @NotNull
   private Long idCliente;
   @NotNull
   private Long idEnderecoEntrega;
   @Valid
   private PagamentoRequest pagamento;
   @Valid
   private List<ItemPedidoRequest> itens;
}
