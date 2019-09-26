package ru.bellintegrator.practice.dao;

import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;

import java.util.List;

/*
 * Dao для работы с Office
 */

public interface OfficeDao {

    /**
     * Получить все объекты Office
     *
     * @return
     */
    List<Office> getAllOffices();

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return
     */
    Office getOfficeById(Long id);

    /**
     * Сохранить Office
     *
     * @param office
     */
    void saveOffice(Office office);
}
