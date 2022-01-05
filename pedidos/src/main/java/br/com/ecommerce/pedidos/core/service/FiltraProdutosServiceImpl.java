package br.com.ecommerce.pedidos.core.service;

import br.com.ecommerce.pedidos.core.model.Produto;
import br.com.ecommerce.pedidos.core.ports.FiltraProdutoServicePort;
import br.com.ecommerce.pedidos.core.ports.persistence.ProdutoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class FiltraProdutosServiceImpl implements FiltraProdutoServicePort {

    private final ProdutoRepositoryPort repository;

    @Override
    public Produto produtoPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Produto> todosProdutos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Produto> filtraProdutosPorCategoriaEPreco(Pageable pageable, Double menorPreco, Long idCategoria, String nome) {
        return repository.findAll(pageable, menorPreco, idCategoria, nome);
    }


}
