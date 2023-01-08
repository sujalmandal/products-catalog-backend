package s.m.learn.product.lib.error.code;

public enum ErrorCode {
    INVALID_REQUEST("Invalid request"),
    MESSAGE_PUBLISH_FAILED("Failed to publish message");

    public String message;

    ErrorCode(final String message){
        this.message = message;
    }

}
