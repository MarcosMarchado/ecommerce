package br.com.ecommerce.pedidos.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "produto")
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

}