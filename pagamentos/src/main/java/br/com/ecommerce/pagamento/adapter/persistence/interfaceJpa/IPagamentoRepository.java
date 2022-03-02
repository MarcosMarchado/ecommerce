package br.com.ecommerce.pagamento.adapter.persistence.interfaceJpa;


import br.com.ecommerce.pagamento.adapter.model.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPagamentoRepository extends JpaRepository<PagamentoEntity, Long> {
    List<PagamentoEntity> findByIdUsuario(Long idUsuario);
}
