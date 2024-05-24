package com.example.controller;

import com.example.dto.ProductDTO;
import com.example.entity.Product;
import com.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс ProductController представляет собой контроллер в архитектуре MVC, который обрабатывает запросы к /products и обеспечивает взаимодействие с базой данных через сервис ProductService.
 * */
@RestController //Аннотация @RestController указывает, что класс является контроллером RESTful и будет обрабатывать HTTP-запросы.
@RequestMapping("/products") //Аннотация @RequestMapping("/products") указывает, что класс обрабатывает запросы к /products.
@AllArgsConstructor //Аннотация @AllArgsConstructor генерирует конструктор, который принимает все поля класса в качестве параметров. В данном случае это поле productService, которое является зависимостью класса.
public class ProductController {

    private final ProductService productService; //Поле productService — ссылка на ProductService, который используется для работы с базой данных продуктов.

    /**
     * Метод create(@RequestBody ProductDTO dto) — создаёт новый продукт на основе данных из ProductDTO.
     * Вызывает метод create сервиса ProductService для сохранения нового продукта в базе данных.
     * */
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        return mappingResponseProduct(productService.create(dto));
    }

    /**
     * Метод readAll() — читает все продукты из базы данных.
     * Вызывает метод readAll сервиса ProductService.
     * */
    @GetMapping
    public ResponseEntity<List<Product>> readAll() {
        return mappingResponseListProduct(productService.readAll());
    }

    /**
     * Метод readByCategoryId(@PathVariable Long id) — читает продукты, принадлежащие к определённой категории.
     * Вызывает метод readByCategoryId сервиса ProductService.
     * */
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> readByCategoryId(@PathVariable Long id) {
        return mappingResponseListProduct(productService.readByCategoryId(id));
    }

    /**
     * Метод update(@RequestBody Product product) — обновляет существующий продукт.
     * Вызывает метод update сервиса ProductService.
     * */
    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return mappingResponseProduct(productService.update(product));
    }

    /**
     * Метод delete(@PathVariable Long id) — удаляет продукт по идентификатору.
     * Вызывает метод delete сервиса ProductService.
     * */
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        productService.delete(id);
        return HttpStatus.OK;
    }

    /**
     * Методы mappingResponseProduct(Product product) и mappingResponseListProduct(List<Product> products) — создают ответ клиенту.
     * Первый метод возвращает объект Product, второй — список объектов Product.
     * */
    private ResponseEntity<Product> mappingResponseProduct(Product product) {
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    private ResponseEntity<List<Product>> mappingResponseListProduct(List<Product> products) {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
