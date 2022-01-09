package br.com.ecommerce.pedidos.core.service;

import br.com.ecommerce.pedidos.core.model.PageInfo;
import br.com.ecommerce.pedidos.core.model.Produto;
import br.com.ecommerce.pedidos.core.ports.FiltraProdutoServicePort;
import br.com.ecommerce.pedidos.core.ports.persistence.ProdutoRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FiltraProdutosServiceImpl implements FiltraProdutoServicePort {

    private final ProdutoRepositoryPort repository;

    @Override
    public Produto produtoPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Produto> todosProdutos(PageInfo pageInfo) {
        return repository.findAll(pageInfo);
    }

    @Override
    public List<Produto> filtraProdutosPorCategoriaEPreco(PageInfo pageInfo, Double menorPreco, Long idCategoria, String nome) {
        return repository.findAll(pageInfo, menorPreco, idCategoria, nome);
    }


}
