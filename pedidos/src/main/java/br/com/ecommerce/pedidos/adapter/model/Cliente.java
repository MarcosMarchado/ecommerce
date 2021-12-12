package br.com.ecommerce.pedidos.adapter.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;

   private String nome;

   private String email;

   private String cpf;

   private String senha;

   private String telefone;

   @OneToMany
   private List<Endereco> enderecos;

   @OneToMany(mappedBy = "cliente")
   private List<Pedido> pedidos;

   @Deprecated
   public Cliente() {
   }

   public Cliente(String nome, String email, String cpf, String senha, String telefone) {
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

   public List<Endereco> getEnderecos() {
      return enderecos;
   }

   public List<Pedido> getPedidos() {
      return pedidos;
   }
}
