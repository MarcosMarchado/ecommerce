package br.com.ecommerce.pedidos.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "cliente")
public class ClienteEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private String email;
   private String cpf;
   private String senha;
   private String telefone;
   @OneToMany(mappedBy = "cliente")
   private List<EnderecoEntity> enderecos;
   @OneToMany(mappedBy = "cliente")
   private List<PedidoEntity> pedidos;
}
