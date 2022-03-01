package br.com.ecommerce.pedidos.core.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class PagamentoRequest {

    private FormaDePagamento formaDePagamento;
    @NotNull
    private Integer numeroDeParcelas;
}
