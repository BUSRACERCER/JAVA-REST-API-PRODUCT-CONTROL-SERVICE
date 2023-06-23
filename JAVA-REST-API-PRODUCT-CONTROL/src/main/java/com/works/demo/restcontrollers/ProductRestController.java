package com.works.demo.restcontrollers;

import com.works.demo.entities.Product;
import com.works.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductRestController {
    final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Product product) {

        return productService.save(product);

    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return productService.list();

    }

    @GetMapping("/delete/{pid}")
    public ResponseEntity delete(@PathVariable Long pid) {
        return productService.delete(pid);

    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Product product) {
        return productService.update(product);
    }


}
