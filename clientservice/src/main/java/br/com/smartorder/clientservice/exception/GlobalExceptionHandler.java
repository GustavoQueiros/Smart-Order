package br.com.smartorder.clientservice.exception;

import br.com.smartorder.clientservice.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<ErrorDTO> handleEmailAlreadyUsedException(EmailAlreadyUsedException exception) {
        return ResponseEntity.badRequest().body(new ErrorDTO(exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGenericException(Exception exception) {
        //Todo: Implementar logs
        return ResponseEntity.internalServerError().body(new ErrorDTO("An unexpected error ocurred"));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(exception.getMessage()));
    }

}
