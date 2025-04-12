package productservice8apr.productservice8apr.Exceptions;

import productservice8apr.productservice8apr.dtos.ExceptionResponseDtos.ExceptionHandlerDto;

public class InvalidProductIdExp extends RuntimeException {
    public InvalidProductIdExp(String message) {
        super(message);

    }
}
