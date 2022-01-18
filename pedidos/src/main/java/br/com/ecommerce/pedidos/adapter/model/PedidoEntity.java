package br.com.ecommerce.pedidos.adapter.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "pedido")
public class PedidoEntity {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   private LocalDateTime instante;
   @ManyToOne
   private ClienteEntity cliente;
   @OneToOne
   private EnderecoEntity enderecoDeEntrega;
   @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
   private List<ItemPedidoEntity> itens = new ArrayList<>();
   private BigDecimal valor;

   public void associaPedidoAoItensPedido(){
      itens.forEach(item -> item.setPedido(this));
   }

   public void calculaPrecoTotalDoPedido() {
      this.valor = itens.stream()
              .map(ItemPedidoEntity::getValorItemPedido)
              .reduce(BigDecimal.ZERO, BigDecimal::add);
   }

}
