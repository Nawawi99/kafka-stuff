package dev.awn.paymentproducerservice.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.awn.paymentproducerservice.core.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private static final String TOPIC_NAME = "payment-topic";
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void sendMessage(String message) {
        Payment payment = new Payment("2342-fjse-34fk-33ed", 22.6, "Tire");
        kafkaTemplate.send(TOPIC_NAME, gson.toJson(payment));
        System.out.println("Message sent: " + message);
    }
}
