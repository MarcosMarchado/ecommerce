package br.com.ecommerce.pedidos.adapter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item_pedido")
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

   @Deprecated
   public ItemPedidoEntity() {
   }

   public ItemPedidoEntity(ProdutoEntity produto, Double desconto, Integer quantidade) {
      this.produto = produto;
      this.desconto = desconto;
      this.quantidade = quantidade;
   }

   public Long getId() {
      return id;
   }

   public ProdutoEntity getProduto() {
      return produto;
   }

   public PedidoEntity getPedido() {
      return pedido;
   }

   public Double getDesconto() {
      return desconto;
   }

   public Integer getQuantidade() {
      return quantidade;
   }

   public void setPedido(PedidoEntity pedidoEntity) {
      this.pedido = pedidoEntity;
   }

}
