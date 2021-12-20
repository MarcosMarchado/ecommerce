package br.com.ecommerce.pedidos.adapter.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PagamentoComBoleto extends Pagamento{

   private LocalDate dataVencimento;

   private LocalDateTime dataPagamento;

   @Deprecated
   public PagamentoComBoleto() {
   }

   public PagamentoComBoleto(LocalDate dataVencimento, LocalDateTime dataPagamento) {
      this.dataVencimento = dataVencimento;
      this.dataPagamento = dataPagamento;
   }

   public LocalDate getDataVencimento() {
      return dataVencimento;
   }

   public LocalDateTime getDataPagamento() {
      return dataPagamento;
   }
}
