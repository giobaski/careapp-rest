package com.knits.kncare.dto.pages;

import com.knits.kncare.dto.EmployeeDto;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDtoPage {
    List<EmployeeDto> employees;
}
