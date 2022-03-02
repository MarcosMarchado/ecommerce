package br.com.ecommerce.pagamento.adapter.web.dto.saida;

import br.com.ecommerce.pagamento.adapter.model.EstadoDoPagamento;
import br.com.ecommerce.pagamento.core.model.Pagamento;
import br.com.ecommerce.pagamento.core.model.PagamentoComBoleto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter @Setter
public class PagamentoComBoletoResponse {
    private Long id;
    private LocalDate dataVencimento;
    private LocalDateTime dataPagamento;
    private EstadoDoPagamento estadoDoPagamento;

    public static PagamentoComBoletoResponse getPagamentoComBoleto(Pagamento pagamento){
        PagamentoComBoleto pagamentoComBoleto = (PagamentoComBoleto) pagamento;
        return PagamentoComBoletoResponse.builder()
                .id(pagamentoComBoleto.getId())
                .dataVencimento(pagamentoComBoleto.getDataVencimento())
                .dataPagamento(pagamentoComBoleto.getDataPagamento())
                .estadoDoPagamento(EstadoDoPagamento.valueOf(pagamento.getEstadoDoPagamento().name()))
                .build();
    }
}
