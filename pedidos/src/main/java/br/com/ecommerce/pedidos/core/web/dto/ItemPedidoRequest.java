package br.com.ecommerce.pedidos.core.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class ItemPedidoRequest {
   private Long produtoId;
   private Double desconto;
   private Integer quantidade;
}
