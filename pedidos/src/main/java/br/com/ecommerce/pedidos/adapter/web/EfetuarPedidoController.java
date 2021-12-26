package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.pedidos.adapter.web.dto.entrada.PedidoRequest;
import br.com.ecommerce.pedidos.core.ports.FinalizaPedidoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ecommerce/pedidos")
public class EfetuarPedidoController {

   private final FinalizaPedidoServicePort finalizaPedidoServicePort;

   @Autowired
   public EfetuarPedidoController(FinalizaPedidoServicePort finalizaPedidoServicePort) {
      this.finalizaPedidoServicePort = finalizaPedidoServicePort;
   }

   @PostMapping
   public ResponseEntity<?> efetuarPedido(@RequestBody PedidoRequest request){
      finalizaPedidoServicePort.efetuaPedido(request);
      return ResponseEntity.ok(request);
   }

}
