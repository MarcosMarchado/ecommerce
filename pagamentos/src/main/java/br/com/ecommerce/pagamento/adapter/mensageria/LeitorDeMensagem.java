package br.com.ecommerce.pagamento.adapter.mensageria;

import br.com.ecommerce.pagamento.adapter.model.PagamentoEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LeitorDeMensagem {

    @KafkaListener(topics = "ECOMMERCE_PAGAMENTO", groupId = "consumidorDeMensagens", containerFactory = "kafkaListenerContainerFactory")
    public void consomeMennsagem(ConsumerRecord<String, PagamentoEntity> record){
        log.info("Consumindo mensagem {}", record.value().toString());
    }


}