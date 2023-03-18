package com.example.demoSession.controller;


import com.example.demoSession.request.SendSMSRequest;
import com.example.demoSession.service.interfaces.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class runController {
    private final NotificationService notificationService;

    @PostMapping("/sms-access")
    public ResponseEntity<?> sendSMS(@RequestBody SendSMSRequest sendSMSRequest) {
        return ResponseEntity.ok(notificationService.sendSMS(sendSMSRequest.getPhone(), sendSMSRequest.getMessage()));
    }

    @PostMapping("/voice-otp")
    public ResponseEntity<?> sendVoiceOTP(@RequestBody SendSMSRequest sendSMSRequest) {
        return ResponseEntity.ok(notificationService.sendVoiceOTP(sendSMSRequest.getPhone(), sendSMSRequest.getMessage()));
    }
}
