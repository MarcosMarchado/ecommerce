package br.com.ecommerce.pedidos.adapter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagamento {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private EstadoDoPagamento estadoDoPagamento;

   public Long getId() {
      return id;
   }

   public EstadoDoPagamento getEstadoDoPagamento() {
      return estadoDoPagamento;
   }
}
