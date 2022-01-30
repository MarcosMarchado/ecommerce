package br.com.ecommerce.pedidos.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
   private Long id;
   private Produto produto;
   private Pedido pedido;
   private Double desconto;
   private Integer quantidade;
   private BigDecimal valorItemPedido;

   public void calculaValorDoItemPedido(){
      var descontoTotal = desconto * quantidade;
      var precoTotalDoItemPedido = getQuantidade() * produto.getPreco();
      var precoFinalComDesconto = precoTotalDoItemPedido - (precoTotalDoItemPedido * descontoTotal);
      valorItemPedido = new BigDecimal(precoFinalComDesconto);
   }
}
