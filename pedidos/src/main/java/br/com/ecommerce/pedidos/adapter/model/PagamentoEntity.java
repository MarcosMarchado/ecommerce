package br.com.ecommerce.pedidos.adapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity @Table(name = "pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
public class PagamentoEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Enumerated(EnumType.STRING)
   private EstadoDoPagamento estadoDoPagamento;

   public PagamentoEntity(EstadoDoPagamento estadoDoPagamento) {
      this.estadoDoPagamento = estadoDoPagamento;
   }
}
