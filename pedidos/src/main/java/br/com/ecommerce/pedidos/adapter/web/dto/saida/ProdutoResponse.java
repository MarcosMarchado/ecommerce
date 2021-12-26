package br.com.ecommerce.pedidos.adapter.web.dto.saida;

import br.com.ecommerce.pedidos.adapter.model.CategoriaEntity;
import br.com.ecommerce.pedidos.adapter.model.ProdutoEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoResponse {
   private Long id;

   private String nome;

   private Double preco;

   private List<CategoriaResponse> categorias;

   public ProdutoResponse(ProdutoEntity produtoEntity) {
      this.id = produtoEntity.getId();
      this.nome = produtoEntity.getNome();
      this.preco = produtoEntity.getPreco();
   }

   public ProdutoResponse(ProdutoEntity produtoEntity, List<CategoriaEntity> categoriaEntities) {
      this.id = produtoEntity.getId();
      this.nome = produtoEntity.getNome();
      this.preco = produtoEntity.getPreco();
      this.categorias = categoriaEntities.stream().map(CategoriaResponse::new).collect(Collectors.toList());
   }

   public Long getId() {
      return id;
   }

   public String getNome() {
      return nome;
   }

   public Double getPreco() {
      return preco;
   }

   public List<CategoriaResponse> getCategorias() {
      return categorias;
   }

   public static Page<ProdutoResponse> paraResponse (Page<ProdutoEntity> produtos){
      return produtos.map(produto -> {
         var categorias = produto.getCategorias();
         return new ProdutoResponse(produto, categorias);
      });
   }
}
