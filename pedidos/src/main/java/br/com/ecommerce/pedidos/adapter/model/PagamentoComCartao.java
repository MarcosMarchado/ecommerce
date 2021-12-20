package br.com.ecommerce.pedidos.adapter.model;

public class PagamentoComCartao extends Pagamento{
   private Integer numeroDeParcelas;

   @Deprecated
   public PagamentoComCartao() {
   }

   public PagamentoComCartao(Integer numeroDeParcelas) {
      this.numeroDeParcelas = numeroDeParcelas;
   }

   public Integer getNumeroDeParcelas() {
      return numeroDeParcelas;
   }
}
