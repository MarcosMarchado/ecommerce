package br.com.ecommerce.pedidos.adapter.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "endereco")
public class EnderecoEntity {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   private String logradouro;
   private String numero;
   private String complemento;
   private String bairro;
   private String cep;
   private String cidade;
   private String estado;
   @ManyToOne
   private ClienteEntity cliente;
}
