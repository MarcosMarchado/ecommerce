package br.com.ecommerce.pedidos.adapter.web.dto.saida;

import br.com.ecommerce.pedidos.adapter.model.Categoria;
import br.com.ecommerce.pedidos.adapter.model.Produto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoResponse {
   private Long id;

   private String nome;

   private Double preco;

   private List<CategoriaResponse> categorias;

   public ProdutoResponse(Produto produto) {
      this.id = produto.getId();
      this.nome = produto.getNome();
      this.preco = produto.getPreco();
   }

   public ProdutoResponse(Produto produto, List<Categoria> categorias) {
      this.id = produto.getId();
      this.nome = produto.getNome();
      this.preco = produto.getPreco();
      this.categorias = categorias.stream().map(CategoriaResponse::new).collect(Collectors.toList());
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

   public static Page<ProdutoResponse> paraResponse (Page<Produto> produtos){
      return produtos.map(produto -> {
         var categorias = produto.getCategorias();
         return new ProdutoResponse(produto, categorias);
      });
   }
}
