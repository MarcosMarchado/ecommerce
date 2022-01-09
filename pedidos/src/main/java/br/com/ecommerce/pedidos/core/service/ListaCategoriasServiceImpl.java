package br.com.ecommerce.pedidos.core.service;

import br.com.ecommerce.pedidos.core.model.Categoria;
import br.com.ecommerce.pedidos.core.model.PageInfo;
import br.com.ecommerce.pedidos.core.ports.ListaCategoriasServicePort;
import br.com.ecommerce.pedidos.core.ports.persistence.CategoriaRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListaCategoriasServiceImpl implements ListaCategoriasServicePort {

    private final CategoriaRepositoryPort repository;

    @Override
    public List<Categoria> listaCategorias(PageInfo pageInfo) {
        return repository.findAll(pageInfo);
    }
}
