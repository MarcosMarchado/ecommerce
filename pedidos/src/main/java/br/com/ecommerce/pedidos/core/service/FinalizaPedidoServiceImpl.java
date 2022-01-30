package br.com.ecommerce.pedidos.core.service;

import br.com.ecommerce.pedidos.adapter.web.dto.entrada.FormaDePagamento;
import br.com.ecommerce.pedidos.adapter.web.dto.entrada.ItemPedidoRequest;
import br.com.ecommerce.pedidos.adapter.web.dto.entrada.PedidoRequest;
import br.com.ecommerce.pedidos.core.model.*;
import br.com.ecommerce.pedidos.core.ports.FinalizaPedidoServicePort;
import br.com.ecommerce.pedidos.core.ports.persistence.ClienteRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.persistence.EnderecoRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.persistence.PedidoRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.persistence.ProdutoRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
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

        String formaDePagamento = request.getPagamento().getFormaDePagamento().name();

        PagamentoComCartao pagamentoComCartao =
                new PagamentoComCartao(EstadoDoPagamento.PENDENTE,request.getPagamento().getNumeroDeParcelas());

        PagamentoComBoleto pagamentoComBoleto =
                new PagamentoComBoleto(EstadoDoPagamento.PENDENTE, LocalDate.now().plusDays(5));

        var pagamento = formaDePagamento.equals(FormaDePagamento.BOLETO) ? pagamentoComBoleto : pagamentoComCartao;
        //var pagamentoSalvo = pagamentoRepositoryPort.save(pagamento);
        Pedido pedido = Pedido.builder()
                .instante(LocalDateTime.now())
                .cliente(cliente)
                .pagamento(pagamento)
                .enderecoDeEntrega(endereco)
                .itens(itensPedidos)
                .build();

        pedido.calculaPrecoTotalDoPedido();
        pedido.associaPedidoAoItensPedido();
        pedidoRepositoryPort.save(pedido);
    }

    private List<ItemPedido> retornaListaDeItensPedidos(List<ItemPedidoRequest> request) {
        return request.stream().map(item -> {
            var produto = produtoRepositoryPort.findById(item.getProdutoId());
            var itemPedido = ItemPedido.builder()
                    .produto(produto)
                    .desconto(item.getDesconto())
                    .quantidade(item.getQuantidade())
                    .build();

            itemPedido.calculaValorDoItemPedido();
            return itemPedido;
        }).collect(Collectors.toList());
    }
}
