package br.com.ecommerce.pedidos.core.model;

public class ItemPedido {

   private Long id;
   private Produto produto;
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
}
