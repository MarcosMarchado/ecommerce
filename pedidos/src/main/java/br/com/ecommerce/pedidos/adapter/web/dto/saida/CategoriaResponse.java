package br.com.ecommerce.pedidos.adapter.web.dto.saida;

import br.com.ecommerce.pedidos.adapter.model.Categoria;
import org.springframework.data.domain.Page;

public class CategoriaResponse {

   private Long id;

   private String nome;

   public CategoriaResponse(Categoria categoria) {
      this.id = categoria.getId();
      this.nome = categoria.getNome();
   }

   public Long getId() {
      return id;
   }

   public String getNome() {
      return nome;
   }

   public static Page<CategoriaResponse> paraResponse(Page<Categoria> categorias){
      return categorias.map(CategoriaResponse::new);
   }

}
