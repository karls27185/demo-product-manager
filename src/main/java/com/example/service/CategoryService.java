package com.example.service;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс CategoryService представляет собой сервис, который отвечает за работу с категориями товаров.
 * Сервис использует репозиторий CategoryRepository для взаимодействия с базой данных.
 * */
@Service //Аннотация @Service указывает, что класс является сервисом Spring и будет использоваться для выполнения бизнес-логики приложения.
@AllArgsConstructor //Аннотация @AllArgsConstructor генерирует конструктор, который принимает все поля класса в качестве параметров. В данном случае это поле categoryRepository, которое является зависимостью класса.
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * Метод readAll() — читает все категории из базы данных. Вызывает метод findAll() репозитория CategoryRepository.
     * */
    public List<Category> readAll() {
        return categoryRepository.findAll();
    }

    /**
     * Метод readById(Long id) — читает категорию по идентификатору. Вызывает метод findById(id) репозитория CategoryRepository и возвращает результат.
     * Если категория не найдена, выбрасывается исключение RuntimeException с сообщением «Category not found».
     * */
    public Category readById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not found - " + id));
    }
}
