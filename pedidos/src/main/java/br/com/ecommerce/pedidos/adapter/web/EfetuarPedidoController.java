package br.com.ecommerce.pedidos.adapter.web;

import br.com.ecommerce.EmailRequest;
import br.com.ecommerce.EmailServiceGrpc;
import br.com.ecommerce.pedidos.adapter.security.ClientGrpcInterceptor;
import br.com.ecommerce.pedidos.adapter.web.dto.entrada.PedidoRequest;
import br.com.ecommerce.pedidos.core.ports.FinalizaPedidoServicePort;
import io.grpc.Metadata;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ecommerce/pedidos")
public class EfetuarPedidoController {

   private final FinalizaPedidoServicePort finalizaPedidoServicePort;
   private final ModelMapper modelMapper;
   private final EmailServiceGrpc.EmailServiceBlockingStub emailGrpcService;


   @PostMapping
   public ResponseEntity<?> efetuarPedido(@Valid @RequestBody PedidoRequest request,
                                          @RequestHeader("Authorization") String token){
      var pedidoRequest = modelMapper.map(request, br.com.ecommerce.pedidos.core.web.dto.PedidoRequest.class);
      pedidoRequest.setaPagamento(request.getPagamento().getFormaDePagamento().name());
      finalizaPedidoServicePort.efetuaPedido(pedidoRequest);

        /*Grpc send*/
        ClientGrpcInterceptor.metadataHeaders.put(Metadata.Key.of("Authorization", ASCII_STRING_MARSHALLER), token);
        EmailRequest emailRequest = buildEmailGrpcRequest();
        try {
            emailGrpcService.sendEmail(emailRequest);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

      return ResponseEntity.ok(pedidoRequest);
   }

   private EmailRequest buildEmailGrpcRequest(){
      return EmailRequest.newBuilder()
              .setIdPedido("1") //ID para testes
              .setNome("Marcos Machado")
              .setValorPedido(980.0)
              .build();
   }

}
