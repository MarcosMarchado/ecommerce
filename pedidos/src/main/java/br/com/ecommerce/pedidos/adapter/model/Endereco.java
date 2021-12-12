package br.com.ecommerce.pedidos.adapter.model;

import javax.persistence.*;

@Entity
public class Endereco {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String logradouro;
   private String numero;
   private String complemento;
   private String bairro;
   private String cep;
   private String cidade;
   private String estado;

   @Deprecated
   public Endereco() {
   }

   public Endereco(String logradouro,
                   String numero,
                   String complemento,
                   String bairro,
                   String cep,
                   String cidade,
                   String estado,
                   Cliente cliente) {

      this.logradouro = logradouro;
      this.numero = numero;
      this.complemento = complemento;
      this.bairro = bairro;
      this.cep = cep;
      this.cidade = cidade;
      this.estado = estado;
   }

   public Long getId() {
      return id;
   }

   public String getLogradouro() {
      return logradouro;
   }

   public String getNumero() {
      return numero;
   }

   public String getComplemento() {
      return complemento;
   }

   public String getBairro() {
      return bairro;
   }

   public String getCep() {
      return cep;
   }

   public String getCidade() {
      return cidade;
   }

   public String getEstado() {
      return estado;
   }
}
