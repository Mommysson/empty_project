package ru.bellintegrator.practice.dao;

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
    List<Organization> getOrganizations(String name, Long inn,boolean is_Active);

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return Organization
     */
    Organization getOrganization(Long id);

    /**
     * Обновить организацию по параметрам
     *
     * @param organization
     */
    void updateOrganization(Organization organization);
}
