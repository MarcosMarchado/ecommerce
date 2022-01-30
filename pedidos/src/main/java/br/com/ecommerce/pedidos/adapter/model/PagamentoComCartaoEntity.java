package br.com.ecommerce.pedidos.adapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter @Setter
@NoArgsConstructor
@Entity @Table(name = "pagamento_cartao")
@PrimaryKeyJoinColumn(name="id")
public class PagamentoComCartaoEntity extends PagamentoEntity {
   private Integer numeroDeParcelas;

   public PagamentoComCartaoEntity(EstadoDoPagamento estadoDoPagamento, Integer numeroDeParcelas) {
      super(estadoDoPagamento);
      this.numeroDeParcelas = numeroDeParcelas;
   }

}
