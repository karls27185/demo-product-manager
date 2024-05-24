package com.example.service;

import com.example.dto.ProductDTO;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс ProductService — предоставляет набор методов для работы с продуктами.
 * Является сервисом, который может быть использован другими компонентами системы.
 * */

@Service //указывает, что класс является сервисом (service) и может быть автоматически обнаружен и использован фреймворком для внедрения зависимостей (dependency injection)
@AllArgsConstructor //генерирует конструктор, который принимает все поля класса в качестве параметров. В данном случае это поля productRepository и categoryService, которые являются зависимостями класса
public class ProductService {

    private final ProductRepository productRepository; //ссылка на интерфейс ProductRepository, который используется для работы с базой данных продуктов
    private final CategoryService categoryService; //ссылка на интерфейс CategoryService, который используется для работы с категориями продуктов

    /**
     * Метод create принемает в параметрах dto из запроса затем из него формирует обект product и спомощью репозирория созраняет его в базу данных используе builder который прописан в entity<p>
     * создаёт новый продукт на основе данных из ProductDTO. Вызывает метод save интерфейса ProductRepository для сохранения нового продукта в базе данных.
     * */
    public Product create(ProductDTO dto) {
        return productRepository.save(Product.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .category(categoryService.readById(dto.getCategoryId()))
                .build());
    }

    /**
     * Метод readAll читает все продукты из базы данных. Вызывает метод findAll интерфейса ProductRepository.
     * */
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    /**
     * Метод readByCategoryId читает продукты, принадлежащие к определённой категории. Вызывает метод findByCategoryId интерфейса ProductRepository.
     * */
    public List<Product> readByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    /**
     * Метод update обновляет существующий продукт. Вызывает метод save интерфейса ProductRepository.
     * */
    public Product update(Product product) {
        return productRepository.save(product);
    }

    /**
     * Метод delete удаляет продукт по идентификатору. Вызывает метод deleteById интерфейса ProductRepository.
     * */
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}