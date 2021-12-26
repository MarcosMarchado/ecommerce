package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.model.PedidoEntity;
import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.PedidoJpaRepository;
import br.com.ecommerce.pedidos.core.model.Pedido;
import br.com.ecommerce.pedidos.core.ports.PedidoRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepository implements PedidoRepositoryPort {

   private final PedidoJpaRepository repository;
   private final ModelMapper modelMapper;

   public PedidoRepository(PedidoJpaRepository repository, ModelMapper modelMapper) {
      this.repository = repository;
      this.modelMapper = modelMapper;
   }

   @Override
   public Pedido save(Pedido pedido) {
      var pedidoEntity = modelMapper.map(pedido, PedidoEntity.class);
      return modelMapper.map(repository.save(pedidoEntity), Pedido.class);
   }
}
