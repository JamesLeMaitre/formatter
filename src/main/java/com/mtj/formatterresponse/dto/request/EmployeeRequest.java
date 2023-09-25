package com.mtj.formatterresponse.dto.request;

import lombok.Data;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Data
public class EmployeeRequest implements Serializable {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String phone;
    @NonNull
    private String address;
}
