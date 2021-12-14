package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.pedidos.adapter.data.ProdutoRepository;
import br.com.ecommerce.pedidos.adapter.data.ProdutoSpecification;
import br.com.ecommerce.pedidos.adapter.web.dto.saida.ProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/ecommerce/produtos")
public class FiltraProdutosController {

   private ProdutoRepository produtoRepository;

   @Autowired
   public FiltraProdutosController(ProdutoRepository produtoRepository) {
      this.produtoRepository = produtoRepository;
   }

   @GetMapping("/{id}")
   public ResponseEntity<ProdutoResponse> detalhesDoProduto(@PathVariable Long id) {
      var produto = produtoRepository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
      return ResponseEntity.ok(new ProdutoResponse(produto));
   }

   @GetMapping
   public ResponseEntity<Page<ProdutoResponse>> produtoPorFiltro(@RequestParam(required = false) Long idCategoria,
                                                                 @RequestParam(required = false) Double menorPreco,
                                                                 @RequestParam(required = false) String nome,
                                                                 Pageable pageable) {

      if (Objects.isNull(nome) && Objects.isNull(idCategoria) && Objects.isNull(menorPreco)) {
         var produtos = produtoRepository.findAll(pageable);
         return ResponseEntity.ok(ProdutoResponse.paraResponse(produtos));
      }

      var produtosFiltrados = produtoRepository.findAll(Specification.where(
          ProdutoSpecification.precoMenorQue(menorPreco).and(ProdutoSpecification.produtosPorCategoria(idCategoria))
              .or(ProdutoSpecification.produtosPorCategoria(idCategoria).and(ProdutoSpecification.nome(nome)))
              .or(ProdutoSpecification.produtosPorCategoria(idCategoria))
              .or(ProdutoSpecification.nome(nome))
      ), pageable);

      return ResponseEntity.ok(ProdutoResponse.paraResponse(produtosFiltrados));
   }
}
