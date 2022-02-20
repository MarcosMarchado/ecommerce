package br.com.ecommerce.pedidos.core.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

   private Long id;
   private LocalDateTime instante;
   private Cliente cliente;
   private Endereco enderecoDeEntrega;
   private List<ItemPedido> itens;
   private BigDecimal valor;
   private Pagamento pagamento;

   public void associaPedidoAoItensPedido(){
      itens.forEach(item -> item.setPedido(this));
   }

   public void calculaPrecoTotalDoPedido() {
      this.valor = itens.stream()
              .map(ItemPedido::getValorItemPedido)
              .reduce(BigDecimal.ZERO, BigDecimal::add);
   }
}
