package br.com.ecommerce.pedidos.core.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ItemPedidoRequest {
   @NotNull
   private Long produtoId;
   @NotNull
   private Double desconto;
   @NotNull
   private Integer quantidade;
}
