package br.com.ecommerce.pagamento.core.service;

import br.com.ecommerce.pagamento.core.model.Pagamento;
import br.com.ecommerce.pagamento.core.ports.ListaPagamentosServicePort;
import br.com.ecommerce.pagamento.core.ports.persistence.PagamentoRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListaPagamentosDoUsuarioServiceImpl implements ListaPagamentosServicePort {

    private final PagamentoRepositoryPort repository;

    @Override
    public List<Pagamento> listaPagamentos(Long idUsuario){
        return repository.findByIdUsuario(idUsuario);
    }
}
