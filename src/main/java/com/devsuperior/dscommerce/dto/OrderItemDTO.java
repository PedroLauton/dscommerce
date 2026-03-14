package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String imagUrl;

    public OrderItemDTO(Long id, String name, Double price, Integer quantity,String imagUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imagUrl = imagUrl;
    }

    public OrderItemDTO(OrderItem orderItem) {
        this.id = orderItem.getProduct().getId();
        this.name = orderItem.getProduct().getName();
        this.price = orderItem.getProduct().getPrice();
        this.quantity = orderItem.getQuantity();
        this.imagUrl = orderItem.getProduct().getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    public String getImagUrl() {
        return imagUrl;
    }
}
