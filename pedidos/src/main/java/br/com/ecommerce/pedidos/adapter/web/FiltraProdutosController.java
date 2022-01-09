package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.pedidos.adapter.web.dto.saida.ProdutoResponse;
import br.com.ecommerce.pedidos.core.model.PageInfo;
import br.com.ecommerce.pedidos.core.ports.FiltraProdutoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
                                                                 @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable) {
      PageInfo pageInfo = new PageInfo();
      BeanUtils.copyProperties(pageable, pageInfo);
      if (Objects.isNull(nome) && Objects.isNull(idCategoria) && Objects.isNull(menorPreco)) {
         var produtos = filtraProdutoServicePort.todosProdutos(pageInfo);
         return ResponseEntity.ok(ProdutoResponse.paraResponse(new PageImpl<>(produtos, pageable, produtos.size())));
      }
      var produtosFiltrados = filtraProdutoServicePort.filtraProdutosPorCategoriaEPreco(pageInfo, menorPreco, idCategoria, nome);

      return ResponseEntity.ok(ProdutoResponse.paraResponse(new PageImpl<>(produtosFiltrados, pageable, produtosFiltrados.size())));
   }
}
