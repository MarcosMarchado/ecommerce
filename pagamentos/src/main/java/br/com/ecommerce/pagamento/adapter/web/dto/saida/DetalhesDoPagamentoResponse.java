package br.com.ecommerce.pagamento.adapter.web.dto.saida;

import br.com.ecommerce.pagamento.core.model.Pagamento;
import br.com.ecommerce.pagamento.core.model.PagamentoComBoleto;
import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalhesDoPagamentoResponse {
    private TIPO_PAGAMENTO tipoPagamento;
    private PagamentoComBoletoResponse boletoResponse;
    private PagamentoComCartaoResponse cartaoResponse;

    public static DetalhesDoPagamentoResponse obtemDadosDoPagamento(Pagamento pagamento){
        if(pagamento instanceof PagamentoComBoleto){
            var pagamentoComBoleto = PagamentoComBoletoResponse.getPagamentoComBoleto(pagamento);
            return DetalhesDoPagamentoResponse.builder()
                    .tipoPagamento(TIPO_PAGAMENTO.BOLETO)
                    .boletoResponse(pagamentoComBoleto)
                    .build();
            //new DetalhesDoPagamentoResponse(TIPO_PAGAMENTO.BOLETO, pagamentoComBoleto, null)
        }

        var pagamentoComCartao = PagamentoComCartaoResponse.getPagamentoComCartao(pagamento);
        return DetalhesDoPagamentoResponse.builder()
                .tipoPagamento(TIPO_PAGAMENTO.CARTAO_CREDITO)
                .cartaoResponse(pagamentoComCartao)
                .build();
    }
}
