package br.com.ecommerce.pedidos.core.model;

import lombok.*;

@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
   private Long id;
   private String logradouro;
   private String numero;
   private String complemento;
   private String bairro;
   private String cep;
   private String cidade;
   private String estado;
   private Cliente cliente;
}
