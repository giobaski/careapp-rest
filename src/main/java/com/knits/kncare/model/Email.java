package com.knits.kncare.model;

import com.knits.kncare.model.base.AbstractMemberAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "email")
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Email extends AbstractMemberAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "subject")
    private String subject;

//    @Lob() // Lob was giving some very strange errors when trying to get model from DB. Replaced with columnDefinition.
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @ManyToMany
    @JoinTable(
            name = "email_recipient",
            joinColumns = {@JoinColumn(name = "email_id")},
            inverseJoinColumns = {@JoinColumn(name = "recipient_id")}
    )
    private Set<Member> recipients;

    @ManyToMany
    @JoinTable(
            name="email_recipient_group",
            joinColumns = {@JoinColumn(name = "email_id")},
            inverseJoinColumns = {@JoinColumn(name = "\"group_id\"")}
    )
    private Set<Group> recipientGroups;

    public boolean addRecipient(Member member) {
        return recipients.add(member);
    }

    public boolean removeRecipient(Member member) {
        return recipients.remove(member);
    }

    public boolean addGroup(Group group) {
        return recipientGroups.add(group);
    }

    public boolean removeGroup(Group group) {
        return recipientGroups.remove(group);
    }
}
