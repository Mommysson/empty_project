package ru.bellintegrator.practice.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.dto.OrganizationDTO;
import ru.bellintegrator.practice.model.Organization;
import java.util.List;

@Validated
public interface OrganizationService {


    /**
     * Получить список по параметрам
     *
     * @param organizationDTO
     * @return List
     */
    List <OrganizationDTO> getByName(OrganizationDTO organizationDTO);

    /**
     * Получить организацию по id
     *
     * @param uuid

     * @return Organization
     */
    OrganizationDTO getById(String uuid);

    /**
     * Обновить организацию по параметрам
     *
     * @param organization
      */
    void update(Organization organization);

}
