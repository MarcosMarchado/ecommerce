package br.com.ecommerce.pedidos.core.service;

import br.com.ecommerce.pedidos.adapter.web.dto.entrada.ItemPedidoRequest;
import br.com.ecommerce.pedidos.adapter.web.dto.entrada.PedidoRequest;
import br.com.ecommerce.pedidos.core.model.ItemPedido;
import br.com.ecommerce.pedidos.core.model.Pedido;
import br.com.ecommerce.pedidos.core.ports.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class FinalizaPedidoServiceImpl implements FinalizaPedidoServicePort {

    private final ClienteRepositoryPort clienteRepositoryPort;
    private final EnderecoRepositoryPort enderecoRepositoryPort;
    private final ProdutoRepositoryPort produtoRepositoryPort;
    private final PedidoRepositoryPort pedidoRepositoryPort;

    @Override
    public void efetuaPedido(PedidoRequest request) {
        log.info("Executando busca no Banco de Dados");
        var cliente = clienteRepositoryPort.findById(request.getIdCliente());
        var endereco = enderecoRepositoryPort.findById(request.getIdEnderecoEntrega());
        var itensPedidos = retornaListaDeItensPedidos(request.getItens());

        Pedido pedido = Pedido.builder()
                .instante(LocalDateTime.now())
                .cliente(cliente)
                .enderecoDeEntrega(endereco)
                .itens(itensPedidos)
                .build();

        pedido.associaPedidoAoItensPedido();
        pedidoRepositoryPort.save(pedido);
    }

    private List<ItemPedido> retornaListaDeItensPedidos(List<ItemPedidoRequest> request) {
        return request.stream().map(item -> {
            var produto = produtoRepositoryPort.findById(item.getProdutoId());
            return ItemPedido.builder()
                    .produto(produto)
                    .desconto(item.getDesconto())
                    .quantidade(item.getQuantidade())
                    .build();
        }).collect(Collectors.toList());
    }
}
