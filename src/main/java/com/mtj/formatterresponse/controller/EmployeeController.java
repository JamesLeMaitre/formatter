package com.mtj.formatterresponse.controller;

import com.mtj.formatterresponse.dto.request.EmployeeRequest;
import com.mtj.formatterresponse.entityFormatter.HttpResponse;
import com.mtj.formatterresponse.handler.ExceptionHandler;
import com.mtj.formatterresponse.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mtj.formatterresponse.utils.AppUtils.successResponse;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "employee",produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class EmployeeController extends ExceptionHandler {
private final EmployeeService service;
    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> store(@Valid @RequestBody EmployeeRequest request, BindingResult result) {
        if (result.hasErrors()) {
            return this.createValidationHttpResponse("Fields error validation", result.getFieldErrors());
        }
        return ResponseEntity.status(CREATED).contentType(APPLICATION_JSON)
                .body(successResponse("Employee create successfully!", CREATED, service.storeEmployee(request),true));
    }
}
