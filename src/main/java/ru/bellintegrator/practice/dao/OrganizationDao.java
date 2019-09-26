package ru.bellintegrator.practice.dao;

import ru.bellintegrator.practice.model.Organization;

import java.util.List;

/*
* Dao для работы с Organization
 */

public interface OrganizationDao {

    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> getAllOrganizations();

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization getOrganizationById(Long id);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void saveOrganization(Organization organization);
}
