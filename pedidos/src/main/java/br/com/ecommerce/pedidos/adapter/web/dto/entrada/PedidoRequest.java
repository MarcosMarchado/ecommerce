package br.com.ecommerce.pedidos.adapter.web.dto.entrada;

import java.util.List;

public class PedidoRequest {

   private Long idCliente;

   private Long idEnderecoEntrega;

   private List<ItemPedidoRequest> itens;

   public List<ItemPedidoRequest> getItens() {
      return itens;
   }

   public Long getIdCliente() {
      return idCliente;
   }

   public Long getIdEnderecoEntrega() {
      return idEnderecoEntrega;
   }
}
