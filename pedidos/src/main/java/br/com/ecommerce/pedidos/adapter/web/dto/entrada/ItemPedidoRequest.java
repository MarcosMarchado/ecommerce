package br.com.ecommerce.pedidos.adapter.web.dto.entrada;

public class ItemPedidoRequest {

   private Long produtoId;

   private Double desconto;

   private Integer quantidade;

   private Double preco;

   public Long getProdutoId() {
      return produtoId;
   }

   public Double getDesconto() {
      return desconto;
   }

   public Integer getQuantidade() {
      return quantidade;
   }

   public Double getPreco() {
      return preco;
   }
}
