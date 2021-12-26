package br.com.ecommerce.pedidos.adapter.configuration;

import br.com.ecommerce.pedidos.PedidosApplication;
import br.com.ecommerce.pedidos.adapter.persistence.ClienteRepository;
import br.com.ecommerce.pedidos.adapter.persistence.EnderecoRepository;
import br.com.ecommerce.pedidos.core.ports.PedidoRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.ProdutoRepositoryPort;
import br.com.ecommerce.pedidos.core.service.FinalizaPedidoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

   @Bean
   public FinalizaPedidoServiceImpl finalizaPedidoService(ClienteRepository clienteRepositoryPort,
                                                          EnderecoRepository enderecoRepository,
                                                          ProdutoRepositoryPort produtoRepositoryPort,
                                                          PedidoRepositoryPort pedidoRepositoryPort) {

      return new FinalizaPedidoServiceImpl(clienteRepositoryPort,
          enderecoRepository,
          produtoRepositoryPort,
          pedidoRepositoryPort);
   }

   @Bean
   public ModelMapper modelMapper() {
      return new ModelMapper();
   }

}
