package br.com.ecommerce.pedidos.adapter.web.dto.saida;

import br.com.ecommerce.pedidos.adapter.model.CategoriaEntity;
import org.springframework.data.domain.Page;

public class CategoriaResponse {

   private Long id;

   private String nome;

   public CategoriaResponse(CategoriaEntity categoriaEntity) {
      this.id = categoriaEntity.getId();
      this.nome = categoriaEntity.getNome();
   }

   public Long getId() {
      return id;
   }

   public String getNome() {
      return nome;
   }

   public static Page<CategoriaResponse> paraResponse(Page<CategoriaEntity> categorias){
      return categorias.map(CategoriaResponse::new);
   }

}
