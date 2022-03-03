package br.com.ecommerce.pedidos.core.ports.mensageria;

public interface EnviadorDeMensagemPort {
    void enviaMensagem(String topico, Object object);
}
