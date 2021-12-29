package br.com.ecommerce.pedidos.adapter.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
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
