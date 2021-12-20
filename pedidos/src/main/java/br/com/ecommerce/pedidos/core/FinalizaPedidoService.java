package br.com.ecommerce.pedidos.core;

import br.com.ecommerce.pedidos.adapter.data.ClienteRepository;
import br.com.ecommerce.pedidos.adapter.data.EnderecoRepository;
import br.com.ecommerce.pedidos.adapter.data.PedidoRepository;
import br.com.ecommerce.pedidos.adapter.data.ProdutoRepository;
import br.com.ecommerce.pedidos.adapter.model.ItemPedido;
import br.com.ecommerce.pedidos.adapter.model.Pedido;
import br.com.ecommerce.pedidos.adapter.web.dto.entrada.ItemPedidoRequest;
import br.com.ecommerce.pedidos.adapter.web.dto.entrada.PedidoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
//TODO: Incluir forma de pagamento no momento da finalização do Pedido
@Service
public class FinalizaPedidoService {

   private final Logger logger = LoggerFactory.getLogger(FinalizaPedidoService.class);
   private final ClienteRepository clienteRepository;
   private final EnderecoRepository enderecoRepository;
   private final ProdutoRepository produtoRepository;
   private final PedidoRepository pedidoRepository;

   @Autowired
   public FinalizaPedidoService(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository,
                                ProdutoRepository produtoRepository, PedidoRepository pedidoRepository) {

      this.clienteRepository = clienteRepository;
      this.enderecoRepository = enderecoRepository;
      this.produtoRepository = produtoRepository;
      this.pedidoRepository = pedidoRepository;
   }

   public void efetuaPedido(PedidoRequest request){
      logger.info("Executando busca no Banco de Dados");
      var cliente = clienteRepository.findById(request.getIdCliente())
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente id: "+ request.getIdCliente() +" não encontrado"));

      var endereco = enderecoRepository.findById(request.getIdEnderecoEntrega())
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço id: "+ request.getIdEnderecoEntrega() +" não encontrado"));

      var itensPedidos = retornaListaDeItensPedidos(request.getItens());

      Pedido pedido = new Pedido(cliente, endereco, itensPedidos);
      pedido.associaPedidoAoItensPedido();
      pedidoRepository.save(pedido);
   }

   private List<ItemPedido> retornaListaDeItensPedidos(List<ItemPedidoRequest> request){
     return request.stream().map(item -> {
         var produto = produtoRepository.findById(item.getProdutoId())
             .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto id: "+ item.getProdutoId() +" não encontrado"));
         return new ItemPedido(produto, item.getDesconto(), item.getQuantidade());
      }).collect(Collectors.toList());
   }
}
