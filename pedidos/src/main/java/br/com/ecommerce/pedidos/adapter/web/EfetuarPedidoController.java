package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.pedidos.adapter.web.dto.entrada.PedidoRequest;
import br.com.ecommerce.pedidos.core.ports.FinalizaPedidoServicePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ecommerce/pedidos")
public class EfetuarPedidoController {

   private final FinalizaPedidoServicePort finalizaPedidoServicePort;
   private final ModelMapper modelMapper;

   @PostMapping
   public ResponseEntity<?> efetuarPedido(@Valid @RequestBody PedidoRequest request){
      var pedidoRequest = modelMapper.map(request, br.com.ecommerce.pedidos.core.web.dto.PedidoRequest.class);
      finalizaPedidoServicePort.efetuaPedido(pedidoRequest);
      return ResponseEntity.ok(pedidoRequest);
   }

}
