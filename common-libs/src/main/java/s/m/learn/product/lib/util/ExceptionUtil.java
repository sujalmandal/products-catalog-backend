package s.m.learn.product.lib.util;

import s.m.learn.product.lib.error.handler.ApplicationException;

public final class ExceptionUtil {

    private ExceptionUtil(){}

    public static <FROM extends Exception> ApplicationException transform(final FROM exception){
        return ApplicationException.create(exception).setMessage(exception.getMessage());
    }
}
