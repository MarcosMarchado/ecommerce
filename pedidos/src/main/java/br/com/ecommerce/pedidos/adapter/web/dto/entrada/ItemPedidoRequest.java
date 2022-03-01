package br.com.ecommerce.pedidos.adapter.web.dto.entrada;

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
