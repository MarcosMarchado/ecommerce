package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.ClienteJpaRepository;
import br.com.ecommerce.pedidos.core.model.Cliente;
import br.com.ecommerce.pedidos.core.ports.ClienteRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ClienteRepository implements ClienteRepositoryPort {

   private final ClienteJpaRepository repository;
   private final ModelMapper modelMapper;

   public ClienteRepository(ClienteJpaRepository repository, ModelMapper modelMapper) {
      this.repository = repository;
      this.modelMapper = modelMapper;
   }

   @Override
   public Cliente findById(Long id) {
      var cliente = repository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente id: "+ id +" não encontrado"));

      return modelMapper.map(cliente, Cliente.class);
   }
}
