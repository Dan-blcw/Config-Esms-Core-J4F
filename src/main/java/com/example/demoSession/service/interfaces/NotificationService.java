package com.example.demoSession.service.interfaces;

public interface NotificationService {
    String sendSMS(String phone, String message);
    String sendVoiceOTP(String phone, String otp);
}
