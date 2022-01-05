package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.model.PedidoEntity;
import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.PedidoJpaRepository;
import br.com.ecommerce.pedidos.core.model.Pedido;
import br.com.ecommerce.pedidos.core.ports.persistence.PedidoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoRepository implements PedidoRepositoryPort {

   private final PedidoJpaRepository repository;
   private final ModelMapper modelMapper;

   @Override
   public Pedido save(Pedido pedido) {
      var pedidoEntity = modelMapper.map(pedido, PedidoEntity.class);
      return modelMapper.map(repository.save(pedidoEntity), Pedido.class);
   }
}
