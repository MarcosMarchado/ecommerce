package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.pedidos.adapter.data.ProdutoRepository;
import br.com.ecommerce.pedidos.adapter.web.dto.saida.ProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
   public ResponseEntity<ProdutoResponse> produtoPorId(@PathVariable Long id){
      var produto = produtoRepository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
      return ResponseEntity.ok(new ProdutoResponse(produto));
   }

   @GetMapping
   public ResponseEntity<?> produtoPorNome(@RequestParam(required = false) String nome, Pageable pageable){
      if(Objects.isNull(nome)){
         var produtos = produtoRepository.findAll(pageable);
         return ResponseEntity.ok(ProdutoResponse.paraResponse(produtos));
      }
      var produtos = produtoRepository.findByNomeContaining(nome, pageable);
      return ResponseEntity.ok(ProdutoResponse.paraResponse(produtos));
   }

   //Todo: Filtrar pela categoria e preço
}
