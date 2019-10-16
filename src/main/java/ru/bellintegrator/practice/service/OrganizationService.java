package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.OrganizationDto;
import java.util.List;

public interface OrganizationService {

    /**
     * Получить список по параметрам
     * @param name
     * @param inn
     * @param is_Active
     * @return List
     */
    List <OrganizationDto> getByParams(String name, int inn, boolean is_Active);

    /**
     * Получить организацию по id
     * @param id
     * @return OrganizationDto
     */
    OrganizationDto getById(String id);

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
