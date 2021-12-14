package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.pedidos.adapter.data.ProdutoRepository;
import br.com.ecommerce.pedidos.adapter.data.ProdutoSpecification;
import br.com.ecommerce.pedidos.adapter.web.dto.saida.ProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
   public ResponseEntity<?> produtoPorFiltro(@RequestParam(required = false) Double preco,
                                             @RequestParam(required = false) Long idCategoria,
                                             @RequestParam(required = false) String nome,
                                             Pageable pageable) {

      if (Objects.isNull(nome) && Objects.isNull(idCategoria) && Objects.isNull(preco)) {
         var produtos = produtoRepository.findAll(pageable);
         return ResponseEntity.ok(ProdutoResponse.paraResponse(produtos));
      }

      return ResponseEntity.ok(produtoRepository.findAll(Specification.where(
          ProdutoSpecification.nome(nome)
              .or(ProdutoSpecification.precoMaiorQue(preco)
                  .and(ProdutoSpecification.produtosPorCategoria(idCategoria)))
              .or(ProdutoSpecification.precoMenorQue(preco)
                  .and(ProdutoSpecification.produtosPorCategoria(idCategoria)))), pageable));
   }
}
