# Config-Esms-Core-J4F
## Prerequisites
- JDK 19
- Maven
- Postgres
## Set request body as raw with JSON payload
PostRequest sms-access and voice-otp (they are the same)
```
{
    "phone" : "16543165",
    "message" : "What's up"
}
```It Work! method sendSMS normal active, from NotificationServiceImpl
## PostMan
#### PostRequest sms-access success
![image](https://user-images.githubusercontent.com/127305381/229307955-20240436-b261-428f-b4f2-84805ae2f559.png)
#### PostRequest sms-access failure
![image](https://user-images.githubusercontent.com/127305381/229308179-bda9e313-08f7-4aeb-b02d-99ed07736d8f.png)
## Summary chart
```
- src
     - main
           -* com.example.demoSession
                  - controller
                          - runController.java
                  - model
                      - dtos
                          - EsmsRequestDto.java
                          - EsmsResponseDto.java
                  - request
                          - SendSMSRequest.java
                  - service
                      - interfaces
                             -- NotificationService.java
                          - NotificationServiceImpl.java
                  - DemoEsmsApplication.java
     - resources
                  -application.properties
- pom.xml
```
## Final
Oke, That's all and i'm Dan
