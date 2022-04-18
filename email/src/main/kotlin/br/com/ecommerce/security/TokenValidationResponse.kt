package br.com.ecommerce.security

import com.fasterxml.jackson.annotation.JsonProperty

data class TokenValidationResponse(
    @JsonProperty("active")
    val active: Boolean
)