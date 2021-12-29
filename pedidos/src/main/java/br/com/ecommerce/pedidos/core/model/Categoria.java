package br.com.ecommerce.pedidos.core.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
   private Long id;
   private String nome;
   private List<Produto> produtos;
}