package br.com.ecommerce.pagamento.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Pagamento {
    private Long id;
    private EstadoDoPagamento estadoDoPagamento;
    private Long idUsuario;

    public Pagamento(EstadoDoPagamento estadoDoPagamento) {
        this.estadoDoPagamento = estadoDoPagamento;
    }
}
