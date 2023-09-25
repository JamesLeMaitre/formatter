package com.mtj.formatterresponse.services.impls;

import com.mtj.formatterresponse.dto.request.EmployeeRequest;
import com.mtj.formatterresponse.dto.responses.EmployeeResponse;
import com.mtj.formatterresponse.entities.Employee;
import com.mtj.formatterresponse.repositories.EmployeeRepository;
import com.mtj.formatterresponse.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse storeEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(request, employee);
        employeeRepository.save(employee);
        EmployeeResponse response = new EmployeeResponse();
        BeanUtils.copyProperties(employee, response);
        return response;
    }
}
