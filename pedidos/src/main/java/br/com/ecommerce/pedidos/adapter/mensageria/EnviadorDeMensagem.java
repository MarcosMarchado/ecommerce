package br.com.ecommerce.pedidos.adapter.mensageria;

import br.com.ecommerce.pedidos.core.ports.mensageria.EnviadorDeMensagemPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EnviadorDeMensagem implements EnviadorDeMensagemPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void enviaMensagem(String topico, Object object){
        kafkaTemplate.send(topico, object).addCallback(
                success -> log.info("Informações enviadas {}", success.getProducerRecord().value()),
                failure -> log.info("Deu error")
        );
    }

}
