package com.example.demoSession.service;


import com.example.demoSession.model.dto.EsmsRequestDto;
import com.example.demoSession.model.dto.EsmsResponseDto;
import com.example.demoSession.service.interfaces.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class NotificationServiceImpl implements NotificationService {
    @Value("${esms.key.api}")
    private String apiKey;

    @Value("${esms.key.secret}")
    private String secretKey;

    @Value("${esms.sms.url}")
    private String eSmsUrl;

    @Value("${esms.voiceotp.url}")
    private String eVoiceOtpUrl;

    private static final String ESMS_SMS_TYPE = "8";
    private static final String ESMS_SUCCESS = "100";

    @Override
    public String sendSMS(String phone, String message) {
        try {
            EsmsRequestDto eSmsRequest = EsmsRequestDto.builder()
                    .apiKey(apiKey)
                    .secretKey(secretKey)
                    .phone(phone)
                    .content(message)
                    .smsType(ESMS_SMS_TYPE)
                    .build();
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<EsmsRequestDto> request = new HttpEntity<>(eSmsRequest);
            ResponseEntity<EsmsResponseDto> response = restTemplate.exchange(
                    eSmsUrl,
                    HttpMethod.POST,
                    request,
                    EsmsResponseDto.class);
            EsmsResponseDto eSmsResponse = response.getBody();
            log.info("Send sms to phone {} response {}",
                    phone,
                    eSmsResponse.getCodeResult());
            if (ESMS_SUCCESS.equals(eSmsResponse.getCodeResult())) {
                return "It Work! method sendSMS normal active ";
            }
        } catch (Exception ex) {
            log.info("Send sms to phone {} error {}", phone, ex);
        }
        return "It not Work! method sendSMS";
    }

    @Override
    public String sendVoiceOTP(String phone, String otp) {
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(eVoiceOtpUrl)
                    .queryParam("ApiKey", apiKey)
                    .queryParam("SecretKey", secretKey)
                    .queryParam("Phone", phone)
                    .queryParam("Code", otp)
                    .queryParam("Speed", "-1")
                    .queryParam("Voice", "female");
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);
            ResponseEntity<EsmsResponseDto> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    EsmsResponseDto.class);
            EsmsResponseDto eSmsResponse = response.getBody();
            log.info("Send voice otp to phone {} response {}", phone, eSmsResponse.getCodeResult());
            if (ESMS_SUCCESS.equals(eSmsResponse.getCodeResult())) {
                return "It Work! method sendVoiceOTP normal active ";
            }
        } catch (Exception ex) {
            log.info("Send voice otp to phone {} error {}", phone, ex);
        }
        return "It not Work! method sendVoiceOTP";
    }
}
