package br.com.ecommerce.pedidos.adapter.data;

import br.com.ecommerce.pedidos.adapter.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
