package com.annapoorna.service;

import com.annapoorna.entity.InventoryItem;
import com.annapoorna.kafka.KafkaInventoryProducer;
import com.annapoorna.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryItemRepository repository;

    @Autowired
    private KafkaInventoryProducer kafkaInventoryProducer;

    public List<InventoryItem> getAllItems() {
        return repository.findAll();
    }

    public InventoryItem getItemById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void saveItem(InventoryItem item) {
        repository.save(item);
        kafkaInventoryProducer.sendMessage(item); // Send inventory item details to Kafka
    }

    public void deleteItemById(String id) {
        repository.deleteById(id);
    }

    public List<InventoryItem> getItemsByName(String name) {
        return repository.findByName(name);
    }

    public List<InventoryItem> getItemsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public void updateItemQuantity(String id, int quantity) {
        InventoryItem item = repository.findById(id).orElse(null);
        if (item != null) {
            item.setQuantity(quantity);
            repository.save(item);
            kafkaInventoryProducer.sendMessage(item); // Send updated inventory item details to Kafka
        }
    }

    public void updateItemPrice(String id, double price) {
        InventoryItem item = repository.findById(id).orElse(null);
        if (item != null) {
            item.setPrice(price);
            repository.save(item);
            kafkaInventoryProducer.sendMessage(item); // Send updated inventory item details to Kafka
        }
    }

    public void restockItem(String id, int quantity) {
        InventoryItem item = repository.findById(id).orElse(null);
        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);
            repository.save(item);
            kafkaInventoryProducer.sendMessage(item); // Send updated inventory item details to Kafka
        }
    }

    public void sellItem(String id, int quantity) {
        InventoryItem item = repository.findById(id).orElse(null);
        if (item != null) {
            int availableQuantity = item.getQuantity();
            if (availableQuantity >= quantity) {
                item.setQuantity(availableQuantity - quantity);
                repository.save(item);
                kafkaInventoryProducer.sendMessage(item); // Send updated inventory item details to Kafka
            } else {
                // Handle insufficient inventory
                throw new IllegalArgumentException("Insufficient quantity available for item: " + item.getName());
            }
        }
    }

    // Other methods based on your business requirements
}
