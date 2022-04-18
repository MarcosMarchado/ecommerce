package br.com.ecommerce.security

import io.grpc.Metadata
import io.grpc.Metadata.ASCII_STRING_MARSHALLER
import io.grpc.ServerCall
import io.grpc.ServerCallHandler
import io.grpc.ServerInterceptor
import io.micronaut.http.client.HttpClient
import jakarta.inject.Singleton

@Singleton
class RequestInterceptor(val httpClient: HttpClient, val tokenValidationHttpRequest: TokenValidationHttpRequest) : ServerInterceptor {

    //https://www.keycloak.org/docs/latest/securing_apps/#validating-access-tokens
    override fun <ReqT : Any, RespT : Any> interceptCall
            (call: ServerCall<ReqT, RespT>, headers: Metadata, next: ServerCallHandler<ReqT, RespT>)
            : ServerCall.Listener<ReqT> {

        var token: String? = headers.get(Metadata.Key.of("Authorization", ASCII_STRING_MARSHALLER)).toString()
        var bodyRequest = TokenValidationRequest("tJpSWInZF5410bbdrfXonxsbQtKhxbC3", "api-grpc-email", token.toString());

        try {
            val validaToken = tokenValidationHttpRequest.validaToken(bodyRequest)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return next.startCall(call, headers);
    }

}