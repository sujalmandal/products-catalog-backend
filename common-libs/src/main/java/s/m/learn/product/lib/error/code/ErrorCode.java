package s.m.learn.product.lib.error.code;

public enum ErrorCode {
    INVALID_REQUEST("Invalid request");

    public String message;

    ErrorCode(final String message){
        this.message = message;
    }

}
