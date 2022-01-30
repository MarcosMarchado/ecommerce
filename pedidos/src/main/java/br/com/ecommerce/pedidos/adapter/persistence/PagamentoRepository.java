package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.model.EstadoDoPagamento;
import br.com.ecommerce.pedidos.adapter.model.PagamentoComBoletoEntity;
import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.PagamentoJpaRepository;
import br.com.ecommerce.pedidos.core.model.Pagamento;
import br.com.ecommerce.pedidos.core.ports.persistence.PagamentoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class PagamentoRepository implements PagamentoRepositoryPort {

   private final PagamentoJpaRepository repository;
   private final ModelMapper modelMapper;

   @Override
   public Pagamento save(Pagamento pagamento) {
      return modelMapper.map(repository.save(new PagamentoComBoletoEntity(EstadoDoPagamento.PENDENTE, LocalDate.now().plusDays(5))), Pagamento.class);
   }
}
