package com.example.repository;

import com.example.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Класс CategoryRepository является интерфейсом репозитория, который расширяет интерфейс JpaRepository и предназначен для работы с сущностями типа Category.<p>
 * Интерфейс JpaRepository предоставляет методы для работы с сущностями, включая методы для сохранения, обновления, удаления и поиска сущностей.
 * Параметры типа Category, Long указывают, что репозиторий будет работать с сущностями типа Category и использовать Long в качестве идентификатора сущности.<p>
 * Поскольку CategoryRepository является интерфейсом, он не содержит методов. Методы будут реализованы в классе, который реализует этот интерфейс.<p>
 * Этот репозиторий можно использовать для выполнения операций с категориями, таких как создание, чтение, обновление и удаление категорий.
 * */
@Repository //Аннотация @Repository указывает, что класс является компонентом Spring и будет использоваться для управления транзакциями и другими функциями Spring.
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
