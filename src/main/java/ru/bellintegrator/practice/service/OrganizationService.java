package ru.bellintegrator.practice.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/*
Сервис организации
 */
@Validated
public class OrganizationService {


    /**
     * Добавить новую компанию в БД
     *
     * @param organization
     */
    void addOrganization(@Valid OrganizationView organizationView);

    /**
     * Получить список организаций
     *
     * @return {@Organization}
     */
    List<OrganizationView> organizations();
}
