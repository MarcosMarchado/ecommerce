package br.com.ecommerce.pedidos.adapter.configuration.external;

import br.com.ecommerce.EmailServiceGrpc;
import br.com.ecommerce.pedidos.adapter.security.ClientGrpcInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcServiceConfig {

    @Bean
    public EmailServiceGrpc.EmailServiceBlockingStub grpcChannelConfig(){

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .intercept(new ClientGrpcInterceptor())
                .build();

        return EmailServiceGrpc.newBlockingStub(channel);
    }

}
