package br.com.ecommerce.pedidos.core.ports.persistence;

import br.com.ecommerce.pedidos.core.model.Categoria;
import br.com.ecommerce.pedidos.core.model.PageInfo;

import java.util.List;

public interface CategoriaRepositoryPort {
    List<Categoria> findAll(PageInfo pageInfo);
}
