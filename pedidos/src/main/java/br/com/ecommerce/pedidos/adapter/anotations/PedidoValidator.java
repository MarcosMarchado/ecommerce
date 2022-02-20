package br.com.ecommerce.pedidos.adapter.anotations;

import br.com.ecommerce.pedidos.adapter.web.dto.entrada.PedidoRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PedidoValidator implements ConstraintValidator<Pedido, PedidoRequest> {

    @Override
    public void initialize(Pedido constraintAnnotation) {

    }

    @Override
    public boolean isValid(PedidoRequest value, ConstraintValidatorContext context) {
        var pagamento = value.getPagamento();
        var numeroDeParcelas = Objects.isNull(pagamento.getNumeroDeParcelas()) ? 0 : pagamento.getNumeroDeParcelas();
        return pagamento.getFormaDePagamento().validaMetodoDePagamento(numeroDeParcelas);
    }
}
