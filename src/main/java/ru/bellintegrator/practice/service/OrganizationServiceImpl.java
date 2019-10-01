package ru.bellintegrator.practice.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.dao.OrganizationDaoImpl;
import ru.bellintegrator.practice.model.Organization;

import javax.validation.Valid;
import java.util.List;


/*
Сервис организации
 */
@Validated
public class OrganizationServiceImpl implements OrganizationService{

    OrganizationDaoImpl organizationDaoImpl;



    /**
     * Получить организацию по идентификатору
     *@param name
     *@param inn
     *@param isActive
     * @return {@Organization}
     */
    @Override
    public List<Organization> getOrganizations(String name, Long inn, boolean isActive) {
        return organizationDaoImpl.getOrganizations(name,inn,isActive);
    }
    /**
     * Получить организацию по идентификатору
     *@param id
     * @return {@Organization}
     */
    @Override
    public Organization getOrganization(Long id) {
        return organizationDaoImpl.getOrganization(id);
    }
    /**
     * Обновить организацию
     *@param organization
     */
    @Override
    public void updateOrganization(Organization organization) {
        organizationDaoImpl.updateOrganization(organization);
    }

}
