package br.com.ecommerce.pedidos.adapter.web.dto.entrada;

import lombok.Getter;

@Getter
public class PagamentoRequest {
    private FormaDePagamento formaDePagamento;
    private Integer numeroDeParcelas;
}
