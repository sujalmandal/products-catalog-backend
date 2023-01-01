package s.m.learn.product.common.lib.model;

public class GenericResponse<T> {

    private Status status;
    private String message;
    private T data;

    public static <T> GenericResponse<T> create(T data){
        return new GenericResponse<>();
    }

    public static <T> GenericResponse<T> create(){
        return new GenericResponse<>();
    }

    public Status getStatus() {
        return status;
    }

    public GenericResponse<T> setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public GenericResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public GenericResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public enum Status{
        SUCCESS,
        FAILURE
    }


}
