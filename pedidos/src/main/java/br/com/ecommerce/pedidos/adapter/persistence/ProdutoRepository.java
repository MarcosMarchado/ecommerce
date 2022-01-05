package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.model.ProdutoEntity;
import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.ProdutoJpaRepository;
import br.com.ecommerce.pedidos.adapter.persistence.specification.ProdutoSpecification;
import br.com.ecommerce.pedidos.core.model.Produto;
import br.com.ecommerce.pedidos.core.ports.persistence.ProdutoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class ProdutoRepository implements ProdutoRepositoryPort {

   private final ProdutoJpaRepository repository;
   private final ModelMapper modelMapper;

   @Override
   public Produto findById(Long id) {
      var produto = repository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto id: " + id + " não encontrado"));
      return modelMapper.map(produto, Produto.class);
   }

   @Override
   public Page<Produto> findAll(Pageable pageable) {
      Page<ProdutoEntity> produtos = repository.findAll(pageable);
      return produtos.map(produtoEntity -> modelMapper.map(produtoEntity, Produto.class));
   }

   @Override
   public Page<Produto> findAll(Pageable pageable, Double menorPreco, Long idCategoria, String nome){
      Page<ProdutoEntity> produtos = repository.findAll(Specification.where(
              ProdutoSpecification.precoMenorQue(menorPreco).and(ProdutoSpecification.produtosPorCategoria(idCategoria))
                      .or(ProdutoSpecification.produtosPorCategoria(idCategoria).and(ProdutoSpecification.nome(nome)))
                      .or(ProdutoSpecification.produtosPorCategoria(idCategoria))
                      .or(ProdutoSpecification.nome(nome))
      ), pageable);
      return produtos.map(produtoEntity -> modelMapper.map(produtoEntity, Produto.class));
   }

}
