package br.com.ecommerce.pagamento.adapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity @Table(name = "pagamento_boleto")
@PrimaryKeyJoinColumn(name="id")
public class PagamentoComBoletoEntity extends PagamentoEntity {
   private LocalDate dataVencimento;
   private LocalDateTime dataPagamento;

   public PagamentoComBoletoEntity(EstadoDoPagamento estadoDoPagamento, LocalDate dataVencimento) {
      super(estadoDoPagamento);
      this.dataVencimento = dataVencimento;
   }

}
