package br.com.academy.hexagonal.adapter.`in`.web.controller

import br.com.academy.hexagonal.adapter.`in`.web.convert.toAccountResponse
import br.com.academy.hexagonal.adapter.`in`.web.convert.toDomain
import br.com.academy.hexagonal.adapter.`in`.web.request.AccountResquest
import br.com.academy.hexagonal.adapter.`in`.web.response.AccountResponse
import br.com.academy.hexagonal.aplication.port.`in`.IAccountUserCasePort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("api/account")
class AccountController(private val accountUserCasePort: IAccountUserCasePort) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createAccount(@RequestBody @Valid accountRequest: AccountResquest) =
        accountUserCasePort.createAccount(accountRequest.toDomain())

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll() : List<AccountResponse> =
        accountUserCasePort.accountFindAll().map { account ->  account.toAccountResponse()}
}