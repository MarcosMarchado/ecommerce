package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.model.*;
import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.PedidoJpaRepository;
import br.com.ecommerce.pedidos.core.model.Pagamento;
import br.com.ecommerce.pedidos.core.model.PagamentoComBoleto;
import br.com.ecommerce.pedidos.core.model.Pedido;
import br.com.ecommerce.pedidos.core.ports.persistence.PedidoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PedidoRepository implements PedidoRepositoryPort {

   private final PedidoJpaRepository repository;
   private final ModelMapper modelMapper;

   @Override
   public Pedido save(Pedido pedido) {
      var pedidoEntity = buildPedidoEntity(pedido);
      pedidoEntity.associaPedidoAoItensPedido();
      return modelMapper.map(repository.save(pedidoEntity), Pedido.class);
   }

   private PagamentoEntity getPagamentoEntity(Pagamento pagamento){
      if (pagamento instanceof PagamentoComBoleto){
         return modelMapper.map(pagamento, PagamentoComBoletoEntity.class);
      }else{
         return modelMapper.map(pagamento, PagamentoComCartaoEntity.class);
      }
   }

   private PedidoEntity buildPedidoEntity(Pedido pedido){
      var clienteEntity = modelMapper.map(pedido.getCliente(), ClienteEntity.class);
      var enderecoEntity = modelMapper.map(pedido.getEnderecoDeEntrega(), EnderecoEntity.class);
      var itensPedidoEntity = pedido.getItens().stream()
              .map(item -> modelMapper.map(item, ItemPedidoEntity.class)).collect(Collectors.toList());
      var pagamentoEntity = getPagamentoEntity(pedido.getPagamento());

      return new PedidoEntity(null, pedido.getInstante(), clienteEntity, enderecoEntity,
              itensPedidoEntity, pedido.getValor(), pagamentoEntity);
   }

}
