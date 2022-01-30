package br.com.ecommerce.pedidos.core.ports.persistence;

import br.com.ecommerce.pedidos.core.model.Pagamento;

public interface PagamentoRepositoryPort {
    Pagamento save(Pagamento pagamento);
}
