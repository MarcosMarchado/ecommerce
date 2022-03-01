package br.com.ecommerce.pedidos.adapter.advice;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class EcommerceExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        List<ErrorPadrao> errorPadraoList = new ArrayList<>();

        ex.getFieldErrors().forEach(fieldError -> {
            String message = String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage());
            errorPadraoList.add(new ErrorPadrao(message));
        });

        return ResponseEntity.badRequest().body(new ResponseError(errorPadraoList));
    }

    @ExceptionHandler({ResponseStatusException.class})
    public ResponseEntity<?> handleResponseStatusException(ResponseStatusException ex){
        var errorPadrao = new ErrorPadrao(ex.getReason());
        return ResponseEntity.status(ex.getStatus()).body(new ResponseError(List.of(errorPadrao)));
    }
}
