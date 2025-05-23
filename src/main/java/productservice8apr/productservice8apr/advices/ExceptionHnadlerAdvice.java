package productservice8apr.productservice8apr.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import productservice8apr.productservice8apr.dtos.ExceptionResponseDtos.ExceptionHandlerDto;

@ControllerAdvice
@RestController
public class ExceptionHnadlerAdvice{
    @ExceptionHandler(Exception.class)
    public ExceptionHandlerDto handleRunTimeException(Exception e){
        ExceptionHandlerDto dto = new ExceptionHandlerDto();
        dto.setMessage(e.getMessage());
        dto.setStatus(e);
        return dto;
    }

}
