package br.com.ecommerce.pedidos.adapter.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "item_pedido")
public class ItemPedidoEntity {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   @ManyToOne
   private ProdutoEntity produto;
   @ManyToOne
   private PedidoEntity pedido;
   private Double desconto;
   private Integer quantidade;
   private BigDecimal valorItemPedido; /*TODO: Adicionar colona nas MIgrations*/

   public void calculaValorDoItemPedido(){
      var descontoTotal = desconto * quantidade;
      var precoTotalDoItemPedido = getQuantidade() * produto.getPreco();
      var precoFinalComDesconto = precoTotalDoItemPedido - (precoTotalDoItemPedido * descontoTotal);
      valorItemPedido = new BigDecimal(precoFinalComDesconto);
   }

}
