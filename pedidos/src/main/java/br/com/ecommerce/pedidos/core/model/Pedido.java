package br.com.ecommerce.pedidos.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

   private Long id;
   private LocalDateTime instante;
   private Cliente cliente;
   private Endereco enderecoDeEntrega;
   private List<ItemPedido> itens = new ArrayList<>();

   @Deprecated
   public Pedido() {
   }

   public Pedido(Cliente cliente, Endereco enderecoDeEntrega, List<ItemPedido> itens) {
      this.cliente = cliente;
      this.enderecoDeEntrega = enderecoDeEntrega;
      this.itens.addAll(itens);
   }

   public void associaPedidoAoItensPedido(){
      itens.forEach(item -> item.setPedido(this));
   }

   public Long getId() {
      return id;
   }

   public LocalDateTime getInstante() {
      return instante;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public Endereco getEnderecoDeEntrega() {
      return enderecoDeEntrega;
   }

   public List<ItemPedido> getItens() {
      return itens;
   }
}
