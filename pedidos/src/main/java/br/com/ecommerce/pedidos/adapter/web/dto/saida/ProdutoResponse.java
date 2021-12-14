package br.com.ecommerce.pedidos.adapter.web.dto.saida;

import br.com.ecommerce.pedidos.adapter.model.Produto;
import org.springframework.data.domain.Page;
//TODO: Colocar na resposta o id e nome da Categoria de cada Produto
public class ProdutoResponse {
   private Long id;

   private String nome;

   private Double preco;

   public ProdutoResponse(Produto produto) {
      this.id = produto.getId();
      this.nome = produto.getNome();
      this.preco = produto.getPreco();
   }

   public Long getId() {
      return id;
   }

   public String getNome() {
      return nome;
   }

   public Double getPreco() {
      return preco;
   }

   public static Page<ProdutoResponse> paraResponse (Page<Produto> produtos){
      return produtos.map(ProdutoResponse::new);
   }
}
