package com.knits.kncare.dto;

import com.knits.kncare.model.Role;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto extends AbstractSearchableDto {

    private Long id;
    private String onBoardDate;
    private String offBoardDate;
    //TODO: We have to add "country" to the Member model

//    //References:
    private EmployeeDtoTest employee;

    private Role role;



}
