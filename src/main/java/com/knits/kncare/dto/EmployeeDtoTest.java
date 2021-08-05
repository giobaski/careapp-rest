package com.knits.kncare.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDtoTest extends AbstractSearchableDto {

    private Long id;

    private Long pdmId;

    private String firstName;

    private String lastName;

    private String internationalName;

    private String email;

    private String title;

    //References:
    private BusinessUnitDto businessUnit;




}
