package br.com.ecommerce.pedidos.adapter.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;

   //@JsonBackReference
   @ManyToMany(mappedBy = "categorias")
   private List<ProdutoEntity> produtos = new ArrayList<>();

   @Deprecated
   public CategoriaEntity() {
   }

   public CategoriaEntity(String nome) {
      this.nome = nome;
   }

   public List<ProdutoEntity> getProdutos() {
      return produtos;
   }

   public Long getId() {
      return id;
   }

   public String getNome() {
      return nome;
   }
}
