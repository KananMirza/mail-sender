package com.company.orient.sendmail.controller;

import com.company.orient.sendmail.dto.MailRequestDto;
import com.company.orient.sendmail.response.ResponseApi;
import com.company.orient.sendmail.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/email")
@Slf4j
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<ResponseApi> sendEmail(@RequestBody @Valid MailRequestDto mailRequestDto){
        String response = emailService.sendEmail(mailRequestDto);
        ResponseApi responseApi = new ResponseApi();
        responseApi.setStatus(HttpStatus.OK.value());
        responseApi.setMessage(response);
        return ResponseEntity.ok(responseApi);
    };
}
