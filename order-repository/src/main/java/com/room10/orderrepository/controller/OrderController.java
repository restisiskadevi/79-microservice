package com.room10.orderrepository.controller;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("order")
@RestController
public class OrderController {
    @PostMapping("/")
    @Transactional
    public ResponseEntity<Boolean> order(@RequestBody Order order) {
        callAPI(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private static void callAPI(Order order) {
        String requestParam = "?skuCode="+order.getSkuCode()+"&stock="+order.getStock();
        final String uri = "http://localhost:8001/item/item-taken" + requestParam;

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(uri, null);

        System.out.println("API is success");
    }

    @Data
    @NoArgsConstructor
    public static class Order {
        private String skuCode;
        private Integer stock;
    }
}
