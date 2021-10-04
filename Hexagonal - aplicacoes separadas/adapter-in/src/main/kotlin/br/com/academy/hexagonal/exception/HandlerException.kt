package br.com.academy.hexagonal.exception


//@ControllerAdvice
//class HandlerException {
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
//    fun methodArgumentNotValidException(methodArgumentNotValidException: MethodArgumentNotValidException) =
//        ResponseHandlerDetail(
//           statusCode = HttpStatus.BAD_REQUEST.value(),
//           classeDeError = methodArgumentNotValidException.javaClass.name,
//           errosMensagem = methodArgumentNotValidException.bindingResult
//                                .fieldErrors.map {
//                                           fieldError ->  fieldError.field
//                                }.toList()
//          )
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(value = [Exception::class])
//    fun handelerInternalServerErroException(exception: Exception) =
//        ResponseHandlerDetail(
//            statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value(),
//            classeDeError = exception.javaClass.name,
//            errosMensagem = listOf(exception.message!!)
//        )
//
//}
//
//data class ResponseHandlerDetail(
//                         val dataTime: LocalDateTime = LocalDateTime.now(),
//                         val statusCode: Int,
//                         val classeDeError: String,
//                         val errosMensagem: List<String>? = null,
//                         val listaCamposObrigatorios: Map<String, String>? = null)