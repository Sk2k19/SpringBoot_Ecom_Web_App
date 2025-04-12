package productservice8apr.productservice8apr.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import productservice8apr.productservice8apr.dtos.ExceptionResponseDtos.ExceptionHandlerDto;

@ControllerAdvice
public class ExceptionHnadlerAdvice{
    @ExceptionHandler(Exception.class)
    public ExceptionHandlerDto handleRunTimeException(Exception e){
        ExceptionHandlerDto dto = new ExceptionHandlerDto();
        dto.setMessage(e.getMessage());
        dto.setStatus(e);
        return dto;
    }

}
