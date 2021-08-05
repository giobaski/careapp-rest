package com.knits.kncare.dto;

import com.knits.kncare.model.ems.Employee;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessUnitDto extends AbstractSearchableDto {

    private Long id;

    private String name;

    private String description;

}
