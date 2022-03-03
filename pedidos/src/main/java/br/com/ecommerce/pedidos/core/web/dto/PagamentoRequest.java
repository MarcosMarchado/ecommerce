package br.com.ecommerce.pedidos.core.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PagamentoRequest {
    private FormaDePagamento formaDePagamento;
    private Integer numeroDeParcelas;
}
