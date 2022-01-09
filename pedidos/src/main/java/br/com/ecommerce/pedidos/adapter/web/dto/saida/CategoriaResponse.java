package br.com.ecommerce.pedidos.adapter.web.dto.saida;

import br.com.ecommerce.pedidos.core.model.Categoria;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class CategoriaResponse {

   private Long id;
   private String nome;

   public CategoriaResponse(Categoria categoria) {
      this.id = categoria.getId();
      this.nome = categoria.getNome();
   }

   public static Page<CategoriaResponse> paraResponse(Page<Categoria> categorias){
      return categorias.map(CategoriaResponse::new);
   }

}
