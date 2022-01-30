package br.com.ecommerce.pedidos.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class PagamentoComBoleto extends Pagamento{
    private LocalDate dataVencimento;
    private LocalDateTime dataPagamento;

    public PagamentoComBoleto(EstadoDoPagamento estadoDoPagamento, LocalDate dataVencimento) {
        super(estadoDoPagamento);
        this.dataVencimento = dataVencimento;
    }

}
