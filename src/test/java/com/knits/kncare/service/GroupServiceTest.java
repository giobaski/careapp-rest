package com.knits.kncare.service;

import com.knits.kncare.model.Group;
import com.knits.kncare.repository.GroupRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

//import static org.junit.jupiter.api.Assertions.*;
public class GroupServiceTest {


    @Test
    @DisplayName("Should Find Group By Id")
    void shouldFindGroupById() {
    }








    @Test
    @Disabled
    @DisplayName("Should throw RuntimeException")
    void ShouldFailWhenServiceThrowsException() {
        GroupService groupService = new GroupService(null,null,
                null, null, null);
        Group group = new Group();
        Assertions.assertThatThrownBy(
                ()-> { groupService.addMembersToGroup(group);}
        ).isInstanceOf(RuntimeException.class)
//                .hasMessageNotContaining("run");
                .hasMessage(null);
    }

//Todo: Test Create Group!!!!!!


    @Test
    @Disabled
    @DisplayName("Test should pass when memberships will be added to the group")
    void ShouldAddMembersToGroup() {
        GroupService groupService = new GroupService(null,null,
                null, null, null);
        Group group = new Group();
//        Assertions.assertTrue(1==1);
        Assertions.assertThat(1==1).isTrue();

    }

}