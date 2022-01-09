package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.model.ProdutoEntity;
import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.ProdutoJpaRepository;
import br.com.ecommerce.pedidos.adapter.persistence.specification.ProdutoSpecification;
import br.com.ecommerce.pedidos.core.model.PageInfo;
import br.com.ecommerce.pedidos.core.model.Produto;
import br.com.ecommerce.pedidos.core.ports.persistence.ProdutoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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
   public List<Produto> findAll(PageInfo pageInfo) {
      Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());

      Page<ProdutoEntity> produtos = repository.findAll(pageable);
      return produtos.stream().map(produtoEntity -> modelMapper.map(produtoEntity, Produto.class)).collect(Collectors.toList());
   }

   @Override
   public List<Produto> findAll(PageInfo pageInfo, Double menorPreco, Long idCategoria, String nome){
      Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());

      return repository.findAll(getSpecification(menorPreco, idCategoria, nome), pageable)
              .stream().map(produtoEntity -> modelMapper.map(produtoEntity, Produto.class)).collect(Collectors.toList());
   }

   public Specification<ProdutoEntity> getSpecification(Double menorPreco, Long idCategoria, String nome){
       return Specification.where(
               ProdutoSpecification.precoMenorQue(menorPreco).and(ProdutoSpecification.produtosPorCategoria(idCategoria))
                       .or(ProdutoSpecification.produtosPorCategoria(idCategoria).and(ProdutoSpecification.nome(nome)))
                       .or(ProdutoSpecification.produtosPorCategoria(idCategoria))
                       .or(ProdutoSpecification.nome(nome))
       );
   }

}
