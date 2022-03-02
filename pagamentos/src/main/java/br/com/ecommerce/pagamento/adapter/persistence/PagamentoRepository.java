package br.com.ecommerce.pagamento.adapter.persistence;

import br.com.ecommerce.pagamento.adapter.persistence.interfaceJpa.IPagamentoRepository;
import br.com.ecommerce.pagamento.core.model.Pagamento;
import br.com.ecommerce.pagamento.core.ports.persistence.PagamentoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PagamentoRepository implements PagamentoRepositoryPort {

    private final ModelMapper modelMapper;
    private final IPagamentoRepository pagamentoRepository;

    @Override
    public List<Pagamento> findByIdUsuario(Long idUsuario) {
        var pagamentos = pagamentoRepository.findByIdUsuario(idUsuario);
        return pagamentos.stream().map(pagamento -> modelMapper.map(pagamento, Pagamento.class)).collect(Collectors.toList());
    }
}
