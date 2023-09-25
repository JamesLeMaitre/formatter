package com.mtj.formatterresponse.services;

import com.mtj.formatterresponse.dto.request.EmployeeRequest;
import com.mtj.formatterresponse.dto.responses.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse storeEmployee(EmployeeRequest request);
}
