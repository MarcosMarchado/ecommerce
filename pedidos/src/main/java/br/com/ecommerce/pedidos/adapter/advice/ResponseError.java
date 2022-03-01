package br.com.ecommerce.pedidos.adapter.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {

    private List<ErrorPadrao> mensagens;

}
