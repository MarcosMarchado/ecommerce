package br.com.ecommerce.pedidos.adapter.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   private LocalDateTime instante = LocalDateTime.now();
   @ManyToOne
   private ClienteEntity cliente;
   @OneToOne
   private EnderecoEntity enderecoDeEntrega;
   @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
   private List<ItemPedidoEntity> itens = new ArrayList<>();

   @Deprecated
   public PedidoEntity() {
   }

   public PedidoEntity(ClienteEntity cliente, EnderecoEntity enderecoDeEntrega, List<ItemPedidoEntity> itens) {
      this.cliente = cliente;
      this.enderecoDeEntrega = enderecoDeEntrega;
      this.itens.addAll(itens);
   }

   public Long getId() {
      return id;
   }

   public void associaPedidoAoItensPedido(){
      itens.forEach(item -> item.setPedido(this));
   }

   public List<ItemPedidoEntity> getItens() {
      return itens;
   }

   public LocalDateTime getInstante() {
      return instante;
   }

   public ClienteEntity getCliente() {
      return cliente;
   }

   public EnderecoEntity getEnderecoDeEntrega() {
      return enderecoDeEntrega;
   }
}
