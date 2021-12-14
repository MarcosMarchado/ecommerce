package br.com.ecommerce.pedidos.adapter.data;

import br.com.ecommerce.pedidos.adapter.model.Produto;
import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecification {

   public static Specification<Produto> nome(String nome) {
      return (root, criteriaQuery, criteriaBuilder)
          -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
   }

   public static Specification<Produto> precoMaiorQue(Double preco) {
      return (root, criteriaQuery, criteriaBuilder)
          -> criteriaBuilder.greaterThanOrEqualTo(root.get("preco"), preco);
   }

   public static Specification<Produto> precoMenorQue(Double preco) {
      return (root, criteriaQuery, criteriaBuilder)
          -> criteriaBuilder.lessThanOrEqualTo(root.get("preco"), preco);
   }

   public static Specification<Produto> produtosPorCategoria(Long idCategoria) {
      return (root, criteriaQuery, criteriaBuilder)
          -> criteriaBuilder.equal(root.join("categorias"), idCategoria);
   }

}
