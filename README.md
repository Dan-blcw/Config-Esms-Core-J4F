# Config-Esms-Core-J4F
## Prerequisites
- JDK 19
- Maven
- Postgres
## Set request body as raw with JSON payload
#### PostRequest sms-access and voice-otp (they are the same)

```
{
    "phone" : "16543165",
    "message" : "What's up"
}
```
## PostMan
#### PostRequest sms-access success
![image](https://user-images.githubusercontent.com/127305381/229307955-20240436-b261-428f-b4f2-84805ae2f559.png)
#### PostRequest sms-access failure
![image](https://user-images.githubusercontent.com/127305381/229308431-713d1506-0102-4d4e-85c2-443095a8a69b.png)
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
