package br.com.ecommerce.pagamento.adapter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity @Table(name = "pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
public class PagamentoEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Enumerated(EnumType.STRING)
   private EstadoDoPagamento estadoDoPagamento;

   private Long idUsuario;

   public PagamentoEntity(EstadoDoPagamento estadoDoPagamento) {
      this.estadoDoPagamento = estadoDoPagamento;
   }
}
