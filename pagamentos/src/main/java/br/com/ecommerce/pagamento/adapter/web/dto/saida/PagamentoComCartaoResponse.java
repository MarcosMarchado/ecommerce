package br.com.ecommerce.pagamento.adapter.web.dto.saida;

import br.com.ecommerce.pagamento.adapter.model.EstadoDoPagamento;
import br.com.ecommerce.pagamento.core.model.Pagamento;
import br.com.ecommerce.pagamento.core.model.PagamentoComCartao;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class PagamentoComCartaoResponse {
    private Long id;
    private Integer numeroDeParcelas;
    private EstadoDoPagamento estadoDoPagamento;

    public static PagamentoComCartaoResponse getPagamentoComCartao(Pagamento pagamento){
        var pagamentoComCartao = (PagamentoComCartao) pagamento;
        return PagamentoComCartaoResponse
                .builder()
                .id(pagamentoComCartao.getId())
                .numeroDeParcelas(pagamentoComCartao.getNumeroDeParcelas())
                .estadoDoPagamento(EstadoDoPagamento.valueOf(pagamento.getEstadoDoPagamento().name()))
                .build();
    }
}
