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
public class Cliente {
   private Long id;
   private String nome;
   private String email;
   private String cpf;
   private String senha;
   private String telefone;
   private List<Endereco> enderecos;
   private List<Pedido> pedidos;
}
