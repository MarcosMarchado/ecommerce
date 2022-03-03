package br.com.ecommerce.pedidos.core.service;

import br.com.ecommerce.pedidos.core.model.*;
import br.com.ecommerce.pedidos.core.ports.FinalizaPedidoServicePort;
import br.com.ecommerce.pedidos.core.ports.mensageria.EnviadorDeMensagemPort;
import br.com.ecommerce.pedidos.core.ports.persistence.ClienteRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.persistence.EnderecoRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.persistence.PedidoRepositoryPort;
import br.com.ecommerce.pedidos.core.ports.persistence.ProdutoRepositoryPort;
import br.com.ecommerce.pedidos.core.web.dto.FormaDePagamento;
import br.com.ecommerce.pedidos.core.web.dto.ItemPedidoRequest;
import br.com.ecommerce.pedidos.core.web.dto.PagamentoRequest;
import br.com.ecommerce.pedidos.core.web.dto.PedidoRequest;
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
    private final EnviadorDeMensagemPort enviadorDeMensagemPort;

    @Override
    public void efetuaPedido(PedidoRequest request) {
        log.info("Executando busca no Banco de Dados");
        var cliente = clienteRepositoryPort.findById(request.getIdCliente());
        var endereco = enderecoRepositoryPort.findById(request.getIdEnderecoEntrega());
        var itensPedidos = retornaListaDeItensPedidos(request.getItens());

        var pagamento = getPagamento(request.getPagamento());

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
        enviadorDeMensagemPort.enviaMensagem("ECOMMERCE_PAGAMENTOS", pedido.getPagamento());
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

    private Pagamento getPagamento(PagamentoRequest pagamento) {
        if (pagamento.getFormaDePagamento().equals(FormaDePagamento.BOLETO)) {
            return new PagamentoComBoleto(EstadoDoPagamento.PENDENTE, LocalDate.now().plusDays(5));
        }
        return new PagamentoComCartao(EstadoDoPagamento.PENDENTE, pagamento.getNumeroDeParcelas());
    }
}
