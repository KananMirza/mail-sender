package com.company.orient.sendmail.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailRequestDto {
    @NotNull(message = "Mail to is required!")
    String to;
    @NotNull(message = "Mail subject is required!")
    String subject;
    @NotNull(message = "Mail message is required!")
    String text;
}
