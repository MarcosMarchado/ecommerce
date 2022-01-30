package br.com.ecommerce.pedidos.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PagamentoComCartao extends Pagamento{
    private Integer numeroDeParcelas;

    public PagamentoComCartao(EstadoDoPagamento estadoDoPagamento, Integer numeroDeParcelas) {
        super(estadoDoPagamento);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
