package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.ProdutoJpaRepository;
import br.com.ecommerce.pedidos.core.model.Produto;
import br.com.ecommerce.pedidos.core.ports.ProdutoRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

   private final ProdutoJpaRepository repository;
   private final ModelMapper modelMapper;

   public ProdutoRepository(ProdutoJpaRepository repository, ModelMapper modelMapper) {
      this.repository = repository;
      this.modelMapper = modelMapper;
   }

   @Override
   public Produto findById(Long id) {
      var produto = repository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto id: " + id + " não encontrado"));
      return modelMapper.map(produto, Produto.class);
   }
}
