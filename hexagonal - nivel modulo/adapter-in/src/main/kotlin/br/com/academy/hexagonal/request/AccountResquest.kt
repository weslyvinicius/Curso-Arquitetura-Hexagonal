package br.com.academy.hexagonal.adapter.`in`.web.request

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AccountResquest(
    @field:NotBlank val name: String,
    @Min(1) val agencyNumber: Int,
    @Min(1) val accountNumber: Int
)
