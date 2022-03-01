package br.com.ecommerce.pedidos.adapter.web.dto.entrada;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class PagamentoRequest {

    private FormaDePagamento formaDePagamento;
    @NotNull
    private Integer numeroDeParcelas;
}
