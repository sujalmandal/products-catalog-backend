package s.m.learn.product.lib.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import static s.m.learn.product.lib.error.code.ErrorCode.INVALID_REQUEST;

public final class JsonUtil {
    private JsonUtil(){}

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJson(final Object o){
        try{
            return OBJECT_MAPPER.writeValueAsString(o);
        } catch (final Exception e){
            throw ExceptionUtil.transform(e)
                    .setErrorCode(INVALID_REQUEST).setResponseStatus(HttpStatus.BAD_REQUEST);
        }
    }

}
