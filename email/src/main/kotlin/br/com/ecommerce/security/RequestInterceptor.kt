package br.com.ecommerce.security

import io.grpc.*
import io.grpc.Metadata.ASCII_STRING_MARSHALLER
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton

@Singleton
class RequestInterceptor(val tokenValidationHttpRequest: TokenValidationHttpRequest) : ServerInterceptor {

    //https://www.keycloak.org/docs/latest/securing_apps/#validating-access-tokens
    override fun <ReqT : Any, RespT : Any> interceptCall(call: ServerCall<ReqT, RespT>, headers: Metadata, next: ServerCallHandler<ReqT, RespT>)
        : ServerCall.Listener<ReqT> {

        val token: String? = headers.get(Metadata.Key.of("Authorization", ASCII_STRING_MARSHALLER)).toString()
        val tokenSemBearer = token.toString().replace("Bearer", "").trim()

        val bodyRequest = TokenValidationRequest("tJpSWInZF5410bbdrfXonxsbQtKhxbC3", "api-grpc-email", tokenSemBearer);

        try {
            val validaToken: HttpResponse<TokenValidationResponse> = tokenValidationHttpRequest.validaToken(bodyRequest)
            if(!validaToken.body().active){
                RetornaErro(call, headers)
            }
        } catch (e: Exception) {
            RetornaErro(call, headers)
        }
        return next.startCall(call, headers);
    }

    private fun <ReqT : Any, RespT : Any> RetornaErro(call: ServerCall<ReqT, RespT>, headers: Metadata) {
        val status: Status = Status.PERMISSION_DENIED.augmentDescription("Token Inválido")
        call.close(status, headers);
    }

}