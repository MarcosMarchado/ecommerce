package br.com.ecommerce.pedidos.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "categoria")
public class CategoriaEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;

   //@JsonBackReference
   @ManyToMany(mappedBy = "categorias")
   private List<ProdutoEntity> produtos = new ArrayList<>();

}
