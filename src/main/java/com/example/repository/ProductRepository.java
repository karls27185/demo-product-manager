package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *Класс ProductRepository является интерфейсом репозитория, который расширяет интерфейс JpaRepository и предназначен для работы с сущностями типа Product.<p>
 * Интерфейс JpaRepository предоставляет методы для работы с сущностями, включая методы для сохранения, обновления, удаления и поиска сущностей.
 * Параметры типа Product, Long указывают, что репозиторий будет работать с сущностями типа Product и использовать Long в качестве идентификатора сущности.
 * */

@Repository //Аннотация @Repository указывает, что класс является компонентом Spring и будет использоваться для управления транзакциями и другими функциями Spring.
public interface ProductRepository  extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long id); //метод, который возвращает список продуктов, принадлежащих к определённой категории
}
