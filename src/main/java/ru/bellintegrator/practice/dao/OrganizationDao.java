package ru.bellintegrator.practice.dao;

import ru.bellintegrator.practice.dto.OrganizationDto;
import ru.bellintegrator.practice.model.Organization;
import java.util.List;

/*
* Dao для работы с Organization
 */
public interface OrganizationDao {

    /**
     * Получить объекты Organization
     *@param name
     * @param inn
     * @param is_Active
     * @return List
     */
    List<Organization> getByParams(String name, int inn,boolean is_Active);

    /**
     * Получить Organization по идентификатору
     * @param uuid
     * @return Organization
     */
    Organization getById(String uuid);

    /**
     * Обновить организацию по параметрам
     * @param orgDto
     */

    void update(OrganizationDto orgDto);

    /**
     * Сохранить организацию
     * @param orgDto
     */
    void save(OrganizationDto orgDto);

    /**
     * Удалить организацию по id
     * @param id
     */
    void delete(String id);
}
