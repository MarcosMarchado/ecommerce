package br.com.ecommerce.pedidos.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;

   private String nome;

   private Double preco;

   //@JsonManagedReference
   @JsonIgnore
   @ManyToMany
   @JoinTable(
       name = "categoria_produto",
       joinColumns = @JoinColumn(name = "produto_id"),
       inverseJoinColumns = @JoinColumn(name = "categoria_id")
   )
   private List<CategoriaEntity> categorias = new ArrayList<>();

   @Deprecated
   public ProdutoEntity() {
   }

   public ProdutoEntity(String nome, Double preco) {
      this.nome = nome;
      this.preco = preco;
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

   public List<CategoriaEntity> getCategorias() {
      return categorias;
   }
}
