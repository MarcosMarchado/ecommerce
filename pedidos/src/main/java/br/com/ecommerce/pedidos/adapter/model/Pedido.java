package br.com.ecommerce.pedidos.adapter.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private LocalDateTime instante = LocalDateTime.now();

   @ManyToOne
   private Cliente cliente;

   @OneToOne
   private Endereco enderecoDeEntrega;

   @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
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

   public List<ItemPedido> getItens() {
      return itens;
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
}
