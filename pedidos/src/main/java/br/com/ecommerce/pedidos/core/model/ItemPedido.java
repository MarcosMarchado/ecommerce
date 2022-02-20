package br.com.ecommerce.pedidos.core.model;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Setter @Getter
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
