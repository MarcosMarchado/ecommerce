package br.com.ecommerce.pagamento.core.ports;

import br.com.ecommerce.pagamento.core.model.Pagamento;

import java.util.List;

public interface ListaPagamentosServicePort {
    List<Pagamento> listaPagamentos(Long idUsuario);
}
