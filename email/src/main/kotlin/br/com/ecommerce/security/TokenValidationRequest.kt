package br.com.ecommerce.security

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected

@Introspected
data class TokenValidationRequest(
    //@JsonProperty("client_secret")
    val client_secret: String,
    //@JsonProperty("client_id")
    val client_id: String,
    //@JsonProperty("token")
    val token: String
)