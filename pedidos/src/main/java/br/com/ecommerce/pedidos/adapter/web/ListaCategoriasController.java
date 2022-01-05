package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.pedidos.adapter.model.CategoriaEntity;
import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.CategoriaJpaRepository;
import br.com.ecommerce.pedidos.adapter.web.dto.saida.CategoriaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ecommerce/categorias")
@RequiredArgsConstructor
public class ListaCategoriasController {

   private final CategoriaJpaRepository categoriaJpaRepository;

   /*@GetMapping
   public ResponseEntity<?> listaCategorias(Pageable pageable){
      Page<CategoriaEntity> categorias = categoriaJpaRepository.findAll(pageable);
      return ResponseEntity.ok(CategoriaResponse.paraResponse(categorias));
   }*/
}
