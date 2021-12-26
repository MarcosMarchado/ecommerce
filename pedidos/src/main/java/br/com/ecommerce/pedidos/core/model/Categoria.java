package br.com.ecommerce.pedidos.core.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

   private Long id;
   private String nome;
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
