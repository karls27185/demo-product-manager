package com.example.dto;

import lombok.Data;

/**
 * Класс ProductDTO представляет собой DTO (Data Transfer Object) для продукта.
 * Он содержит информацию о продукте, такую как его название, количество и идентификатор категории.
 * Класс предназначен для передачи данных между слоями приложения или для сериализации/десериализации данных.
 * */

@Data
public class ProductDTO {

    private String name;
    private Short amount;
    private Long categoryId;
}
