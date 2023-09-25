package com.mtj.formatterresponse.entityFormatter;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorFieldResponse implements Serializable {
    private String field;
    private String defaultMessage;
}