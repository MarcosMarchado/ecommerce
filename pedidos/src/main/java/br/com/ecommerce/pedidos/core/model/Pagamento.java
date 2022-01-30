package br.com.ecommerce.pedidos.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pagamento {
    private Long id;
    private EstadoDoPagamento estadoDoPagamento;

    public Pagamento(EstadoDoPagamento estadoDoPagamento) {
        this.estadoDoPagamento = estadoDoPagamento;
    }
}
