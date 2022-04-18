package br.com.ecommerce.service

import br.com.ecommerce.EmailReply
import br.com.ecommerce.EmailRequest
import br.com.ecommerce.EmailServiceGrpc
import io.grpc.stub.StreamObserver
import jakarta.inject.Singleton


@Singleton
class EmailService : EmailServiceGrpc.EmailServiceImplBase() {

    override fun sendEmail(request: EmailRequest, responseObserver: StreamObserver<EmailReply>) {
        var response = EmailReply.newBuilder().setMessage("Olá ${request.nome} seu Pedido ${request.idPedido} " +
                "saiu pelo o valor total de ${request.valorPedido}").build();
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}