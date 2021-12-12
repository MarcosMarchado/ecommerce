package br.com.ecommerce.pedidos.adapter.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class ItemPedido {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   private Produto produto;

   @ManyToOne
   private Pedido pedido;

   private Double desconto;

   private Integer quantidade;

   @Deprecated
   public ItemPedido() {
   }

   public ItemPedido(Produto produto, Double desconto, Integer quantidade) {
      this.produto = produto;
      this.desconto = desconto;
      this.quantidade = quantidade;
   }

   public Long getId() {
      return id;
   }

   public Produto getProduto() {
      return produto;
   }

   public Pedido getPedido() {
      return pedido;
   }

   public Double getDesconto() {
      return desconto;
   }

   public Integer getQuantidade() {
      return quantidade;
   }

   public void setPedido(Pedido pedido) {
      this.pedido = pedido;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ItemPedido that = (ItemPedido) o;
      return Objects.equals(id, that.id) &&
          Objects.equals(produto, that.produto) &&
          Objects.equals(pedido, that.pedido) &&
          Objects.equals(desconto, that.desconto) &&
          Objects.equals(quantidade, that.quantidade);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, pedido, desconto, quantidade);
   }
}
