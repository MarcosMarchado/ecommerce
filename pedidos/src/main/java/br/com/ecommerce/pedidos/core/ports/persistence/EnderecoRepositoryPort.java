package br.com.ecommerce.pedidos.core.ports.persistence;

import br.com.ecommerce.pedidos.core.model.Endereco;

public interface EnderecoRepositoryPort {
   Endereco findById(Long id);
}
