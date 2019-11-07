package by.zmitser.msscbeerservice.web.controller

import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.validation.ConstraintViolationException

@ControllerAdvice
class MvcExceptionHandler {


    @ExceptionHandler(ConstraintViolationException::class)
    fun validationErrorHandler(ex: ConstraintViolationException): ResponseEntity<List<String>> {
        return ResponseEntity(ex.constraintViolations.map { it.toString() }, BAD_REQUEST)
    }
}