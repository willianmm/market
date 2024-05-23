package com.example.market.controller.item;

public record ItemResponseDTO(Long id, String title, String image, Integer price) {
    public ItemResponseDTO(Item item){
        this(item.getId(), item.getTitle(), item.getImage(), item.getPrice());
    }

}
