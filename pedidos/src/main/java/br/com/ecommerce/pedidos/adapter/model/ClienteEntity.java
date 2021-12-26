package br.com.ecommerce.pedidos.adapter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private String email;
   private String cpf;
   private String senha;
   private String telefone;
   @OneToMany
   private List<EnderecoEntity> enderecos;
   @OneToMany(mappedBy = "cliente")
   private List<PedidoEntity> pedidos;

   @Deprecated
   public ClienteEntity() {
   }

   public ClienteEntity(String nome, String email, String cpf, String senha, String telefone) {
      this.nome = nome;
      this.email = email;
      this.cpf = cpf;
      this.senha = senha;
      this.telefone = telefone;
   }

   public Long getId() {
      return id;
   }

   public String getNome() {
      return nome;
   }

   public String getEmail() {
      return email;
   }

   public String getCpf() {
      return cpf;
   }

   public String getSenha() {
      return senha;
   }

   public String getTelefone() {
      return telefone;
   }

   public List<EnderecoEntity> getEnderecos() {
      return enderecos;
   }

   public List<PedidoEntity> getPedidos() {
      return pedidos;
   }
}
