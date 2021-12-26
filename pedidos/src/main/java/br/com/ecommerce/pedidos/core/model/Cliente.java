package br.com.ecommerce.pedidos.core.model;

import br.com.ecommerce.pedidos.adapter.model.EnderecoEntity;
import br.com.ecommerce.pedidos.adapter.model.PedidoEntity;

import java.util.List;

public class Cliente {

   private Long id;
   private String nome;
   private String email;
   private String cpf;
   private String senha;
   private String telefone;
   private List<EnderecoEntity> enderecoEntities;
   private List<PedidoEntity> pedidoEntities;

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

   public List<EnderecoEntity> getEnderecos() {
      return enderecoEntities;
   }

   public List<PedidoEntity> getPedidos() {
      return pedidoEntities;
   }

}
