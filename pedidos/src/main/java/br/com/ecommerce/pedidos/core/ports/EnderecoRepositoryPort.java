package br.com.ecommerce.pedidos.core.ports;

import br.com.ecommerce.pedidos.core.model.Endereco;

import java.util.Optional;

public interface EnderecoRepositoryPort {
   Endereco findById(Long id);
}
