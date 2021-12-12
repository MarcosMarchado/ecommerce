package br.com.ecommerce.pedidos.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;

   //@JsonBackReference
   @ManyToMany(mappedBy = "categorias")
   private List<Produto> produtos = new ArrayList<>();

   @Deprecated
   public Categoria() {
   }

   public Categoria(String nome) {
      this.nome = nome;
   }

   public List<Produto> getProdutos() {
      return produtos;
   }

   public Long getId() {
      return id;
   }

   public String getNome() {
      return nome;
   }
}
