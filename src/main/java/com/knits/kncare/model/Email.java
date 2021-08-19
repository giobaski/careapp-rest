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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Member addRecipient(Member member) {
        return recipients.remove(member) ? member : null;
    }

    public Member removeRecipient(Member member) {
        return recipients.remove(member) ? member : null;
    }

    public Group addGroup(Group group) {
        return recipientGroups.add(group) ? group : null;
    }

    public Group removeGroup(Group group) {
        return recipientGroups.remove(group) ? group : null;
    }
}
