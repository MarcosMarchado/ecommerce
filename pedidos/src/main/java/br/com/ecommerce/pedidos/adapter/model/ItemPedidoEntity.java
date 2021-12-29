package br.com.ecommerce.pedidos.adapter.model;

import lombok.*;

import javax.persistence.*;

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

}
