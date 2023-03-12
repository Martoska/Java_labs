package com.example.demo.Controller;
import com.example.demo.core.exceptions.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<MyException> catchMissingValueHandler(MissingServletRequestParameterException e) {
        logger.error("MissingServletRequestParameterException has been throw");
        return ResponseEntity.status(400).body(new MyException("error", e.getMessage()));
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MyException> catchMissingArgumentType(MethodArgumentTypeMismatchException e){
        logger.error("MethodArgumentTypeMismatchException has been throw");
        return ResponseEntity.status(400).body(new MyException("error", e.getMessage()));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<MyException> catchAllException(Throwable e){
        logger.error("Some server exception has been throw ");
        return ResponseEntity.status(500).body(new MyException("error", e.getMessage()));
    }

}
