package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.pedidos.adapter.web.dto.saida.CategoriaResponse;
import br.com.ecommerce.pedidos.core.model.PageInfo;
import br.com.ecommerce.pedidos.core.ports.ListaCategoriasServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ecommerce/categorias")
@RequiredArgsConstructor
public class ListaCategoriasController {

   private final ListaCategoriasServicePort listaCategoriasServicePort;

   @GetMapping
   public ResponseEntity<Page<CategoriaResponse>> listaCategorias(Pageable pageable){
      PageInfo pageInfo = new PageInfo();
      BeanUtils.copyProperties(pageable, pageInfo);

      var categorias = listaCategoriasServicePort.listaCategorias(pageInfo);
      return ResponseEntity.ok(CategoriaResponse.paraResponse(new PageImpl<>(categorias, pageable, categorias.size())));
   }
}
