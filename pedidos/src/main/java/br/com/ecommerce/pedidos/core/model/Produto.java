package br.com.ecommerce.pedidos.core.model;

import br.com.ecommerce.pedidos.adapter.model.CategoriaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Produto {

   private Long id;
   private String nome;
   private Double preco;
   private List<Categoria> categorias = new ArrayList<>();

   @Deprecated
   public Produto() {
   }

   public Produto(String nome, Double preco) {
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

   public List<Categoria> getCategorias() {
      return categorias;
   }
}
