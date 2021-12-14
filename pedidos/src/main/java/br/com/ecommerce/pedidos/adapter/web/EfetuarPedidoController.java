package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.pedidos.adapter.web.dto.entrada.PedidoRequest;
import br.com.ecommerce.pedidos.core.FinalizaPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ecommerce/pedidos")
public class EfetuarPedidoController {

   private final FinalizaPedidoService finalizaPedidoService;

   @Autowired
   public EfetuarPedidoController(FinalizaPedidoService finalizaPedidoService) {
      this.finalizaPedidoService = finalizaPedidoService;
   }

   @PostMapping
   public ResponseEntity<?> efetuarPedido(@RequestBody PedidoRequest request){
      finalizaPedidoService.efetuaPedido(request);
      return ResponseEntity.ok(request);
   }

}
