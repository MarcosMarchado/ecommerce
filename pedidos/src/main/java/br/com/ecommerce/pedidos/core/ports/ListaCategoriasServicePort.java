package br.com.ecommerce.pedidos.core.ports;

import br.com.ecommerce.pedidos.core.model.Categoria;
import br.com.ecommerce.pedidos.core.model.PageInfo;

import java.util.List;

public interface ListaCategoriasServicePort {
    List<Categoria> listaCategorias(PageInfo pageInfo);
}
