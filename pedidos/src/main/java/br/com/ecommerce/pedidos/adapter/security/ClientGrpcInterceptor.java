package br.com.ecommerce.pedidos.adapter.security;

import io.grpc.*;

public class ClientGrpcInterceptor implements ClientInterceptor {

    public static Metadata metadataHeaders = new Metadata();

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
                                                               CallOptions callOptions, Channel next) {

        ClientCall<ReqT, RespT> clientCall = next.newCall(method, callOptions);

        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(clientCall) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                super.start(responseListener, metadataHeaders);
            }
        };
    }
}