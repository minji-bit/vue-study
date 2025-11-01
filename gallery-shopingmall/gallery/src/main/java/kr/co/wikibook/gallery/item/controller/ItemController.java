package kr.co.wikibook.gallery.item.controller;

import kr.co.wikibook.gallery.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @GetMapping("/api/items")
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(itemService.findAll());
    }
}
