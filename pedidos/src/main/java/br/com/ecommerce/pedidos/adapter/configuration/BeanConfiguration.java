package br.com.ecommerce.pedidos.adapter.configuration;

import br.com.ecommerce.pedidos.adapter.persistence.ClienteRepository;
import br.com.ecommerce.pedidos.core.ports.persistence.EnderecoRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.persistence.PedidoRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.persistence.ProdutoRepositoryPort;
import br.com.ecommerce.pedidos.core.service.FiltraProdutosServiceImpl;
import br.com.ecommerce.pedidos.core.service.FinalizaPedidoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

   @Bean
   public FinalizaPedidoServiceImpl finalizaPedidoService(ClienteRepository clienteRepositoryPort,
                                                          EnderecoRepositoryPort enderecoRepositoryPort,
                                                          ProdutoRepositoryPort produtoRepositoryPort,
                                                          PedidoRepositoryPort pedidoRepositoryPort) {

      return new FinalizaPedidoServiceImpl(clienteRepositoryPort,
          enderecoRepositoryPort,
          produtoRepositoryPort,
          pedidoRepositoryPort);
   }

   @Bean
   public FiltraProdutosServiceImpl filtraProdutosService(ProdutoRepositoryPort produtoRepositoryPort){
      return new FiltraProdutosServiceImpl(produtoRepositoryPort);
   }

   @Bean
   public ModelMapper modelMapper() {
      return new ModelMapper();
   }

}
