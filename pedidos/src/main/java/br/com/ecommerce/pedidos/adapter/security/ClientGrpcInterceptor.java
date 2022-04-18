package br.com.ecommerce.pedidos.adapter.security;

import io.grpc.*;

public class ClientGrpcInterceptor implements ClientInterceptor {

    public static Metadata metadataHeaders = new Metadata();

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
                                                               CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                /*Metadata headers1 = ClientGrpcInterceptor.headers;
                headers.put(Metadata.Key.of("HOSTNAME", ASCII_STRING_MARSHALLER), "MY_HOST");*/
                super.start(responseListener, metadataHeaders);
            }
        };
    }
}