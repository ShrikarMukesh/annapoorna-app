package com.annapoorna.kafka;

import com.annapoorna.entity.InventoryItem;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaInventoryConsumer {

    @KafkaListener(topics = "inventory-topic", groupId = "group-id")
    public void listen(InventoryItem item) {
        System.out.println("Received inventory item: " + item);
        // Process the inventory item received from Kafka
    }
}
