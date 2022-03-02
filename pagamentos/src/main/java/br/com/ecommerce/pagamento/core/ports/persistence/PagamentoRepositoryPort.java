package br.com.ecommerce.pagamento.core.ports.persistence;

import br.com.ecommerce.pagamento.core.model.Pagamento;

import java.util.List;

public interface PagamentoRepositoryPort {
    List<Pagamento> findByIdUsuario(Long idUsuario);
}
