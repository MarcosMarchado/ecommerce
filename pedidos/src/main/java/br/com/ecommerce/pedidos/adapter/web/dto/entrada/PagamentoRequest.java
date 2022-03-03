package br.com.ecommerce.pedidos.adapter.web.dto.entrada;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class PagamentoRequest {

    private FormaDePagamento formaDePagamento;
    @NotNull
    private Integer numeroDeParcelas;
}
