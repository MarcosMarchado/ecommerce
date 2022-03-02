package br.com.ecommerce.pagamento.adapter.web;

import br.com.ecommerce.pagamento.adapter.web.dto.saida.DetalhesDoPagamentoResponse;
import br.com.ecommerce.pagamento.core.ports.ListaPagamentosServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/ecommerce/usuario/pagamentos")
public class ListaPagamentosDoUsuarioController {

    private final ListaPagamentosServicePort listaPagamentosServicePort;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<DetalhesDoPagamentoResponse>> listaPagamentosDoUsuario(@PathVariable Long idUsuario){
        var pagamentos = listaPagamentosServicePort.listaPagamentos(idUsuario);
        var pagamentoResponse = pagamentos.stream().map(pagamento -> DetalhesDoPagamentoResponse.obtemDadosDoPagamento(pagamento)).collect(Collectors.toList());
        return ResponseEntity.ok().body(pagamentoResponse);
    }

}
