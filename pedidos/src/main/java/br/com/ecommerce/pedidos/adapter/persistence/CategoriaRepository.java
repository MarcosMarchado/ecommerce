package br.com.ecommerce.pedidos.adapter.persistence;

import br.com.ecommerce.pedidos.adapter.persistence.interfaceJpa.CategoriaJpaRepository;
import br.com.ecommerce.pedidos.core.model.Categoria;
import br.com.ecommerce.pedidos.core.model.PageInfo;
import br.com.ecommerce.pedidos.core.ports.persistence.CategoriaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoriaRepository implements CategoriaRepositoryPort {
    private final CategoriaJpaRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<Categoria> findAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        return repository.findAll(pageable).stream()
                .map(categoriaEntity -> modelMapper.map(categoriaEntity, Categoria.class)).collect(Collectors.toList());
    }
}
