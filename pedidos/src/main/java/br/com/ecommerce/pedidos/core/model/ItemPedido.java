package br.com.ecommerce.pedidos.core.model;

import lombok.*;

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
}
