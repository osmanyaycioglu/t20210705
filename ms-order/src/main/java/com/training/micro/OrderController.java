package com.training.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public String place(@RequestBody final Order order) {
        return this.orderService.place(order);
    }

    @PostMapping("/place2")
    public String place2(@RequestBody final Order order) {
        return this.orderService.place2(order);
    }

    @PostMapping("/place3")
    public String place3(@RequestBody final Order order) {
        return this.orderService.place3(order);
    }

}
