package com.knits.kncare.email;

import com.knits.kncare.model.Email;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.Member;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EmailSender {

    private final JavaMailSender emailSender;

    public EmailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendDraft(Email draft) throws MessagingException {

        Set<Member> recipients = draft.getRecipients();
        recipients.addAll(
                draft.getRecipientGroups().stream()
                        .map(Group::getGroupMembers)
                        .flatMap(Set::stream)
                        .collect(Collectors.toSet())
        );
        for (Member recipient : recipients) {
            sendEmail(draft.getCreatedBy(), recipient, draft.getSubject(), draft.getContent(), new HashMap<>());
        }

    }

    public void sendEmail(Member sender, Member recipient, String subject, String contents, Map<String, String> attachments) throws MessagingException {
        MimeMessage email = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(email, true);

        helper.setFrom(sender.getEmployee().getEmail());
        helper.setTo(recipient.getEmployee().getEmail());
        helper.setSubject(subject);
        helper.setText(contents);


        for (Map.Entry<String, String> entry: attachments.entrySet()) {
            FileSystemResource file
                    = new FileSystemResource(new File(entry.getValue()));
            helper.addAttachment(entry.getKey(), file);
        }


        emailSender.send(email);
    }



}
