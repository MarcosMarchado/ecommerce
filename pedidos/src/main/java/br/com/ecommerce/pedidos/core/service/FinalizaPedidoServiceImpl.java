package br.com.ecommerce.pedidos.core.service;

import br.com.ecommerce.pedidos.adapter.persistence.ClienteRepository;
import br.com.ecommerce.pedidos.adapter.persistence.EnderecoRepository;
import br.com.ecommerce.pedidos.adapter.web.dto.entrada.ItemPedidoRequest;
import br.com.ecommerce.pedidos.adapter.web.dto.entrada.PedidoRequest;
import br.com.ecommerce.pedidos.core.model.ItemPedido;
import br.com.ecommerce.pedidos.core.model.Pedido;
import br.com.ecommerce.pedidos.core.ports.ClienteRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.FinalizaPedidoServicePort;
import br.com.ecommerce.pedidos.core.ports.PedidoRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.ProdutoRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FinalizaPedidoServiceImpl implements FinalizaPedidoServicePort {

   private final Logger logger = LoggerFactory.getLogger(FinalizaPedidoServiceImpl.class);
   private final ClienteRepositoryPort clienteRepositoryPort;
   private final EnderecoRepository enderecoRepository;
   private final ProdutoRepositoryPort produtoRepositoryPort;
   private final PedidoRepositoryPort pedidoRepositoryPort;

   @Autowired
   public FinalizaPedidoServiceImpl(ClienteRepository clienteRepositoryPort, EnderecoRepository enderecoRepository,
                                    ProdutoRepositoryPort produtoRepositoryPort, PedidoRepositoryPort pedidoRepositoryPort) {

      this.clienteRepositoryPort = clienteRepositoryPort;
      this.enderecoRepository = enderecoRepository;
      this.produtoRepositoryPort = produtoRepositoryPort;
      this.pedidoRepositoryPort = pedidoRepositoryPort;
   }

   @Override
   public void efetuaPedido(PedidoRequest request){
      logger.info("Executando busca no Banco de Dados");
      var cliente = clienteRepositoryPort.findById(request.getIdCliente());
      var endereco = enderecoRepository.findById(request.getIdEnderecoEntrega());
      var itensPedidos = retornaListaDeItensPedidos(request.getItens());

      Pedido pedido = new Pedido(cliente, endereco, itensPedidos);
      pedido.associaPedidoAoItensPedido();
      pedidoRepositoryPort.save(pedido);
   }

   private List<ItemPedido> retornaListaDeItensPedidos(List<ItemPedidoRequest> request){
     return request.stream().map(item -> {
         var produto = produtoRepositoryPort.findById(item.getProdutoId());
         return new ItemPedido(produto, item.getDesconto(), item.getQuantidade());
      }).collect(Collectors.toList());
   }
}
