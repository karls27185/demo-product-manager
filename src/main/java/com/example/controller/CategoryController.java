package com.example.controller;

import com.example.entity.Category;
import com.example.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Класс CategoryController представляет собой контроллер, который отвечает за обработку запросов к категориям товаров.
 * Контроллер использует сервис CategoryService для взаимодействия с базой данных.
 * */
@RestController //Аннотация @RestController указывает, что класс является контроллером Spring MVC и будет использоваться для обработки HTTP-запросов.
@RequestMapping("/categories") //Аннотация @RequestMapping("/categories") указывает, что контроллер обрабатывает запросы к пути /categories.
@AllArgsConstructor //Аннотация @AllArgsConstructor генерирует конструктор, который принимает все поля класса в качестве параметров. В данном случае это поле categoryService, которое является зависимостью класса.
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * Метод readAll() — читает все категории из базы данных.
     * Вызывает метод readAll() сервиса CategoryService и возвращает результат в виде объекта ResponseEntity.
     * Объект ResponseEntity содержит список категорий и статус ответа HTTP.
     * */
    @GetMapping
    public ResponseEntity<List<Category>> readAll() {
        return new ResponseEntity<>(categoryService.readAll(), HttpStatus.OK);
    }
}
