package br.com.ecommerce.pedidos.adapter.persistence.specification;

import br.com.ecommerce.pedidos.adapter.model.ProdutoEntity;
import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecification {

   public static Specification<ProdutoEntity> nome(String nome) {
      return (root, criteriaQuery, criteriaBuilder)
          -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
   }

   public static Specification<ProdutoEntity> precoMenorQue(Double preco) {
      return (root, criteriaQuery, criteriaBuilder)
          -> criteriaBuilder.lessThanOrEqualTo(root.get("preco"), preco);
   }

   public static Specification<ProdutoEntity> produtosPorCategoria(Long idCategoria) {
      return (root, criteriaQuery, criteriaBuilder)
          -> criteriaBuilder.equal(root.join("categorias"), idCategoria);
   }

}
