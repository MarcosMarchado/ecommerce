package br.com.ecommerce.pedidos.core.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PedidoRequest {
   private Long idCliente;
   private Long idEnderecoEntrega;
   private PagamentoRequest pagamento;
   private List<ItemPedidoRequest> itens;

   public void setaPagamento(String pagamentoRequest){
      pagamento.setFormaDePagamento(FormaDePagamento.valueOf(pagamentoRequest));
   }
}
