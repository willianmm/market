package com.example.market.controller;

import com.example.market.controller.item.Item;
import com.example.market.controller.item.ItemRequestDTO;
import com.example.market.controller.item.ItemResponseDTO;
import com.example.market.controller.item.ItemsRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("item")

public class ItemsController {
    @Autowired
    private ItemsRepository repository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping
    public void saveItem(@RequestBody ItemRequestDTO data){
        Item itemData = new Item(data);
        repository.save(itemData);
        return;


    }
    @GetMapping
    public  List<ItemResponseDTO> getAll(){
        List<ItemResponseDTO> itemList = repository.findAll().stream().map(ItemResponseDTO::new).toList();
        return itemList;
    }
}
