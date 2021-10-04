package br.com.academy.hexagonal.controller

import br.com.academy.hexagonal.convert.toAccountResponse
import br.com.academy.hexagonal.convert.toDomain
import br.com.academy.hexagonal.port.`in`.IAccountUserCasePort
import br.com.academy.hexagonal.request.AccountResquest
import br.com.academy.hexagonal.response.AccountResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
@RequestMapping("api/account")
class AccountController(private val accountUserCasePort: IAccountUserCasePort) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createAccount(@RequestBody @Valid accountRequest: AccountResquest): AccountResponse =
        accountUserCasePort.createAccount(accountRequest.toDomain()).toAccountResponse()

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll() : List<AccountResponse> =
        accountUserCasePort.accountFindAll().map { account ->  account.toAccountResponse()}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: UUID): AccountResponse =
        accountUserCasePort.findById(id).toAccountResponse()
}