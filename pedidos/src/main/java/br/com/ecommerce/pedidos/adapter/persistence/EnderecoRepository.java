package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.EnderecoJpaRepository;
import br.com.ecommerce.pedidos.core.model.Endereco;
import br.com.ecommerce.pedidos.core.ports.persistence.EnderecoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class EnderecoRepository implements EnderecoRepositoryPort {

   private final EnderecoJpaRepository repository;
   private final ModelMapper modelMapper;

   @Override
   public Endereco findById(Long id) {
      var endereco = repository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço id: "+ id +" não encontrado"));
      return modelMapper.map(endereco, Endereco.class);
   }
}
