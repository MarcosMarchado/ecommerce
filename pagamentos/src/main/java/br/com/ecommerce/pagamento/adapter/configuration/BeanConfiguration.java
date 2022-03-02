package br.com.ecommerce.pagamento.adapter.configuration;

import br.com.ecommerce.pagamento.adapter.persistence.PagamentoRepository;
import br.com.ecommerce.pagamento.core.service.ListaPagamentosDoUsuarioServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

   @Bean
   public ListaPagamentosDoUsuarioServiceImpl listaPagamentosDoUsuario(PagamentoRepository pagamentoRepository) {

      return new ListaPagamentosDoUsuarioServiceImpl(pagamentoRepository);
   }

   @Bean
   public ModelMapper modelMapper() {
      return new ModelMapper();
   }

}
