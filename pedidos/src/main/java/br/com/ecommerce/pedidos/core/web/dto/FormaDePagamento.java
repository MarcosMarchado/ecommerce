package br.com.ecommerce.pedidos.core.web.dto;

public enum FormaDePagamento {
    CARTAO_CREDITO {
        @Override
        public boolean validaMetodoDePagamento(Integer numeroDeParcelas) {
            if(numeroDeParcelas > 0) return true;
            return false;
        }
    }, BOLETO {
        @Override
        public boolean validaMetodoDePagamento(Integer numeroDeParcelas) {
            if(numeroDeParcelas == 0) return true;
            return false;
        }
    };

    public abstract boolean validaMetodoDePagamento(Integer numeroDeParcelas);
}
