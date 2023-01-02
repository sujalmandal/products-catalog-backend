package s.m.learn.product.lib.error.handler;

import org.springframework.web.bind.annotation.ResponseBody;
import s.m.learn.product.lib.model.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static s.m.learn.product.lib.model.GenericResponse.Status.FAILURE;

@ControllerAdvice
public class WebErrorHandler {
    private static final Logger LOG = LoggerFactory.getLogger(WebErrorHandler.class);

    /**
     * convert exceptions thrown due to constraints violation due to @Valid annotation in the methods
     *
     * @param exception
     * @param request
     *
     * @return GenericResponse
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GenericResponse<Map<String, String>> convertValidationErrorToFailedResponse(
            final MethodArgumentNotValidException exception, final HttpServletRequest request){
        LOG.info("converting {} to Generic error response..", exception.getClass());
        Map<String, String> resObj = new HashMap<>();
        if (exception.getErrorCount() > 0) {
            exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
                resObj.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
        }
        return GenericResponse.create(resObj).setStatus(FAILURE).setMessage("Bad request : input validation failed.");
    }

}
