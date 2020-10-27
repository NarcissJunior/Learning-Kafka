package br.com.narciso;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.HashMap;

public class FraudDetectorService {

    public static void main (String[] args) throws InterruptedException {
        var fraudService = new FraudDetectorService();

        try (var service = new KafkaService<>(FraudDetectorService.class.getSimpleName(),
                "ECOMMERCE_NEW_ORDER",
                fraudService::parse,
                Order.class,
                new HashMap<>())) {
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, Order> record) {
        System.out.println("-------------------------------------------");
        System.out.println("Processando nova ordem, checando fraude");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //ignorando
            e.printStackTrace();
        }
        System.out.println("Ordem processada!");
    }
}
