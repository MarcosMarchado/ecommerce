package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.pedidos.adapter.web.dto.saida.ProdutoResponse;
import br.com.ecommerce.pedidos.core.ports.FiltraProdutoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/ecommerce/produtos")
@RequiredArgsConstructor
public class FiltraProdutosController {

   private final FiltraProdutoServicePort filtraProdutoServicePort;

   @GetMapping("/{id}")
   public ResponseEntity<ProdutoResponse> detalhesDoProduto(@PathVariable Long id) {
      var produto = filtraProdutoServicePort.produtoPorId(id);
      return ResponseEntity.ok(new ProdutoResponse(produto));
   }

   @GetMapping
   public ResponseEntity<Page<ProdutoResponse>> produtoPorFiltro(@RequestParam(required = false) Long idCategoria,
                                                                 @RequestParam(required = false) Double menorPreco,
                                                                 @RequestParam(required = false) String nome,
                                                                 Pageable pageable) {

      if (Objects.isNull(nome) && Objects.isNull(idCategoria) && Objects.isNull(menorPreco)) {
         var produtos = filtraProdutoServicePort.todosProdutos(pageable);
         return ResponseEntity.ok(ProdutoResponse.paraResponse(produtos));
      }

      var produtosFiltrados = filtraProdutoServicePort.filtraProdutosPorCategoriaEPreco(pageable, menorPreco, idCategoria, nome);

      return ResponseEntity.ok(ProdutoResponse.paraResponse(produtosFiltrados));
   }
}
