package br.com.ecommerce.pedidos.core.service;

import br.com.ecommerce.pedidos.core.model.Categoria;
import br.com.ecommerce.pedidos.core.model.PageInfo;
import br.com.ecommerce.pedidos.core.model.Produto;
import br.com.ecommerce.pedidos.core.ports.persistence.ProdutoRepositoryPort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class FiltraProdutosServiceImplTest {

    @MockBean
    private ProdutoRepositoryPort repository;

    @Test
    public void deveProcurarUmProdutoPeloOID() {
        var produto = buildProduto("Pc Gamer", 5200.99);
        when(repository.findById(isA(Long.class))).thenReturn(produto);
        var response = repository.findById(1L);
        assertEquals(5200.99, response.getPreco());
    }

    @Test
    public void deveRetornarErroAoNaoEncontrarProdutoPeloID(){
        Long id = 5L;
        when(repository.findById(isA(Long.class)))
                .thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto id: " + id + " não encontrado"){});

        try{
            repository.findById(id);
        }catch (ResponseStatusException ex){
            assertEquals(HttpStatus.NOT_FOUND, ex.getStatus());
            assertEquals("Produto id: " + id + " não encontrado", ex.getReason());
        }
    }

    @Test
    public void deveListarTodosOsProdutosPaginados() {
        var produtos = buildListProdutos();
        when(repository.findAll(isA(PageInfo.class))).thenReturn(produtos);

        var response = repository.findAll(buildPageInfo());
        assertEquals(2, response.size());
    }

    @Test
    public void deveFiltrarProdutosPorCategoriaEPreco() {
        var produtos = buildListProdutos();
        when(repository.findAll(isA(PageInfo.class),
                isA(Double.class),
                isA(Long.class),
                isA(String.class)))
                .thenReturn(produtos);

        var response = repository.findAll(buildPageInfo(), 3000.0, 2L, "Gamer");
        assertEquals(2, response.size());
        assertEquals("Placa de vídeo", response.get(0).getNome());
        assertEquals(3000.0, response.get(0).getPreco());
    }

    private List<Produto> buildListProdutos() {
        Produto p1 = buildProduto("Placa de vídeo", 3000.0);
        Produto p2 = buildProduto("Pc Gamer", 5200.99);
        return List.of(p1, p2);
    }

    private PageInfo buildPageInfo() {
        var pageInfo = new PageInfo();
        pageInfo.setPageNumber(0);
        pageInfo.setPageSize(2);
        return pageInfo;
    }

    private Produto buildProduto(String nome, Double preco) {
        var produto = Produto.builder()
                .id(1L)
                .nome(nome)
                .preco(preco)
                .build();

        var categoria = Categoria.builder()
                .id(2L)
                .nome("Gamer")
                .produtos(List.of(produto))
                .build();

        produto.setCategorias(List.of(categoria));
        return produto;
    }
}