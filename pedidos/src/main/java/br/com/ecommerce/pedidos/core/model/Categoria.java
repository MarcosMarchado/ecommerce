package br.com.ecommerce.pedidos.core.model;

import lombok.*;

import java.util.List;

@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
   private Long id;
   private String nome;
   private List<Produto> produtos;
}
