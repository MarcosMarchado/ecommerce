package br.com.ecommerce.pedidos.core.ports;

import br.com.ecommerce.pedidos.core.model.Cliente;

public interface ClienteRepositoryPort {
   Cliente findById(Long id);
}
