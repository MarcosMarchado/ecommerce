package br.com.ecommerce.security

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:8081/auth/realms/ecommerce/protocol/openid-connect/token/introspect")
@Header(name = "Content-Type", value = "application/x-www-form-urlencoded")
interface TokenValidationHttpRequest {

    //@Post(consumes = [MediaType.APPLICATION_FORM_URLENCODED], produces = [MediaType.TEXT_PLAIN])
    @Post
    fun validaToken(@Body tokenValidationRequest: TokenValidationRequest): HttpResponse<TokenValidationResponse>;
}