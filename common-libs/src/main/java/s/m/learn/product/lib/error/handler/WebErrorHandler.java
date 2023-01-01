package s.m.learn.product.common.lib.error.handler;

import s.m.learn.product.common.lib.model.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

import static s.m.learn.product.common.lib.model.GenericResponse.Status.FAILURE;

@ControllerAdvice
public class WebErrorHandler {
    private static final Logger LOG = LoggerFactory.getLogger(WebErrorHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GenericResponse<Map<String, String>> convertValidationErrorToFailedResponse(
            final MethodArgumentNotValidException exception, final HttpServletRequest request){
        LOG.info("converting {} to Generic error response..", exception.getClass());
        return GenericResponse.create(Map.of(
                Optional.ofNullable(exception.getParameter().getParameterName()).orElse("undefined"),exception.getMessage()))
                .setStatus(FAILURE).setMessage(exception.getMessage());
    }

}
