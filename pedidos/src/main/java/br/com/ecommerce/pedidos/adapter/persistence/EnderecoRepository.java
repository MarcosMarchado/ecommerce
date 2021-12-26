package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.EnderecoJpaRepositoy;
import br.com.ecommerce.pedidos.core.model.Endereco;
import br.com.ecommerce.pedidos.core.ports.EnderecoRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class EnderecoRepository implements EnderecoRepositoryPort {

   private final EnderecoJpaRepositoy repository;
   private final ModelMapper modelMapper;

   public EnderecoRepository(EnderecoJpaRepositoy repository, ModelMapper modelMapper) {
      this.repository = repository;
      this.modelMapper = modelMapper;
   }

   @Override
   public Endereco findById(Long id) {
      var endereco = repository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço id: "+ id +" não encontrado"));
      return modelMapper.map(endereco, Endereco.class);
   }
}
