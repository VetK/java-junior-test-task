package com.exceptions;

import com.dto.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerService {
    @ResponseStatus(HttpStatus.BAD_REQUEST)


    @ExceptionHandler({LocationAlreadyExist.class, LocationNotAvailable.class, LocationNotExist.class,
                        RouteNotExist.class})

    @ResponseBody
    public ErrorInfo handleBadRequestTenant(HttpServletRequest request, Exception e) {
        return new ErrorInfo().setMessage(e.getMessage())
                .setDeveloperMessage(e.toString())
                .setUri(request.getRequestURI());
    }

}
