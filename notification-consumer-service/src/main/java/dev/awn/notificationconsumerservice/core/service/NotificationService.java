package dev.awn.notificationconsumerservice.core.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final String TOPIC_NAME = "payment-topic";
    private final String GROUP_ID = "notification-group";

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void receivePayment(String payment) {
        System.out.println(payment);
        sendNotification();
    }
    public void sendNotification() {
        System.out.println("Sending notification after payment invoice was received from payment service");
    }

}
