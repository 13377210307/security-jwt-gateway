package common.exceptions;

import lombok.Data;

@Data
public class CustomException extends Exception{

    private Integer code;

    private String message;

    public CustomException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
