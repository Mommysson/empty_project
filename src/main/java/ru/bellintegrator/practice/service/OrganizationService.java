package ru.bellintegrator.practice.service;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bellintegrator.practice.model.Organization;
import java.util.List;

@Validated
public interface OrganizationService {


    /**
     * Получить список по параметрам
     *
     * @param name
     * @param inn
     * @param is_Active
     * @return List
     */
    List <Organization> getOrganizations(String name, Long inn, boolean is_Active);

    /**
     * Получить организацию по id
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
