package co.g2academy.indoapril_1.response.loginresponse;

import org.springframework.http.HttpStatus;

public class BaseResponse <T> {

    private HttpStatus code;
    private String status;
    private T data;
    private String message;

    public HttpStatus getCode(){ return code; }

    public String getStatus(){ return status; }

    public T getData(){ return data; }

    public String getMessage() { return message; }

    public BaseResponse (HttpStatus code, String status, T data, String message){
        this.code = code;
        this.status = status;
        this.data = data;
        this.message = message;
    }
}

