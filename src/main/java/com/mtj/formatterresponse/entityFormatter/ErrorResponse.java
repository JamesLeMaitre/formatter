package com.mtj.formatterresponse.entityFormatter;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ErrorResponse extends HttpResponse implements Serializable {
    private Object validations;
    private String reason;
}