package com.knits.kncare.dto;

import com.knits.kncare.model.ems.CostCenter;
import com.knits.kncare.model.ems.ManagementGroup;
import com.knits.kncare.model.ems.Office;
import com.knits.kncare.model.ems.WorkingPosition;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
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

    private String country;

    //References:
    private BusinessUnitDto businessUnit;

    private CostCenter costCenter;

    private ManagementGroup managementGroup;

    private WorkingPosition workingPosition;

    private Office office;




}
