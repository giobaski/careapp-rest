package com.knits.kncare.dto;

import com.knits.kncare.dto.search.AbstractSearchableDto;
import com.knits.kncare.model.ems.*;
import com.knits.kncare.model.history.*;
import com.knits.kncare.utils.Specifications;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto extends AbstractSearchableDto<EmployeeDto> {
    private Long id;

    private Long pdmId;

    private String firstName;

    private String lastName;

    private String internationalName;

    private String title;

    private String email;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Date birthDate;

    private String companyPhone;

    private String companyMobilePhone;

    private Gender gender;

    private Date startDate;

    private Date endDate;

    private Date dateOfLeave;

    private Employee hrReference;

    private Employee dottedLineManager;

    private Employee solidLineManager;

    private Country nationality;

    private BusinessUnit businessUnit;

    private CostCenter costCenter;

    private ManagementGroup managementGroup;

    private WorkingPosition workingPosition;

    private Office office;

    private Set<BusinessUnitHistoryRecord> businessUnitHistoryRecords;

    private Set<CostCenterHistoryRecord> costCenterHistoryRecordRecords;

    private Set<EmployeeHistoryRecord> employeeHistoryRecords;

    private Set<ManagementGroupHistoryRecord> groupManagementHistoryRecords;

    private Set<WorkingPositionHistoryRecord> workingPositionHistoryRecords;



}
