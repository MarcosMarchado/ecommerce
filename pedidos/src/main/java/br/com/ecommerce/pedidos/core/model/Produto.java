package br.com.ecommerce.pedidos.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
   private Long id;
   private String nome;
   private Double preco;
   private List<Categoria> categorias;
}
