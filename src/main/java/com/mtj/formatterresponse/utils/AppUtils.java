package com.mtj.formatterresponse.utils;

import com.mtj.formatterresponse.entityFormatter.HttpResponse;
import com.mtj.formatterresponse.entityFormatter.SuccessResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AppUtils {
    public static final String CURRENT_URL = "api/v1/ddb";
    public static <T> HttpResponse successResponse(String message, HttpStatusCode status, T data, boolean success) {
        return Optional.of(data).map(t -> SuccessResponse.builder().data(t).build()).stream()
                .peek(successResponse -> successResponse.setMessage(message))
                .peek(successResponse -> successResponse.setStatus(status))
                .peek(successResponse -> successResponse.setSuccess(success))
                .findFirst().orElseThrow();
    }
}
