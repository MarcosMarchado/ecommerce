package br.com.ecommerce.pedidos.adapter.web.dto.entrada;

import lombok.Getter;

@Getter
public class ItemPedidoRequest {
   private Long produtoId;
   private Double desconto;
   private Integer quantidade;
}
