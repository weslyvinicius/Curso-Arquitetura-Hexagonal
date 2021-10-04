package br.com.academy.hexagonal.request

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class AccountResquest(
    @field:NotBlank val name: String,
    @Min(1) val agencyNumber: Int,
    @Min(1) val accountNumber: Int
)
