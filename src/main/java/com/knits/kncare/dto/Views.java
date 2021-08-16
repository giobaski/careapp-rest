package com.knits.kncare.dto;

public interface Views {

    public interface EntityData {}
    public static interface Common {}
    public static interface GroupDetails {}
    public static interface GroupMembership extends Common{}
    public static interface GroupMembers extends Common{}
    public interface MemberDetails extends EntityData {}
    public interface EmailDetails extends EntityData {}
    public interface EmailSentDetails extends EntityData {}
}
