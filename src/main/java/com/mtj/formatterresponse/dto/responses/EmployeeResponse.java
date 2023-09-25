package com.mtj.formatterresponse.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse implements Serializable {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
