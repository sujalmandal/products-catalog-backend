package s.m.learn.product.lib.error.handler;

import org.springframework.http.HttpStatus;
import s.m.learn.product.lib.error.code.ErrorCode;

public class ApplicationException extends RuntimeException {

    private ErrorCode errorCode;
    private String message;
    private HttpStatus responseStatus;

    private ApplicationException() {}

    private ApplicationException(final Throwable cause) {
        super(cause);
    }

    public static ApplicationException create(){
        return new ApplicationException();
    }

    public static ApplicationException create(final Exception e){
        return new ApplicationException(e);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public ApplicationException setErrorCode(final ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.setMessage(errorCode.message);
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ApplicationException setMessage(String message) {
        this.message = message;
        return this;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public ApplicationException setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
        return this;
    }
}
