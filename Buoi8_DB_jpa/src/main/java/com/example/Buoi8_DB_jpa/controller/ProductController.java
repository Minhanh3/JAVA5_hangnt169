package com.example.Buoi8_DB_jpa.controller;

import com.example.Buoi8_DB_jpa.entity.Product;
import com.example.Buoi8_DB_jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("getAllProduct")
    public String getAllProduct(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("/page")
    @ResponseBody
    public List<Product> phanTrang(@RequestParam(defaultValue = "3", required = false) Integer size,
                                   @RequestParam(defaultValue = "0", required = false) Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<Product> products = productRepository.findAll(pageable);
        return products.getContent();
    }

    @GetMapping("edit/{id}")
    public String editProduct(@PathVariable long id, Model model) {
        Product product = productRepository.findById(id).get();
        model.addAttribute("data", product);
        return "edit";
    }

    @PostMapping("update/{id}")
    public String updateProduct(Product product) {
        productRepository.save(product);
        return "redirect:/product/getAllProduct";
    }
}
