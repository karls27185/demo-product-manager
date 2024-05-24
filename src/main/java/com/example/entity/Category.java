package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс Category представляет собой сущность (entity) в контексте объектно-ориентированного программирования и объектно-реляционного отображения (ORM).
 * Этот класс предназначен для хранения информации о категориях товаров или других объектах, которые могут быть классифицированы.
 * */
@Entity //Аннотация @Entity указывает, что класс является сущностью и будет сопоставлен с таблицей в базе данных.
@Data //Аннотация @Data генерирует методы получения и установки для всех полей класса, а также методы equals(), hashCode() и toString().
@Builder //Аннотация @Builder генерирует статический метод builder(), который позволяет создавать экземпляры класса с использованием удобного синтаксиса.
@NoArgsConstructor //Аннотация @NoArgsConstructor генерирует конструктор без аргументов.
@AllArgsConstructor //Аннотация @AllArgsConstructor генерирует конструктор со всеми аргументами.
public class Category {

    /**
     * Поле id — первичный ключ сущности. Оно помечено аннотацией @Id, чтобы указать, что это поле является первичным ключом.
     * Также поле помечено аннотацией @GeneratedValue, чтобы указать, что значение первичного ключа будет сгенерировано автоматически.
     * Стратегия генерации указана как GenerationType.IDENTITY, что означает, что первичный ключ будет сгенерирован автоматически на основе последовательности или столбца идентичности в базе данных.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Поле name — название категории. Это обычное поле сущности, которое может содержать текстовую информацию.
     * */
    private String name;
}