package br.com.ecommerce.security

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:8081/auth/realms/ecommerce/protocol/openid-connect/token/introspect")
interface TokenValidationHttpRequest {
    @Post(produces = [MediaType.APPLICATION_FORM_URLENCODED])
    fun validaToken(tokenValidationRequest: TokenValidationRequest): HttpResponse<Any>;
}