package com.mtj.formatterresponse.controller;

import com.mtj.formatterresponse.dataFormatter.DataFormatter;
import com.mtj.formatterresponse.dto.request.EmployeeRequest;
import com.mtj.formatterresponse.dto.responses.EmployeeResponse;
import com.mtj.formatterresponse.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "employees", produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class EmployeeDataFormatterController extends DataFormatter<EmployeeResponse> {

    private final EmployeeService service;
    @PostMapping("add")
    public Object create(@Valid @RequestBody EmployeeRequest data, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return renderErrorData(false, result.getFieldErrors(),"Fields error validation");
            }
            return  renderData(true, service.storeEmployee(data),"Create ");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return  renderStringData(false,"Error while procssing" ,exceptionAsString);
        }

    }
}
