package br.com.ecommerce.pedidos.core.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

   private Long id;
   private LocalDateTime instante;
   private Cliente cliente;
   private Endereco enderecoDeEntrega;
   private List<ItemPedido> itens;

   public void associaPedidoAoItensPedido(){
      itens.forEach(item -> item.setPedido(this));
   }
}
